package com.example.springcrud.web;

import com.example.springcrud.model.Apartment;
import com.example.springcrud.model.RentDetails;
import com.example.springcrud.service.ApartmentService;
import com.example.springcrud.service.RentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("apartment")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ROLE_customer')")
public class ApartmentCustomerController {

    private final ApartmentService apartmentService;
    private final RentService rentService;

    @GetMapping({"{id}"})
    public ResponseEntity<Apartment> getApartment(@PathVariable long id) {
        Apartment apartment = apartmentService.findApartmentById(id);
        return ResponseEntity.ok(apartment);
    }

    @PostMapping
    public ResponseEntity<RentDetails> saveRentDetails(@RequestBody RentDetails rentDetails) {
        rentService.saveRentDetails(rentDetails);
        return ResponseEntity.ok(rentDetails);
    }
}