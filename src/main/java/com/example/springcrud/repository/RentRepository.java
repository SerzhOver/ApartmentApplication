package com.example.springcrud.repository;

import com.example.springcrud.model.RentApartment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RentRepository extends CrudRepository<RentApartment, Long> {

    @Query(value = "SELECT b  FROM RentApartment b WHERE b.id_apartment=:id AND b.start_rent between :started and :ended OR b.end_rent between :started and :ended")
    List<RentApartment> findRentApartmentByDate(@Param("id") long id_apartment,@Param("started") Date start, @Param("ended") Date end);

}
