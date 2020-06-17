package com.world.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("adocao")
public class Adocao {

    @Id
    private Integer id;
    private Integer petId;
    private Integer usuarioId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataAdocao;
    private String informacoes;



}
