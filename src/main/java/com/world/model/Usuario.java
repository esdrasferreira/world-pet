package com.world.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor@NoArgsConstructor
@Table("usuario")
public class Usuario {

    @Id
    private Long id;
    private String nome;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate idade;
    private String sexo;
    private String endereco;
}
