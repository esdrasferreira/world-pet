package com.world.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Data@Getter@Setter@Entity
@AllArgsConstructor@NoArgsConstructor
@Table("usuario")
public class Usuario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate idade;
    @Enumerated(EnumType.STRING)
    private SexoUsuario sexo;




}
