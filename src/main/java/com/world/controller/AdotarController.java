package com.world.controller;

import com.world.model.*;
import com.world.repository.AdotarRepository;
import com.world.repository.PetRepository;
import com.world.repository.UsuarioPetRepository;
import com.world.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequestMapping("/adocao")
public class AdotarController {

    @Autowired
    private AdotarRepository adotarRepository;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioPetRepository usuarioPetRepository;

//    @GetMapping
//    public ModelAndView listar(ModelAndView mv){
//        Iterable<Pet> pets = petRepository.findAll();
//        mv.addObject("pets",pets);
//        mv.setViewName("pets/all");
//        return mv;
//    }


//    @GetMapping("/meus_pets")
//    public ModelAndView meusPets(ModelAndView mv){
//        Iterable<Pet> pets = petRepository.findAll();
//        mv.addObject("pets",pets);
//        mv.setViewName("pets/list");
//        return mv;
//    }



    @GetMapping("/cadastrar/{id}")
    public ModelAndView cadastrar(ModelAndView mv, @PathVariable Long id){
        Iterable<Usuario> usuarios = usuarioRepository.findAll();
        mv.addObject("usuarios", usuarios);




        Optional<Pet> pet = petRepository.findById(id);



        if(pet.get().getStatus() == StatusAdocao.INDISPONIVEL){
            return new ModelAndView("redirect:/pets");
        }else{
            mv.addObject("pet", pet.get());
            mv.setViewName("adocao/form");
            return mv;
        }


    }

    @PostMapping("/salvar")
    public ModelAndView salvar(@RequestParam Long usuario_id, Long id){

        Adocao adocao = new Adocao();
        adocao.setPetId(id);
        adocao.setUsuarioId(usuario_id);
        adocao.setDataAdocao(LocalDate.now());
        adotarRepository.save(adocao);


        return new ModelAndView("redirect:/pets");
    }

//    @GetMapping("excluir/{id}")
//    public ModelAndView excluir(ModelAndView mv, @PathVariable Integer id){
//    Pet pet = new Pet();
//    pet.setId(id);
//    petRepository.delete(pet);
//
//        return new ModelAndView("redirect:/pets");
//    }



}
