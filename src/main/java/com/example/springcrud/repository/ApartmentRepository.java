package com.example.springcrud.repository;


import com.example.springcrud.model.Apartment;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment,Long> {




}

