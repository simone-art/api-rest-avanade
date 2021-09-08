package com.example.projectApiRestAvanade.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.io.Serializable;

@Data
@Document
public class Product implements Serializable {

    @Id
    private long codigo;
    private String nome;
    private int quantidade;
    private String porte;
    private String categoria;
    private String departamento;
}
