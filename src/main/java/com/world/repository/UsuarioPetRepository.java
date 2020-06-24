package com.world.repository;

import com.world.model.UsuarioPet;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioPetRepository extends CrudRepository<UsuarioPet, Long> {




  @Modifying
  @Query(
      "update usuarios_pets set usuarios_pets.usuario_id = :usuario_id where usuarios_pets.pet_id like :pet_id")
  void updateStatus(@Param("usuario_id") Long usuario_id, @Param("pet_id")Long pet_id);
}
