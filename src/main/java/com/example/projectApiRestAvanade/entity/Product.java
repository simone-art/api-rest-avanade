package com.example.projectApiRestAvanade.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@Document
public class Product implements Serializable {

    @Id
    @NotBlank
    private String codigo;

    @NotBlank
    private String nome;

    @NotBlank
    private String marca;

    @NotBlank
    private int quantidade;

    @NotBlank
    private String porte;

    @NotBlank
    private String categoria;

    @NotBlank
    private String departamento;
}
