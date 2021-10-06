package com.example.projectApiRestAvanade.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@Document
public class Categoria implements Serializable {

    @Id
    private String codigo;

    @NotBlank(message = "Campo nao pode estar em branco")
    private String nome;

    @NotBlank(message = "Campo nao pode estar em branco")
    private String departamento;
}
