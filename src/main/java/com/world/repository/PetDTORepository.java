package com.world.repository;

import com.world.model.PetDTO;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PetDTORepository extends CrudRepository<PetDTO, Long> {

  @Query(
      "SELECT pet.pet_id, pet.nome_pet, pet.idade,pet.raca, pet.sexo, pet.tipo, pet.status, usuario.usuario_id , usuario.nome_usuario FROM pet_world.pet\n"
          + "left join usuarios_pets on (pet.pet_id = usuarios_pets.pet_id)\n"
          + "left join usuario on (usuarios_pets.usuario_id = usuario.usuario_id)")
  Iterable<PetDTO> findAllPetsAndUsers();

  @Query(
          "SELECT * FROM pet_world.pet\n"
                  + "left join usuarios_pets on (pet.pet_id = usuarios_pets.pet_id)\n"
                  + "left join usuario on (usuarios_pets.usuario_id = usuario.usuario_id)\n"
                  + "where usuario.usuario_id like lower(CONCAT('%', :id, '%'))")
  Iterable<PetDTO> findAllPetsAndUsersById(@Param("id")Long id);

}