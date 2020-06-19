package com.world.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Getter@Setter
@Data@AllArgsConstructor
@NoArgsConstructor
@Table("pet")
public class Pet {

    @Id
    private Long id;
    private String nome;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate idade;
    private String raca;
    @Enumerated(EnumType.STRING)
    private SexoPet sexo;
    private String tipo;
    @Enumerated(EnumType.STRING)
    private StatusAdocao status;



    @MappedCollection(idColumn = "pet_id", keyColumn = "usuario_id")
    private Map<Integer, UsuarioPet> usuariosPet;

    public void addUsuario(Long id){
        usuariosPet = new HashMap<Integer, UsuarioPet>();
        UsuarioPet usuarioPet = new UsuarioPet();
        usuarioPet.setUsuarioId(id);

        usuariosPet.put(Math.toIntExact(id), usuarioPet);


    }




}
