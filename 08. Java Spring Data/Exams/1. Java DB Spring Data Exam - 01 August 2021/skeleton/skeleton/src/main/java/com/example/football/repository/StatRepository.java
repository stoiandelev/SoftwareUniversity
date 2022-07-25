package com.example.football.repository;

import com.example.football.models.entity.Stat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatRepository extends JpaRepository<Stat, Long> {

    //the passing, shooting and endurance
    boolean existsByPassingAndShootingAndEndurance(Float passing, Float shooting, Float endurance);

    Optional<Stat> findById(Long id);
}
