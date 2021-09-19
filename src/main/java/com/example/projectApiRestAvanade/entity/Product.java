package com.example.projectApiRestAvanade.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Document
public class Product implements Serializable {

    @Id
    private String codigo;

    @NotBlank(message = "Campo nao pode estar em branco")
    private String nome;

    @NotBlank(message = "Campo nao pode estar em branco")
    private String marca;

    @Max(value = 5, message = "O minimo requerido é 5")
    @NotNull(message = "Campo nao pode ser nulo")
    private int quantidade;

    @NotBlank(message = "Campo nao pode estar em branco")
    private String porte;

    @NotBlank(message = "Campo nao pode estar em branco")
    private String categoria;

    @NotBlank(message = "Campo nao pode estar em branco")
    private String departamento;
}
