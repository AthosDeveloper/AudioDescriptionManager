package com.project.AudioDescriptionManager.repositories;

import com.project.AudioDescriptionManager.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByPosition(String position);
}
