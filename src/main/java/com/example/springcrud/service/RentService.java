package com.example.springcrud.service;

import com.example.springcrud.exception.ApartmentWasRentedException;
import com.example.springcrud.exception.WrongDateException;
import com.example.springcrud.mapper.RentDetailsMapper;
import com.example.springcrud.model.RentDetails;
import com.example.springcrud.repository.RentRepository;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RentService {

    private final RentRepository rentRepository;
    private final RentDetailsMapper rentDetailsMapper;

    @SneakyThrows
    public void saveRentDetails(RentDetails rentDetails) {
        Date startRent = rentDetails.getStartRent();
        Date endRent = rentDetails.getEndRent();
        var rentDetailsEntityList = rentRepository.findRentDetailsByDate(
            rentDetails.getIdApartment(), startRent, endRent);

        if (startRent.before(new Date()) || endRent.before(new Date()) || startRent.after(endRent)) {
            throw new WrongDateException("Select the right date");
        } else if (!rentDetailsEntityList.isEmpty()) {
            throw new ApartmentWasRentedException("Apartment was rented on this date!");
        }

        var entity = rentDetailsMapper.toEntity(rentDetails);
        rentRepository.save(entity);
    }
}