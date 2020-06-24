package com.world.controller;

import com.world.model.Pet;
import com.world.model.PetDTO;
import com.world.model.Usuario;
import com.world.repository.PetDTORepository;
import com.world.repository.PetRepository;
import com.world.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/pets")
public class PetController{

    @Autowired
    private PetDTORepository petDTORepository;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public ModelAndView listar(ModelAndView mv){


        Iterable<PetDTO> petDTOIterable = petDTORepository.findAllPetsAndUsers();

        System.out.println("imprimindo pets :::: "+ petDTOIterable.toString());

        mv.addObject("pets",petDTOIterable);
        mv.setViewName("pets/all");
        return mv;
    }


    @GetMapping("/meus_pets")
    public ModelAndView meusPets(ModelAndView mv){
        Iterable<Usuario> usuarios = usuarioRepository.findAll();
        mv.addObject("usuarios", usuarios);

        Iterable<PetDTO> petDTOIterable = petDTORepository.findAllPetsAndUsers();





        mv.addObject("pets",petDTOIterable);
        mv.setViewName("pets/list");
        return mv;
    }

    @PostMapping("/meus_pets2")
    public ModelAndView meusPets2(ModelAndView mv, @RequestParam(required = false, defaultValue = "1")Long usuario_id){
        Iterable<Usuario> usuarios = usuarioRepository.findAll();
        mv.addObject("usuarios", usuarios);


        mv.addObject("usuarioID", usuario_id);


        Iterable<PetDTO> petDTOIterable = petDTORepository.findAllPetsAndUsersById(usuario_id);
        mv.addObject("pets",petDTOIterable);
        mv.setViewName("pets/list");
        return mv;
    }



    @GetMapping("/cadastrar")
    public ModelAndView cadastrar(ModelAndView mv){
        Iterable<Usuario> usuarios = usuarioRepository.findAll();
        mv.addObject("usuarios", usuarios);
        mv.addObject("pet", new Pet());
        mv.setViewName("pets/form");
        return mv;
    }


    @GetMapping("editar/{id}")
    public ModelAndView editar(ModelAndView mv, @PathVariable Long id){
        Optional<Pet> pet = petRepository.findById(id);


        mv.addObject("pet",pet.get());

       Usuario usuarioId = usuarioRepository.findUserByPetId(id);
        mv.addObject("usuarioId", usuarioId.getUsuarioId());

        Iterable<Usuario> usuarioIterable = usuarioRepository.findAll();
        mv.addObject("usuarios", usuarioIterable);

        mv.setViewName("pets/form");
        return mv;
    }

    @PostMapping("/salvar")
    public ModelAndView salvar(@RequestParam Long usuario_id, Pet pet){
        pet.addUsuario(usuario_id);
        petRepository.save(pet);
        return new ModelAndView("redirect:/pets/meus_pets");
    }

    @GetMapping("excluir/{id}")
    public ModelAndView excluir(ModelAndView mv, @PathVariable Long id){
    Pet pet = new Pet();
    pet.setPetId(id);
    petRepository.delete(pet);

        return new ModelAndView("redirect:/pets");
    }



}
