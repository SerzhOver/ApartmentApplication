package com.example.springcrud.web;

import com.example.springcrud.model.Apartment;
import com.example.springcrud.service.ApartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("apartment")
@RequiredArgsConstructor
public class ApartmentRealtorController {

    public final ApartmentService apartmentService;

    @GetMapping
    public List<Apartment> getAllApartment() {
        return apartmentService.findAll();
    }
}
