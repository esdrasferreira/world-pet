package com.world.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
public class Endereco{



        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        private String cep;
        private String logradouro;
        private String numero;
        private String complemento;
        private String bairro;
        private String cidade;
        private String estado;



}
