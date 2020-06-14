package com.world.controller;

import com.world.model.UsuarioPet;
import com.world.repository.PetRepository;
import com.world.repository.UsuarioPetRepository;
import com.world.repository.UsuarioRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

@WebMvcTest(PetController.class)
public class UsuarioPetTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PetRepository petRepository;

    @MockBean
    private UsuarioRepository usuarioRepository;

    @MockBean
    private UsuarioPetRepository usuarioPetRepository;


    @Test

    public void testa_tabela_UsuarioPet() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.post("/pets/salvar")
                        .param("id", "0")
                        .param("nome", "hulk")
                        .param("idade", "2000-05-10")
                        .param("raca", "PitBull")
                        .param("sexo", "masculino")
                        .param("tipo", "cachorro")
                        .param("usuario_id", "1")
        );

       Optional<UsuarioPet> usuarioPetVerificacao = usuarioPetRepository.findById((long) 1);
    System.out.println("UsuarioPet ID: "+ usuarioPetVerificacao.toString());
        Assert.assertFalse(usuarioPetVerificacao.isEmpty());



    }
}
