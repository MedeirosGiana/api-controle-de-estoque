package com.api.controledeestoque.saidas;


import com.api.controledeestoque.produtos.Produto;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "Saída")
public class SaidaProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Produto produto;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(nullable = false)
    private LocalDateTime dataSaida;

    public SaidaProduto(Produto produto, Integer quantidade, LocalDateTime dataSaida) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.dataSaida = dataSaida;
    }
    public SaidaProduto(){

    }

    public Long getId() {
        return id;
    }

    public Produto getProduto() {
        return produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }
}
