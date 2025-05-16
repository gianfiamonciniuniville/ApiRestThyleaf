package com.example.ApiRestThyleaf.Entity;

import jakarta.persistence.*;

@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String capital;
    private String continente;
    @Column(name = "bandeira_url_imagem")
    private String bandeiraUrlImagem;

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

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public String getBandeiraUrlImagem() {
        return bandeiraUrlImagem;
    }

    public void setBandeiraUrlImagem(String bandeiraUrlImagem) {
        this.bandeiraUrlImagem = bandeiraUrlImagem;
    }
}
