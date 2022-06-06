package com.example.springcrud;

import com.example.springcrud.model.Apartment;
import com.example.springcrud.repository.ApartmentRepository;
import com.example.springcrud.service.ApartmentService;
import org.junit.jupiter.api.*;
import org.mockito.*;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

public class ApartmentTest {

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
    public void createApartmentTest() {

        Mockito.when(apartmentRepositoryMock.save(any(Apartment.class))).thenReturn(apartment);

        Apartment foundedApartment = apartmentService.saveApartment(apartment);

        assertNotNull(foundedApartment);
        assertEquals("Berlin", foundedApartment.getCity());
    }

    @Test
    public void getApartmentTest() {

        Mockito.when(apartmentRepositoryMock.findById(anyLong())).thenReturn(Optional.of(apartment));
        Apartment foundedApartment = apartmentService.findById(1L);

        assertNotNull(foundedApartment);
        assertEquals("Berlin", foundedApartment.getCity());
        Mockito.verify(apartmentRepositoryMock, Mockito.times(1)).findById(1L);

    }

    @Test
    public void getAllApartmentTest() {

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
    public void editApartmentTest() {

        Mockito.when(apartmentRepositoryMock.findById(anyLong())).thenReturn(Optional.of(apartment));
        Mockito.when(apartmentRepositoryMock.save(any(Apartment.class))).thenReturn(apartment);

        Apartment foundedApartment = apartmentService.findById(1L);
        foundedApartment.setCity("Gdansk");

        Apartment updatedApartment = apartmentService.saveApartment(foundedApartment);

        assertNotNull(updatedApartment);
        assertEquals("Gdansk", updatedApartment.getCity());
    }

    @Test
    public void deleteApartmentTest() {

        apartmentService.deleteById(1L);
        Mockito.verify(apartmentRepositoryMock, Mockito.times(1)).deleteById(anyLong());
    }
}
