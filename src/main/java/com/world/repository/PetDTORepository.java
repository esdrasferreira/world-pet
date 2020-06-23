package com.world.repository;

import com.world.model.PetDTO;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetDTORepository extends CrudRepository<PetDTO, Long> {

  @Query(
      "SELECT pet.pet_id, pet.nome_pet, pet.idade,pet.raca, pet.sexo, pet.tipo, pet.status, usuario.usuario_id , usuario.nome_usuario FROM pet_world.pet\n"
          + "join usuarios_pets on (pet.pet_id = usuarios_pets.pet_id)\n"
          + "join usuario on (usuarios_pets.usuario_id = usuario.usuario_id)")
  Iterable<PetDTO> findAllPetsAndUsers();
}