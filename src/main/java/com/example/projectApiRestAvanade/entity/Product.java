package com.example.projectApiRestAvanade.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Document
public class Product implements Serializable {

    @Id
    private String codigo;

    @NotBlank
    private String nome;

    @NotBlank
    private String marca;

    @NotNull
    private int quantidade;

    @NotBlank
    private String porte;

    @NotBlank
    private String categoria;

    @NotBlank
    private String departamento;
}
