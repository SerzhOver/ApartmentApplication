package com.example.springcrud.service;

import com.example.springcrud.exception.ApartmentWasRentedException;
import com.example.springcrud.exception.WrongDateException;
import com.example.springcrud.model.RentedApartment;
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
    public RentedApartment saveRentedApartment(RentedApartment rentApartment) {

        Date startRent = rentApartment.getStartRent();
        Date endRent = rentApartment.getEndRent();
        List<RentedApartment> rentedApartments = rentRepository.findRentApartmentByDate(rentApartment.getIdApartment(), startRent, endRent);

        if (startRent.before(new Date()) || endRent.before(new Date()) || startRent.after(endRent)) {
            throw new WrongDateException("Select the right date");
        } else if (!rentedApartments.isEmpty()) {
            throw new ApartmentWasRentedException("Apartment was rented on this date!");
        }

        return rentRepository.save(rentApartment);
    }
}
