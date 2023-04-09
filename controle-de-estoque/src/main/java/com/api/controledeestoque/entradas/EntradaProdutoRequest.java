package com.api.controledeestoque.entradas;

import com.api.controledeestoque.produtos.Produto;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.Optional;

public class EntradaProdutoRequest {

    @NotNull
    @Positive
    private Integer quantidade;

    @NotNull
    @PositiveOrZero
    private Double precoUnitario;

    @PastOrPresent
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataEntrada;

    public EntradaProdutoRequest(@NotNull Integer quantidade, @NotNull Double precoUnitario, LocalDateTime dataEntrada) {
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.dataEntrada = dataEntrada;
    }
    public EntradaProduto toModelo(Produto produto){
        return new EntradaProduto(produto,dataEntrada,precoUnitario,quantidade);

    };

    public Integer getQuantidade() {
        return quantidade;
    }

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    public LocalDateTime getDataEntrada() {
        return dataEntrada;
    }
}
