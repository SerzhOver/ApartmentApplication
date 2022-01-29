package com.example.springcrud.web;


import com.example.springcrud.model.Apartment;
import com.example.springcrud.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/apartment")
public class ApartmentController {

	public final ApartmentService apartmentService;

	@Autowired
	public ApartmentController(ApartmentService apartmentService) {
		this.apartmentService = apartmentService;
	}

	@GetMapping("/list")
	public List<Apartment> getAllApartment() {
		List<Apartment> apartments = apartmentService.findAll();
		return apartments;
	}


	@PostMapping("/new")
	public Apartment createApartment(@RequestBody Apartment apartment) {
		Apartment apartmentResponce = apartmentService.saveApartment(apartment);
		return apartmentResponce;
	}

	@PutMapping("/edit/{id}")
	public Apartment editApartment(@RequestBody Apartment apartment,@PathVariable long id) {
		Apartment findedApartment = apartmentService.findById(id);
		findedApartment.setCity(apartment.getCity());
		findedApartment.setCountOfRoom(apartment.getCountOfRoom());
		findedApartment.setPrice(apartment.getPrice());
		Apartment apartmentResponce = apartmentService.saveApartment(findedApartment);
		return apartmentResponce;
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable long id) {
		apartmentService.deleteById(id);
	}


}
