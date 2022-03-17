package com.example.springcrud.repository;

import com.example.springcrud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicationUserRepository extends JpaRepository<User, Long>  {

   Optional<User> findApplicationUserByUsername(String username);
}
