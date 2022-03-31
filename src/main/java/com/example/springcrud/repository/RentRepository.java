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

    @Query(value = "SELECT * FROM rent_apartment  WHERE id=:id AND " +
            "start_rent between :started and :ended OR end_rent between :started and :ended",nativeQuery = true)
    List<RentApartment> findRentApartmentByDate(@Param("id") long id_apartment,@Param("started") Date start, @Param("ended") Date end);

}
