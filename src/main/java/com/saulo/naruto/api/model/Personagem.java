package com.saulo.naruto.api.model;

import jakarta.persistence.*;

import java.util.Map;
import java.util.HashMap;

@Entity
@Table(name = "TAB_PERSONAGEM")
public class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @ElementCollection
    @CollectionTable(name = "PERSONAGEM_JUTSUS", joinColumns = @JoinColumn(name = "PERSONAGEM_ID"))
    @MapKeyColumn(name = "NOME_JUTSU")
    @Column(name = "DANO_MAXIMO")
    private Map<String, Integer> jutsus = new HashMap<>();

    @Column(name = "CHAKRA")
    private int chakra = 100;

    @Column(name = "VIDA")
    private int vida = 1;

    // Construtores
    public Personagem() {
    }

    public Personagem(String nome, int vida) {
        this.nome = nome;
        this.vida = vida;
        this.chakra = 100;
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Map<String, Integer> getJutsus() {
        return jutsus;
    }

    public void setJutsus(Map<String, Integer> jutsus) {
        this.jutsus = jutsus;
    }

    public int getChakra() {
        return chakra;
    }

    public void setChakra(int chakra) {
        this.chakra = chakra;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
}

