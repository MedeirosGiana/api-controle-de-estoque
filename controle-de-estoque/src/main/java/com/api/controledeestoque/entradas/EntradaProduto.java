package com.api.controledeestoque.entradas;

import com.api.controledeestoque.produtos.Produto;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "Entrada")
public class EntradaProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Produto produto;

    @Column(nullable = false)
    private LocalDateTime dataEntrada;

    @Column(nullable = false)
    private Double precoUnitario;

    @Column(nullable = false)
    private Integer quantidade;

    public EntradaProduto(Produto produto, LocalDateTime dataEntrada, Double precoUnitario, Integer quantidade) {
        this.produto = produto;
        this.dataEntrada = dataEntrada;
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
    }

    public EntradaProduto (){
    }

    public long getId() {
        return id;
    }

    public Produto getProduto() {
        return produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }
}
