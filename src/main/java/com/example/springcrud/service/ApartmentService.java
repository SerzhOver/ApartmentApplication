package com.example.springcrud.service;


import com.example.springcrud.model.Apartment;
import com.example.springcrud.repository.ApartmentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApartmentService {

	public final ApartmentDAO apartmentDAO;

	@Autowired
	public ApartmentService(ApartmentDAO apartmentDAO) {
		this.apartmentDAO = apartmentDAO;
	}

	public Apartment create(Apartment apartment) {
		Apartment apartmentResponce = apartmentDAO.create(apartment);
		return apartmentResponce;
	}

	public Apartment update(Apartment apartment, int id ) {
		Apartment apartmentResponce = apartmentDAO.update(apartment, id );
		return apartmentResponce;
	}
	public Apartment delete(int id ) {
		Apartment apartmentResponce = apartmentDAO.delete(id);
		return apartmentResponce;
	}
	public List<Apartment> getAll() {
		List<Apartment> apartmentResponce = apartmentDAO.getAll();
		return apartmentResponce;
	}
}
