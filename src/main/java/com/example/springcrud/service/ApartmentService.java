package com.example.springcrud.service;


import com.example.springcrud.model.Apartment;
import com.example.springcrud.repository.ApartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor//looks better that explicit constructor)
public class ApartmentService {
	public final ApartmentRepository apartmentRepository;


	public Apartment findById(long id) {
		Apartment apartment = apartmentRepository.getById(id);
		return apartment;
	}

	public List<Apartment> findAll() {
		List<Apartment> apartmentList = apartmentRepository.findAll();
		return apartmentList;
	}

	public Apartment saveApartment(Apartment apartment) {
		Apartment responseApartment = apartmentRepository.save(apartment);
		return responseApartment;
	}


	public void deleteById(long id) {
		apartmentRepository.deleteById(id);
	}

}
