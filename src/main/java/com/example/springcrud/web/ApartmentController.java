package com.example.springcrud.web;


import com.example.springcrud.model.Apartment;
import com.example.springcrud.service.ApartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/apartment")
public class ApartmentController {
    public final ApartmentService apartmentService;

    @GetMapping("/list")
    public List<Apartment> getAllApartment() {
        return apartmentService.findAll();
    }


    @PostMapping("/new")
    public Apartment createApartment(@RequestBody Apartment apartment) {
        return apartmentService.saveApartment(apartment);
    }

    @PutMapping("/edit/{id}")
    public Apartment editApartment(@RequestBody Apartment apartment, @PathVariable long id) {
        Apartment foundApartment = apartmentService.findById(id);
        foundApartment.setCity(apartment.getCity());
        foundApartment.setCountOfRoom(apartment.getCountOfRoom());
        foundApartment.setPrice(apartment.getPrice());
        return apartmentService.saveApartment(foundApartment);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        apartmentService.deleteById(id);
    }

}
