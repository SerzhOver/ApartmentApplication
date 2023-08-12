package com.example.springcrud;

import com.example.springcrud.model.Apartment;
import com.example.springcrud.repository.ApartmentRepository;
import com.example.springcrud.service.ApartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

class ApartmentTest {

    @InjectMocks
    private ApartmentService apartmentService;

    @Mock
    private ApartmentRepository apartmentRepositoryMock;

    private Apartment apartment;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        apartment = Apartment.builder()
                .city("Berlin")
                .price(3000)
                .countOfRoom(2)
                .build();
    }

    @Test
    void createApartmentTest() {

        Mockito.when(apartmentRepositoryMock.save(any(Apartment.class))).thenReturn(apartment);

        Apartment foundedApartment = apartmentService.saveApartment(apartment);

        assertNotNull(foundedApartment);
        assertEquals("Berlin", foundedApartment.getCity());
    }

    @Test
    void getApartmentTest() {

        Mockito.when(apartmentRepositoryMock.findById(anyLong())).thenReturn(Optional.of(apartment));
        Apartment foundedApartment = apartmentService.findById(1L);

        assertNotNull(foundedApartment);
        assertEquals("Berlin", foundedApartment.getCity());
        Mockito.verify(apartmentRepositoryMock, Mockito.times(1)).findById(1L);

    }

    @Test
    void getAllApartmentTest() {

        List<Apartment> testApartmentList = new ArrayList<>() {{
            add(apartment);
            add(apartment);
        }};

        Mockito.when(apartmentRepositoryMock.findAll()).thenReturn(testApartmentList);

        List<Apartment> apartmentList = apartmentService.findAll();

        assertNotNull(apartmentList);
        assertEquals(2, apartmentList.size());
    }

    @Test
    void editApartmentTest() {

        Mockito.when(apartmentRepositoryMock.findById(anyLong())).thenReturn(Optional.of(apartment));
        Mockito.when(apartmentRepositoryMock.save(any(Apartment.class))).thenReturn(apartment);

        Apartment foundedApartment = apartmentService.findById(1L);
        foundedApartment.setCity("Gdansk");

        Apartment updatedApartment = apartmentService.saveApartment(foundedApartment);

        assertNotNull(updatedApartment);
        assertEquals("Gdansk", updatedApartment.getCity());
    }

    @Test
    void deleteApartmentTest() {

        apartmentService.deleteById(1L);
        Mockito.verify(apartmentRepositoryMock, Mockito.times(1)).deleteById(anyLong());
    }
}
