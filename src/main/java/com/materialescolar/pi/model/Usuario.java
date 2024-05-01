package com.materialescolar.pi.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name="usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nome;
    private String email;
    private String nomeDaLoja;
    private String enderecoDaLoja;
    private String descricao;

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getNomeDaLoja() {
        return nomeDaLoja;
    }

    public String getEmail() {
        return email;
    }

    public String getEnderecoDaLoja() {
        return enderecoDaLoja;
    }

    public String getDescricao() {
        return descricao;
    }

}
