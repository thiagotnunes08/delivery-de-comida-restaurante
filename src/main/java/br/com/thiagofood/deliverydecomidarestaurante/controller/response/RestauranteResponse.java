package br.com.thiagofood.deliverydecomidarestaurante.controller.response;

import br.com.thiagofood.deliverydecomidarestaurante.model.Classificacao;
import br.com.thiagofood.deliverydecomidarestaurante.model.FaixaDePreco;
import br.com.thiagofood.deliverydecomidarestaurante.model.Restaurante;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RestauranteResponse {
    private Long id;

    private String nomeFantasia;

    private String razaoSocial;

    private String email;

    private String telefone;

    private String documento;

    private String responsavelNome;

    private String responsavelTelefone;

    private String descricao;

    private Classificacao classificacao;

    private FaixaDePreco faixaDePreco;

    private String endereco;

    private String horarioFuncionamento;

    private LocalDateTime criadoEm;

    private LocalDateTime atualizadoEm;

    private Boolean isAtivo;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PratosResponse> pratos = new ArrayList<>();
    public RestauranteResponse(Restaurante restaurante, Boolean listaPratos) {
        this.id = restaurante.getId();
        this.nomeFantasia = restaurante.getNomeFantasia();
        this.razaoSocial = restaurante.getRazaoSocial();
        this.email = restaurante.getEmail();
        this.telefone= restaurante.getTelefone();
        this.documento= restaurante.getDocumento();
        this.responsavelNome= restaurante.getResponsavelNome();
        this.responsavelTelefone= restaurante.getResponsavelTelefone();
        this.descricao= restaurante.getDescricao();
        this.classificacao = restaurante.getClassificacao();
        this.faixaDePreco = restaurante.getFaixaDePreco();
        this.endereco = restaurante.getEndereco();
        this.horarioFuncionamento = restaurante.getHorarioFuncionamento();
        this.criadoEm = restaurante.getCriadoEm();
        this.atualizadoEm = restaurante.getAtualizadoEm();
        this.isAtivo = restaurante.getAtivo();
        if (listaPratos){
            this.pratos = restaurante.getPratos().stream().map(PratosResponse::new).collect(Collectors.toList());
        }

    }

    public Long getId() {
        return id;
    }

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

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public LocalDateTime getAtualizadoEm() {
        return atualizadoEm;
    }

    public Boolean getAtivo() {
        return isAtivo;
    }

    public List<PratosResponse> getPratos() {
        return pratos;
    }
}
