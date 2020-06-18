package com.world.repository;

import com.world.model.Adocao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdotarRepository extends CrudRepository<Adocao, Long> {

//    @Query("SELECT * FROM pets INNER JOIN usuarios_pets ....")
//    Iterable<Usuario> findAllPetsAndUsers();
}
