package br.com.thiagofood.deliverydecomidarestaurante.controller.response;

import br.com.thiagofood.deliverydecomidarestaurante.model.FaixaDePreco;
import br.com.thiagofood.deliverydecomidarestaurante.model.Restaurante;

public class DetalheRestauranteResponse {

    private Long id;
    private String nomeFantasia;
    private String endereco;
    private String descricao;
    private FaixaDePreco faixaDePreco;

    public DetalheRestauranteResponse(Restaurante restaurante) {
        this.id = restaurante.getId();
        this.nomeFantasia = restaurante.getNomeFantasia();
        this.endereco = restaurante.getEndereco();
        this.descricao = restaurante.getDescricao();
        this.faixaDePreco= restaurante.getFaixaDePreco();

    }

    public Long getId() {
        return id;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getDescricao() {
        return descricao;
    }

    public FaixaDePreco getFaixaDePreco() {
        return faixaDePreco;
    }
}
