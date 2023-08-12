package com.example.springcrud.repository;

import com.example.springcrud.model.RentedApartment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RentRepository extends CrudRepository<RentedApartment, Long> {

    @Query(value = "SELECT b  FROM RentedApartment b WHERE b.idApartment=:id AND b.startRent between :started and :ended OR b.endRent between :started and :ended")
    List<RentedApartment> findRentApartmentByDate(@Param("id") long idApartment, @Param("started") Date start, @Param("ended") Date end);

}
