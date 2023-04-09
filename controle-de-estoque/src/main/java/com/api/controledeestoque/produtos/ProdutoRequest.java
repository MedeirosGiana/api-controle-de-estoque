package com.api.controledeestoque.produtos;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

public class ProdutoRequest {


    private String nome;
    private String descricao;
    private Integer quantidadeMinima;
    private Integer quantidadeMaxima;

    public ProdutoRequest(String nome, String descricao, Integer quantidadeMinima, Integer quantidadeMaxima) {
        this.nome = nome;
        this.descricao = descricao;
        this.quantidadeMinima = quantidadeMinima;
        this.quantidadeMaxima = quantidadeMaxima;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Integer getQuantidadeMinima() {
        return quantidadeMinima;
    }

    public Integer getQuantidadeMaxima() {
        return quantidadeMaxima;
    }
    public Produto toModelo;

    public Produto toModelo(){
        return new Produto(nome,descricao,quantidadeMinima,quantidadeMaxima);
    };
}
