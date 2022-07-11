package com.example.xmlexercise.repository;

import com.example.xmlexercise.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE" +
            " (SELECT COUNT(p) FROM Product p WHERE p.seller.id = u.id AND p.buyer IS NOT NULL ) > 0" +
            " ORDER BY u.lastName ASC, u.firstName ASC ")
    List<User> findAllUsersWithMoreThanOneSoldProduct();
}
