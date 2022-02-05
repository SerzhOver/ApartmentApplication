package com.example.springcrud.repository;



import com.example.springcrud.model.Apartment;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface JpaRepository<T> extends CrudRepository<Apartment, Long> {

	@Override// unnecessary annotations as far as you don't override here anything
	void deleteById(Long aLong);

	@Override
	void deleteAllById(Iterable<? extends Long> longs);



	@Override
	<S extends Apartment> S save(S entity);


	@Override
	Optional<Apartment> findById(Long aLong);

	@Override
	Iterable<Apartment> findAll();

	@Override
	Iterable<Apartment> findAllById(Iterable<Long> longs);

}
