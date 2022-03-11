package com.example.springcrud.web;


import com.example.springcrud.model.Apartment;
import com.example.springcrud.service.ApartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("management/apartment")
public class ApartmentAdminController {
    public final ApartmentService apartmentService;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Apartment> getAllApartment() {
        return apartmentService.findAll();
    }


    @PostMapping
    @PreAuthorize("hasAuthority('realtor:read')")
    public Apartment createApartment(@RequestBody Apartment apartment) {
        return apartmentService.saveApartment(apartment);
    }

    @PutMapping("{id}")
    @PreAuthorize("hasAuthority('realtor:read')")
    public Apartment editApartment(@RequestBody Apartment apartment, @PathVariable long id) {
        Apartment foundApartment = apartmentService.findById(id);
        foundApartment.setCity(apartment.getCity());
        foundApartment.setCountOfRoom(apartment.getCountOfRoom());
        foundApartment.setPrice(apartment.getPrice());
        return apartmentService.saveApartment(foundApartment);
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAuthority('realtor:read')")
    public void delete(@PathVariable long id) {
        apartmentService.deleteById(id);
    }

}
