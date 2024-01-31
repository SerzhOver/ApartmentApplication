package com.example.springcrud.service;

import com.example.springcrud.model.Apartment;
import com.example.springcrud.persistence.mapper.ApartmentMapper;
import com.example.springcrud.persistence.repository.ApartmentRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ApartmentService {

    private final ApartmentRepository apartmentRepository;
    private final ApartmentMapper apartmentMapper;

    public Apartment findApartmentById(long id) {
        var apartmentEntity = apartmentRepository.findById(id).get();
        return apartmentMapper.toDto(apartmentEntity);
    }

    public List<Apartment> findAllApartments() {
        var apartmentEntityList = apartmentRepository.findAll();
        return apartmentMapper.toDtoList(apartmentEntityList);
    }

    public void saveApartment(Apartment apartment) {
        var apartmentEntity = apartmentMapper.toEntity(apartment);
        apartmentRepository.save(apartmentEntity);
    }

    public void updateApartment(Apartment apartment, long id) {
        var apartmentEntityForUpdate = apartmentRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Can not find apartment by id: " + id));

        apartmentEntityForUpdate.setCity(apartment.getCity());
        apartmentEntityForUpdate.setCountOfRooms(apartment.getCountOfRooms());
        apartmentEntityForUpdate.setPrice(apartment.getPrice());

        apartmentRepository.save(apartmentEntityForUpdate);
    }

    public void deleteById(long id) {
        apartmentRepository.deleteById(id);
    }
}