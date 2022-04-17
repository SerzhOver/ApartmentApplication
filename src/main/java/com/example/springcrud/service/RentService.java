package com.example.springcrud.service;

import com.example.springcrud.exception.ApartmentWasRentedException;
import com.example.springcrud.exception.WrongDateException;
import com.example.springcrud.model.RentApartment;
import com.example.springcrud.repository.RentRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RentService {

    private final RentRepository rentRepository;

    @Autowired
    public RentService(RentRepository rentRepository) {
        this.rentRepository = rentRepository;
    }

    @SneakyThrows
    public RentApartment saveRentApartment(RentApartment rentApartment) {

        Date start_rent = rentApartment.getStart_rent();
        Date end_rent = rentApartment.getEnd_rent();
        List<RentApartment> rentedApartments = rentRepository.findRentApartmentByDate(rentApartment.getId_apartment(), start_rent, end_rent);

        if (start_rent.before(new Date()) || end_rent.before(new Date()) || start_rent.after(end_rent)) {
                throw new WrongDateException("Select the right date");
        }

        else if (!rentedApartments.isEmpty()) {
                throw new ApartmentWasRentedException("Apartment was rented on this date!");
        }

        return rentRepository.save(rentApartment);
    }
}
