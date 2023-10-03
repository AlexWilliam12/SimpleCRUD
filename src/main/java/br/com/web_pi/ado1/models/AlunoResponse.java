package br.com.web_pi.ado1.models;

import java.math.BigDecimal;

public class AlunoResponse {
    private String ra;

    private String nome;

    private Endereco endereco;

    private BigDecimal notaAdo1;

    private BigDecimal notaPi;

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public BigDecimal getNotaAdo1() {
        return notaAdo1;
    }

    public void setNotaAdo1(BigDecimal notaAdo1) {
        this.notaAdo1 = notaAdo1;
    }

    public BigDecimal getNotaPi() {
        return notaPi;
    }

    public void setNotaPi(BigDecimal notaPi) {
        this.notaPi = notaPi;
    }

    public AlunoResponse() {
    }

    public AlunoResponse(String ra, String nome, Endereco endereco, BigDecimal notaAdo1, BigDecimal notaPi) {
        this.ra = ra;
        this.nome = nome;
        this.endereco = endereco;
        this.notaAdo1 = notaAdo1;
        this.notaPi = notaPi;
    }
}
