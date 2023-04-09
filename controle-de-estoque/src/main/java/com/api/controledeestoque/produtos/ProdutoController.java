package com.api.controledeestoque.produtos;

import com.api.controledeestoque.entradas.EntradaProduto;
import com.api.controledeestoque.entradas.EntradaProdutoRequest;
import com.api.controledeestoque.entradas.EntradaProdutoResponse;
import com.api.controledeestoque.saidas.SaidaProduto;
import com.api.controledeestoque.saidas.SaidaProdutoRequest;
import com.api.controledeestoque.saidas.SaidaProdutoResponse;
import com.api.controledeestoque.tratamentos.Erros;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @PersistenceContext
    private final EntityManager manager;
    private ProdutoRepository repository;
    private SaidaProduto saidaProduto;

    public ProdutoController(EntityManager manager, ProdutoRepository repository) {
        this.manager = manager;
        this.repository = repository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrarProduto(@RequestBody @Valid ProdutoRequest produtoRequest, UriComponentsBuilder uriBuilder) {
        Produto produto = produtoRequest.toModelo;
        manager.persist(produto);
        URI uri = uriBuilder.path("/produtos/{id}").buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).body(new ProdutoResponse(produto));
    }

    @RequestMapping("/{id}/entradas")
    @Transactional
    public ResponseEntity<?> realizarEntrada(@RequestBody @Valid EntradaProdutoRequest entrada, @PathVariable Long id, UriComponentsBuilder uriBuilder) {
        Optional<Produto> produto = repository.findById(id);
        if (produto.isEmpty()) {
            Erros error = new Erros("Produto", "Não existe cadastro deste produto");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
        EntradaProduto entradaProduto = entrada.toModelo(produto.get());
        manager.persist(entradaProduto);
        produto.get().adicionarEntrada(entradaProduto);
        URI uri = uriBuilder.path("/produtos/{id}/entradas/{idEntrada}").buildAndExpand(Map.of("id", produto.get().getId(), "idEntrada", entradaProduto.getId())).toUri();
        return ResponseEntity.created(uri).body(new EntradaProdutoResponse(entradaProduto));
    }

    public ResponseEntity<?> realizarSaida(@RequestBody @Valid SaidaProdutoRequest saida, @PathVariable Long id, UriComponentsBuilder uriBuilder) {
        Optional<Produto> produto = repository.findById(id);
        if (produto.isEmpty()) {
            Erros error = new Erros("Produto", "não existe cadastro desse produto.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
            manager.persist(saidaProduto);
            produto.get().adicionarSaida(saidaProduto);
            URI uri = uriBuilder.path("/produtos/{id}/saida/{idSaida}").buildAndExpand(produto.get().getId(), saidaProduto.getId()).toUri();
            return ResponseEntity.created(uri).body(new SaidaProdutoResponse(saidaProduto));
        }

}


