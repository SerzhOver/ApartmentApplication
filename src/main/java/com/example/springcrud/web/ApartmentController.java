package com.example.springcrud.web;


import com.example.springcrud.model.Apartment;
import com.example.springcrud.service.ApartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/apartment") // it is a good practise to move path to a class with all path constants
public class ApartmentController {
	public final ApartmentService apartmentService;

	@GetMapping("/list")
	public List<Apartment> getAllApartment() {
		List<Apartment> apartments = apartmentService.findAll();
		return apartments;
	}


	@PostMapping("/new")
	public Apartment createApartment(@RequestBody Apartment apartment) {
		Apartment apartmentResponse = apartmentService.saveApartment(apartment);
		return apartmentResponse;
	}

	@PutMapping("/edit/{id}")
	public Apartment editApartment(@RequestBody Apartment apartment,@PathVariable long id) {
		Apartment findedApartment = apartmentService.findById(id);
		findedApartment.setCity(apartment.getCity());
		findedApartment.setCountOfRoom(apartment.getCountOfRoom());
		findedApartment.setPrice(apartment.getPrice());
		Apartment apartmentResponse = apartmentService.saveApartment(findedApartment);
		return apartmentResponse;
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable long id) {
		apartmentService.deleteById(id);
	}

}
