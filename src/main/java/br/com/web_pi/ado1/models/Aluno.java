package br.com.web_pi.ado1.models;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Aluno {

    @Id
    private String ra;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, length = 8)
    private String cep;

    @Column(nullable = false)
    private Integer numero;

    @Column(nullable = false, length = 45)
    private String complemento;

    @Column(nullable = false, precision = 4, scale = 2)
    private BigDecimal notaAdo1;

    @Column(nullable = false, precision = 4, scale = 2)
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
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

}
