package com.world.repository;

import com.world.model.UsuarioPet;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UsuarioPetRepository extends CrudRepository<UsuarioPet, Long> {

  @Query(
      "SELECT * FROM pet_world.usuarios_pets\n"
          + "where usuarios_pets.pet_id\n"
          + "like lower(CONCAT('%', :id, '%'))")
  UsuarioPet findByPetIdUserId(@Param("id") Long id);
}
