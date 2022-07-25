package com.example.football.repository;

import com.example.football.models.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    //player's email already exists in the DB return
    boolean existsByEmail(String email);

    //•	Order Them by Shooting in Desc Order,
    // Then by Passing in Desc Order,
    // Then by Endurance Desc Order
    // and Finally Then by Player Last Name.

    @Query("SELECT p FROM Player p ORDER BY p.stat.shooting DESC, p.stat.passing DESC, p.stat.endurance DESC, p.lastName ASC ")
    List<Player> findByBirthDateBetweenOrderByStatShootingDescStatPassingDescStatEnduranceDescLastNameAsc(LocalDate after, LocalDate before);


}
