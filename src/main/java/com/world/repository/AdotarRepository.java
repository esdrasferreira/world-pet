package com.world.repository;

import com.world.model.Adocao;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdotarRepository extends CrudRepository<Adocao, Long> {

  @Query("SELECT * FROM pet_world.adocao\n" + "where pet_id like lower(CONCAT('%', :id, '%')) order by id desc")
  Iterable <Adocao> findByPetIdUserId(@Param("id") Long id);
}
