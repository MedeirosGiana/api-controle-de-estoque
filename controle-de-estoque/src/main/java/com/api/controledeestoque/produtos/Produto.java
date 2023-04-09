package com.api.controledeestoque.produtos;

import com.api.controledeestoque.entradas.EntradaProduto;
import com.api.controledeestoque.saidas.SaidaProduto;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false,unique = true)
    private String nome;
    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false)
    private Integer quantidadeMin;
    @Column(nullable = false)
    private Integer quantidadeMax;
    @Column(nullable = false)
    private LocalDateTime dataCriacao;

    public Produto(String nome, String descricao, Integer quantidadeMin, Integer quantidadeMax) {
        this.nome = nome;
        this.descricao = descricao;
        this.quantidadeMin = quantidadeMin;
        this.quantidadeMax = quantidadeMax;
    }

    public Produto(){

    }
    public Produto(Long id){
        this.id = id;

    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void adicionarEntrada(EntradaProduto entradaProduto) {
    }
    public void adicionarSaida(SaidaProduto saida) {
    }
}
