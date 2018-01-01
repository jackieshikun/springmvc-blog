package com.springmvcblog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springmvcblog.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    User findByName(String name);

    Optional<User> findByEmailAndPassword(String email, String password);

}
