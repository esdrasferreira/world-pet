package com.world.controller;

import com.world.model.Usuario;
import com.world.repository.PetRepository;
import com.world.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PetRepository petRepository;

    @GetMapping
    public ModelAndView listar(ModelAndView mv){
        Iterable<Usuario> usuarios = usuarioRepository.findAll();
        mv.addObject("usuarios",usuarios);
        mv.setViewName("usuarios/list");
        return mv;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar(ModelAndView mv){
        mv.addObject("usuario", new Usuario());
        mv.setViewName("usuarios/form");
        return mv;
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    @GetMapping("editar/{id}")
    public ModelAndView editar(ModelAndView mv, @PathVariable Long id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        mv.addObject("usuario",usuario.get());

        mv.setViewName("usuarios/form");
        return mv;
    }

    @PostMapping("/salvar")
    public ModelAndView salvar(@ModelAttribute Usuario usuario){
        usuarioRepository.save(usuario);
        return new ModelAndView("redirect:/usuarios");
    }

}
