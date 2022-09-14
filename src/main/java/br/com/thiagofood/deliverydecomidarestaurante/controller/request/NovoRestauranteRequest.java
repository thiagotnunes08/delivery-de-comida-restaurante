package br.com.thiagofood.deliverydecomidarestaurante.controller.request;

import br.com.thiagofood.deliverydecomidarestaurante.model.Classificacao;
import br.com.thiagofood.deliverydecomidarestaurante.model.FaixaDePreco;
import br.com.thiagofood.deliverydecomidarestaurante.model.Restaurante;
import br.com.thiagofood.deliverydecomidarestaurante.util.CPForCNPJ;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class NovoRestauranteRequest {

    @NotBlank
    private String nomeFantasia;
    private String razaoSocial;
    @NotBlank
    @Email
    private String email;
    private String telefone;
    @CPForCNPJ
    @NotBlank
    private String documento;
    @NotBlank
    private String responsavelNome;
    private String responsavelTelefone;
    private String descricao;

    private Classificacao classificacao;

    private FaixaDePreco faixaDePreco;
    private String endereco;
    private String horarioFuncionamento;

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getDocumento() {
        return documento;
    }

    public String getResponsavelNome() {
        return responsavelNome;
    }

    public String getResponsavelTelefone() {
        return responsavelTelefone;
    }

    public String getDescricao() {
        return descricao;
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public FaixaDePreco getFaixaDePreco() {
        return faixaDePreco;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getHorarioFuncionamento() {
        return horarioFuncionamento;
    }

    public Restaurante toModel() {
        return new Restaurante(
                nomeFantasia,
                razaoSocial,
                email,telefone
                ,documento,
                responsavelNome,
                descricao,
                descricao,
                classificacao,
                faixaDePreco,
                endereco,
                horarioFuncionamento
        );
    }


}
