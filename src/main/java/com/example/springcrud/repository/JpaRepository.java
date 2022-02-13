package com.example.springcrud.repository;


import com.example.springcrud.model.Apartment;
import org.springframework.data.repository.CrudRepository;

public interface JpaRepository<T> extends CrudRepository<Apartment, Long> {


    void deleteById(Long aLong);

    void deleteAllById(Iterable<? extends Long> longs);


    <S extends Apartment> S save(S entity);

    Iterable<Apartment> findAll();

    Iterable<Apartment> findAllById(Iterable<Long> longs);

}
