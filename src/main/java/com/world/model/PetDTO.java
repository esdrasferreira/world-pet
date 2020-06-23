package com.world.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Getter@Setter
@Data@AllArgsConstructor
@NoArgsConstructor
@Table("pet")
public class PetDTO {

    @Id
    private Long petId;
    private String nomePet;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate idade;
    private String raca;
    @Enumerated(EnumType.STRING)
    private SexoPet sexo;
    private String tipo;
    @Enumerated(EnumType.STRING)
    private StatusAdocao status;


    private Long usuarioId;
    private String nomeUsuario;




}
