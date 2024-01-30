package com.example.springcrud.web;

import com.example.springcrud.model.Apartment;
import com.example.springcrud.service.ApartmentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("management/apartment")
@PreAuthorize("hasRole('ROLE_realtor')")
public class ApartmentRealtorController {

    private final ApartmentService apartmentService;

    @GetMapping
    public ResponseEntity<List<Apartment>> getAllApartment() {
        List<Apartment> apartmentList = apartmentService.findAllApartments();
        return ResponseEntity.ok(apartmentList);
    }

    @PostMapping
    public ResponseEntity<Apartment> saveApartment(@RequestBody Apartment apartment) {
        apartmentService.saveApartment(apartment);
        return ResponseEntity.ok(apartment);
    }

    @PutMapping("{id}")
    public ResponseEntity<Apartment> editApartment(@RequestBody Apartment apartment, @PathVariable long id) {
        apartmentService.updateApartment(apartment, id);
        return ResponseEntity.ok(apartment);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> delete(@PathVariable long id) {
        apartmentService.deleteById(id);
        return ResponseEntity.ok(id);
    }

}