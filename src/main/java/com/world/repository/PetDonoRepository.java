package com.world.repository;

import com.world.model.PetDono;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PetDonoRepository extends CrudRepository<PetDono, Long> {

  @Query(
      "SELECT pet.pet_id, pet.nome, pet.idade,pet.raca, pet.sexo, pet.tipo, pet.status, usuario.usuario_id , usuario.nome FROM pet_world.pet\n"
          + "left join usuarios_pets on (pet.pet_id = usuarios_pets.pet_id)\n"
          + "left join usuario on (usuarios_pets.usuario_id = usuario.usuario_id)")
  Iterable<PetDono> findAllPetDono();

  @Modifying
  @Query(
      "UPDATE pet_world.pet p SET p.status = :status WHERE p.pet_id = :id")
  void updateStatus(@Param("status") String status, @Param("id")Long id);
}
