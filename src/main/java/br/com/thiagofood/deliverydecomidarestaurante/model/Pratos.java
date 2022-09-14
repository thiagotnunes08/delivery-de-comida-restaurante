package br.com.thiagofood.deliverydecomidarestaurante.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Pratos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private BigDecimal preco;

    @Column(nullable = false)
    private String descricao;

    public Pratos(String nome, BigDecimal preco, String descricao) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
    }

    @Deprecated // hibernate
    public Pratos() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }
}
