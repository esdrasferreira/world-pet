package com.world.controller;

import com.world.model.Pet;
import com.world.model.Usuario;
import com.world.repository.PetRepository;
import com.world.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Controller
@RequestMapping("/pets")
public class PetController{

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public ModelAndView listar(ModelAndView mv){
        Iterable<Pet> pets = petRepository.findAll();
        mv.addObject("pets",pets);
        return mv;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar(ModelAndView mv){
        Iterable<Usuario> usuarios = usuarioRepository.findAll();
        mv.addObject("usuarios", usuarios);
        mv.setViewName("formPet");
        return mv;
    }

    @GetMapping("editar/{id}")
    public ModelAndView editar(ModelAndView mv, @PathVariable Long id){
        Optional<Pet> pet = petRepository.findById(id);
        mv.addObject("pet",pet.get());
        mv.setViewName("formPet");
        return mv;
    }

    @PostMapping("/salvar")
    public ModelAndView salvar(@RequestParam Long usuario_id, Pet pet){
        pet.addUsuario(usuario_id);
        petRepository.save(pet);
        return new ModelAndView("redirect:/pets");
    }



}