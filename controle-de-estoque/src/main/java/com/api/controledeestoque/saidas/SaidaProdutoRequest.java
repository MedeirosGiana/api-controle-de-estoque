package com.api.controledeestoque.saidas;

import com.api.controledeestoque.produtos.Produto;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDateTime;

public class SaidaProdutoRequest {
    @NotNull
    @PositiveOrZero
    private Integer quantidade;
    @PastOrPresent
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataSaida;

    public SaidaProdutoRequest(@NotNull Integer quantidade, LocalDateTime dataSaida) {

        this.quantidade = quantidade;
        this.dataSaida=dataSaida;
    }
    public SaidaProduto toModelo(Produto produto){

        return new SaidaProduto(produto,quantidade,dataSaida);
    }
}
