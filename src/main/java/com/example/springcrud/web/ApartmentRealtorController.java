package com.example.springcrud.web;

import com.example.springcrud.model.Apartment;
import com.example.springcrud.model.RentApartment;
import com.example.springcrud.service.ApartmentService;
import com.example.springcrud.service.RentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("apartment")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ROLE_REALTOR')")
public class ApartmentRealtorController {

    private final ApartmentService apartmentService;
    private final RentService rentService;

    @GetMapping({"{id}"})
    public Apartment getApartment(@PathVariable long id) {
        return apartmentService.findById(id);
    }

    @PostMapping
    public RentApartment createRentApartment(@RequestBody RentApartment rentApartment) {
        return rentService.saveRentApartment(rentApartment);
    }
}
