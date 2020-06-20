package com.world.repository;

import com.world.model.Pet;
import org.springframework.data.jdbc.repository.query.Modifying;
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

  @Modifying
  @Query(
      "UPDATE pet_world.pet p SET p.status = :status WHERE p.id = :id")
  void updateStatus(@Param("status") String status, @Param("id")Long id);
}
