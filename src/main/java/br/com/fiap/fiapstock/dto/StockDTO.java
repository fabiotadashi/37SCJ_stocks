package br.com.fiap.fiapstock.dto;

import br.com.fiap.fiapstock.model.Stock;

import java.math.BigDecimal;
import java.util.Date;

public class StockDTO {

    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal valor;
    private Boolean ativo;
    private Date dataCriacao;

    public StockDTO(){}

    public StockDTO(Stock stock) {
        this.id = stock.getId();
        this.nome = stock.getNome();
        this.descricao = stock.getDescricao();
        this.valor = stock.getValor();
        this.ativo = stock.getAtivo();
        this.dataCriacao = stock.getDataCriacao();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
