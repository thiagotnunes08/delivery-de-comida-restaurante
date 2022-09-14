package br.com.thiagofood.deliverydecomidarestaurante.model;


import br.com.thiagofood.deliverydecomidarestaurante.controller.request.AtualizaRestauranteRequest;
import br.com.thiagofood.deliverydecomidarestaurante.controller.request.NovoPratoRequest;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Entity
  //@Table(uniqueConstraints = @UniqueConstraint(name = "UK_CPFORCNPJ_AND_EMAIL", columnNames = {"documento", "email"}))
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomeFantasia;

    @Column(nullable = false)
    private String razaoSocial;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private String documento;

    @Column(nullable = false)
    private String responsavelNome;

    @Column(nullable = false)
    private String responsavelTelefone;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Classificacao classificacao;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private FaixaDePreco faixaDePreco;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private String horarioFuncionamento;

    @Column(nullable = false)
    private LocalDateTime criadoEm = LocalDateTime.now();

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime atualizadoEm;

    @Column(nullable = false)
    private Boolean isAtivo = true;

    @JoinColumn(name = "restaurante_id")
    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private List<Pratos> pratos = new ArrayList<>();


    @Deprecated // hibernate!
    public Restaurante() {
    }


    public Restaurante(String nomeFantasia, String razaoSocial, String email, String telefone, String documento, String responsavelNome, String responsavelTelefone, String descricao, Classificacao classificacao, FaixaDePreco faixaDePreco, String endereco, String horarioFuncionamento) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.email = email;
        this.telefone = telefone;
        this.documento = documento;
        this.responsavelNome = responsavelNome;
        this.responsavelTelefone = responsavelTelefone;
        this.descricao = descricao;
        this.classificacao = classificacao;
        this.faixaDePreco = faixaDePreco;
        this.endereco = endereco;
        this.horarioFuncionamento = horarioFuncionamento;
    }

    public Long getId() {
        return id;
    }

    public void atualiza(AtualizaRestauranteRequest request) {
        request.getNomeFantasia().ifPresent(possivelNome -> nomeFantasia = possivelNome);

        request.getEmail().ifPresent(possivelEmail -> email = possivelEmail);

        request.getTelefone().ifPresent(possivelTelefone -> telefone = possivelTelefone);

        request.getCelularDoResponsavel().ifPresent(possivelCelular -> responsavelTelefone = possivelCelular);

        request.getDescricao().ifPresent(possivelDescricao -> descricao = possivelDescricao);

        request.getClassificacao().ifPresent(possivelClassificacao -> classificacao = possivelClassificacao);

        request.getFaixaDePreco().ifPresent(possivelPreco -> faixaDePreco = possivelPreco);

    }

    public void inativa() {
        isAtivo = false;
    }

    public void adiciona(NovoPratoRequest request) {

      Pratos novoPrato =  request.toModel();

      this.pratos.add(novoPrato);

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

    public List<Pratos> getPratos() {
        return pratos;
    }
}
