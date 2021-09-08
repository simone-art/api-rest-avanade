package com.example.projectApiRestAvanade.entity;


import lombok.Data;


import java.io.Serializable;

@Data

public class Product implements Serializable {

    private long codigo;
    private String nome;
    private int quantidade;
    private String porte;
    private String categoria;
    private String departamento;
}
