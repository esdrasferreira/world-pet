package com.world.repository;

import com.world.model.Pet;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {

  @Query(
      "SELECT * FROM pet_world.pet\n"
          + "left join usuarios_pets on (pet.id = usuarios_pets.pet_id)\n"
          + "left join usuario on (usuarios_pets.usuario_id = usuario.id)\n"
          + "where usuario.id like lower(CONCAT('%', :id, '%'))")
  Iterable<Pet> findAllPetsAndUsersById(@Param("id")Long id);

  @Query(
      "SELECT * FROM pet_world.pet\n"
          + "inner join usuarios_pets on (pet.id = usuarios_pets.pet_id)\n"
          + "inner join usuario on (usuarios_pets.usuario_id = usuario.id)")
  Iterable<Pet> findAllPetsAndUsers();
}
