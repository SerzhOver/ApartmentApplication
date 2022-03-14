package com.example.springcrud.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicationUserRepository extends JpaRepository<User, Long>  {

   Optional<User> findApplicationUserByUsername(String username);
}
