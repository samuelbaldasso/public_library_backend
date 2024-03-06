package com.sbaldass.booksapi.repositories;

import com.sbaldass.booksapi.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String email);
}
