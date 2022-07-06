package com.example.softunigamestore_dto.repository;

import com.example.softunigamestore_dto.model.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;


@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

   @Query("select g from Game g")
   List<Game> findAllByTitleAndPrice();

   List<Game> findAllByTitle(String title);

}
