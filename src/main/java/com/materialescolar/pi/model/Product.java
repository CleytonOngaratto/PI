package com.materialescolar.pi.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "produtos")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String valor;
    private String descricao;
    @Column(name = "nome_da_loja")
    private String nomeDaLoja;
    private String bairro;

    @Column(name = "rua_enumero")
    private String ruaEnumero;

    private String senhaPraEditarProduto;


}
