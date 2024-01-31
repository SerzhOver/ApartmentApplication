package com.example.springcrud.persistence.repository;

import com.example.springcrud.persistence.entity.RentDetailsEntity;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRepository extends JpaRepository<RentDetailsEntity, Long> {

    @Query(value = "SELECT b  FROM RentDetailsEntity b WHERE b.idApartment=:id AND b.startRent between :started and :ended OR b.endRent between :started and :ended")
    List<RentDetailsEntity> findRentDetailsByDate(@Param("id") long idApartment, @Param("started") Date start,
                                                  @Param("ended") Date end);

}