package com.example.springcrud.persistence.repository;

import com.example.springcrud.persistence.entity.UserEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationUserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findApplicationUserByUsername(String username);
}
