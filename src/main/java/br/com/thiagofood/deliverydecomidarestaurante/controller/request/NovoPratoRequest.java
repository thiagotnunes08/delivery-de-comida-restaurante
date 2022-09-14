package br.com.thiagofood.deliverydecomidarestaurante.controller.request;

import br.com.thiagofood.deliverydecomidarestaurante.model.Pratos;

import javax.persistence.Column;
import java.math.BigDecimal;

public class NovoPratoRequest {

    private String nome;

    private BigDecimal preco;

    private String descricao;

    public String getNome() {
        return nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public Pratos toModel() {
        return new Pratos(nome,preco,descricao);
    }
}
