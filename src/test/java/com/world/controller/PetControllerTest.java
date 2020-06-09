package com.world.controller;

import com.world.repository.PetRepository;
import com.world.repository.UsuarioRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(PetController.class)
public class PetControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PetRepository petRepository;

    @MockBean
    private UsuarioRepository usuarioRepository;

    @Test
    @DisplayName("Devem existir Pets cadastrados ao executar o teste")
    void devem_existirPets() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/pets"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/views/pets.jsp"));
    }

    @Test
    @DisplayName("Devem existir o formulario de Pets para cadastrar")
    void deve_retornar_oFormulario_paraCadastro_eAtualizacao() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/pets/cadastrar"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/views/formPet.jsp"));
    }

    @Test
    @DisplayName("Devem inserir um Pet ao salvar o formulario")
    void deve_inserir_umPet_noCadastro_doFormulario() throws Exception {

        mockMvc.perform(
                MockMvcRequestBuilders.post("/pets/salvar")
                        .param("id", "0")
                        .param("nome", "hulk")
                        .param("idade", "2000-05-10")
                        .param("raca", "PitBull")
                        .param("sexo", "masculino")
                        .param("tipo", "cachorro")
                        .param("usuario", "1")

        )
                .andExpect(MockMvcResultMatchers.status().is(302))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/pets"));

    }

}
