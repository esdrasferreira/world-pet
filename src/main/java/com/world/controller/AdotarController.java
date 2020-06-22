package com.world.controller;

import com.world.model.Adocao;
import com.world.model.Pet;
import com.world.model.StatusAdocao;
import com.world.model.Usuario;
import com.world.repository.AdotarRepository;
import com.world.repository.PetRepository;
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
        mv.addObject("usuarios", usuarios); //envio todos os usuarios


        Usuario usuario = usuarioRepository.findUserByPetId(id);
        mv.addObject("nome_dono", usuario.getNomeUsuario());//envio apenas nome_dono
        mv.addObject("usuarioID", usuario.getUsuarioId());//envio apenas id do usuario para selected
        Optional<Pet> pet = petRepository.findById(id);

        if(pet.get().getStatus() == StatusAdocao.INDISPONIVEL){
            return new ModelAndView("redirect:/pets"); //se status indisponivel, não muda de pagina
        }else{
            mv.addObject("pet", pet.get()); //se status disponivel vai para pagina adocao
            mv.setViewName("adocao/form");
            return mv;
        }
    }

    @PostMapping("/salvar")
    public ModelAndView salvar(@RequestParam Long usuario_id, Long antigo_dono_id , Pet pet){

        Optional<Pet> petOptional = petRepository.findById(pet.getPetId());

        Adocao adocao = new Adocao();
        adocao.setPetId(pet.getPetId());
        adocao.setUsuarioId(usuario_id);
        adocao.setAntigoUsuarioId(antigo_dono_id);
        adocao.setDataAdocao(LocalDate.now());
        adotarRepository.save(adocao);

        pet = petOptional.get();

        pet.addUsuario(usuario_id);
//        pet.setStatus(StatusAdocao.INDISPONIVEL);
        petRepository.save(pet);

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
