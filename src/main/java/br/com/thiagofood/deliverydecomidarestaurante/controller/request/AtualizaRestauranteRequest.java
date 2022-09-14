package br.com.thiagofood.deliverydecomidarestaurante.controller.request;

import br.com.thiagofood.deliverydecomidarestaurante.model.Classificacao;
import br.com.thiagofood.deliverydecomidarestaurante.model.FaixaDePreco;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.Optional;

public class AtualizaRestauranteRequest {

    private String nomeFantasia;
    @Pattern(regexp = "^\\+[1-9][0-9]\\d{1,14}$")
    private String telefone;
    @Email
    private String email;
    private String celularDoResponsavel;

    private String descricao;
    private Classificacao classificacao;
    private FaixaDePreco faixaDePreco;


    public Optional<String> getNomeFantasia() {
        return Optional.ofNullable(nomeFantasia);
    }

    public Optional<String> getTelefone() {
        return Optional.ofNullable(telefone);
    }

    public Optional<String> getEmail() {
        return Optional.ofNullable(email);
    }

    public Optional<String> getCelularDoResponsavel() {
        return Optional.ofNullable(celularDoResponsavel);
    }

    public Optional<String> getDescricao() {
        return Optional.ofNullable(descricao);
    }

    public Optional<Classificacao> getClassificacao() {
        return Optional.ofNullable(classificacao);
    }

    public Optional<FaixaDePreco> getFaixaDePreco() {
        return Optional.ofNullable(faixaDePreco);
    }
}
