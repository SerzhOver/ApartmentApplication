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
		List<Apartment> apartments = apartmentService.getAll();
		return apartments;
	}


	@PostMapping("/new")
	public Apartment createApartment(@RequestBody Apartment apartment) {
		Apartment apartmentResponce = apartmentService.create(apartment);
		return apartmentResponce;
	}

	@PutMapping("/edit/{id}")
	public Apartment edit(@RequestBody Apartment apartment,@PathVariable int id) {
		Apartment apartmentResponce = apartmentService.update(apartment,id);
		return apartmentResponce;
	}

	@DeleteMapping("/delete/{id}")
	public Apartment delete(@PathVariable int id) {
		Apartment apartmentResponce = apartmentService.delete(id);
		return apartmentResponce;
	}


}
