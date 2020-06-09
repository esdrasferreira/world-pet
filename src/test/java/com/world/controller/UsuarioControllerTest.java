package com.world.controller;

import com.world.repository.UsuarioRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(UsuarioController.class)
public class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UsuarioRepository usuarioRepository;

    @Test
    @DisplayName("Devem existir Usuarios cadastrados ao executar o teste")
    void devem_existirUsuarios() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/usuarios"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/views/usuarios.jsp"));

    }

    @Test
    @DisplayName("Devem existir o formulario de Usuario para cadastrar")
    void deve_retornar_oFormulario_paraCadastro_eAtualizacao() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/usuarios/cadastrar"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/views/formUser.jsp"));
    }

    @Test
    @DisplayName("Deve inserir um Usuario ao salvar o formulario")
    void deve_inserir_umUsuario_noCadastro_doFormulario() throws Exception {

        mockMvc.perform(
                MockMvcRequestBuilders.post("/usuarios/salvar")
                        .param("id", "0")
                        .param("nome", "esdras")
                        .param("idade", "2005-05-10")
                        .param("sexo", "masculino")
                        .param("endereco", "rua x")

        )
                .andExpect(MockMvcResultMatchers.status().is(302))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/usuarios"));

    }

}
