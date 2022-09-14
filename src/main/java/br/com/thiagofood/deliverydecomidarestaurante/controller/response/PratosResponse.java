package br.com.thiagofood.deliverydecomidarestaurante.controller.response;

import br.com.thiagofood.deliverydecomidarestaurante.model.Pratos;

import javax.persistence.Column;
import java.math.BigDecimal;

public class PratosResponse {

    private Long id;

    private String nome;

    private BigDecimal preco;

    private String descricao;

    public PratosResponse(Pratos pratos) {
        this.id = pratos.getId();
        this.nome = pratos.getNome();
        this.preco = pratos.getPreco();
        this.descricao = pratos.getDescricao();
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
