package com.example.springcrud.web;

import com.example.springcrud.model.Apartment;
import com.example.springcrud.service.ApartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("apartment")
@RequiredArgsConstructor
public class ApartmentRealtorController {

    public final ApartmentService apartmentService;

    @GetMapping({"{id}"})
    @PreAuthorize("hasRole('ROLE_REALTOR')")
    public Apartment getApartment(@PathVariable  long id) {
        return apartmentService.findById(id);
    }
}
