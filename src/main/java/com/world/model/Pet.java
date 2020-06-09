package com.world.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

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
    private String sexo;
    private String tipo;

    @MappedCollection(idColumn = "pet_id", keyColumn = "usuario_id")
    private Map<Long, UsuarioPet> usuariosPet;

    public void addUsuario(Long id){
        usuariosPet = new HashMap<>();
        UsuarioPet usuarioPet = new UsuarioPet();
        usuarioPet.setUsuarioId(id);

        usuariosPet.put(id, usuarioPet);


    }




}
