package com.example.springcrud.service;


import com.example.springcrud.model.Apartment;
import com.example.springcrud.repository.ApartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApartmentService {

    private final ApartmentRepository apartmentRepository;

    @Autowired
    public ApartmentService(ApartmentRepository apartmentRepository){
        this.apartmentRepository = apartmentRepository;
    }

    public Apartment findById(long id) {
        return apartmentRepository.findById(id).get();
    }

    public List<Apartment> findAll() {
        return apartmentRepository.findAll();
    }

    public Apartment saveApartment(Apartment apartment) {
        return apartmentRepository.save(apartment);
    }


    public void deleteById(long id) {
        apartmentRepository.deleteById(id);
    }

}
