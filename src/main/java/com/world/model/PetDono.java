package com.world.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Getter@Setter
@Data@AllArgsConstructor
@NoArgsConstructor
public class PetDono {

    @Id
    private Long petId;
    private String nome;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate idade;
    private String raca;
    @Enumerated(EnumType.STRING)
    private SexoPet sexo;
    private String tipo;
    @Enumerated(EnumType.STRING)
    private StatusAdocao status;
    @Column(name = "usuario_id")
    private Long donoId;
    @Column(name = "nome")
    private Long donoNome;



}
