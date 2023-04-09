package com.api.controledeestoque.produtos;

public class ProdutoResponse {
    private Long id;
    private String nome;
    private Integer quantidade;

    public ProdutoResponse(Long id, String nome, Integer quantidade) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public ProdutoResponse(Produto produto) {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }
}
