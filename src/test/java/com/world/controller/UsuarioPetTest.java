package com.world.controller;

import com.world.repository.PetRepository;
import com.world.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(PetController.class)
public class UsuarioPetTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PetRepository petRepository;

    @MockBean
    private UsuarioRepository usuarioRepository;





}
