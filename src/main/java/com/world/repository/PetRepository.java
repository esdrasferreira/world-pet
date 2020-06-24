package com.world.repository;

import com.world.model.Pet;
import com.world.model.StatusAdocao;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {

  @Query(
      "SELECT * FROM pet_world.pet\n"
          + "left join usuarios_pets on (pet.pet_id = usuarios_pets.pet_id)\n"
          + "left join usuario on (usuarios_pets.usuario_id = usuario.usuario_id)\n"
          + "where usuario.usuario_id like lower(CONCAT('%', :id, '%'))")
  Iterable<Pet> findAllPetsAndUsersById(@Param("id")Long id);


  @Modifying
  @Query(
      "UPDATE `pet_world`.`pet` SET `status` = :status WHERE (`pet_id` like :pet_id)")
  void updateStatus(@Param("status") StatusAdocao status, @Param("pet_id")Long pet_id);
}
