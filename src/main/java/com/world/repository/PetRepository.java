package com.world.repository;

import com.world.model.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {

//    @Query("SELECT * FROM pets INNER JOIN usuarios_pets ....")
//    Iterable<Usuario> findAllPetsAndUsers();
}
