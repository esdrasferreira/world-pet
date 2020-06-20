package com.world.repository;

import com.world.model.Usuario;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

  @Query(
      "SELECT * FROM pet_world.usuario\n"
          + "left join pet_world.usuarios_pets on (pet_world.usuario.id = pet_world.usuarios_pets.usuario_id)\n"
          + "where pet_id like lower(CONCAT('%', :pet_id, '%'))")
  Usuario findUserByPetId(@Param("pet_id") Long id);
}
