package com.example.springcrud.service;


import com.example.springcrud.model.Apartment;
import com.example.springcrud.repository.ApartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApartmentService {
    @Autowired
    public final ApartmentRepository apartmentRepository;


    public Apartment findById(long id) {
        return apartmentRepository.getById(id);
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
