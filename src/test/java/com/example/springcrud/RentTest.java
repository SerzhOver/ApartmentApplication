package com.example.springcrud;

import com.example.springcrud.model.RentedApartment;
import com.example.springcrud.repository.RentRepository;
import com.example.springcrud.service.RentService;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

class RentTest {

    @InjectMocks
    private RentService rentService;

    @Mock
    private RentRepository rentRepositoryMock;

    private RentedApartment rentedApartment;

    @BeforeEach
    public void init() {

        MockitoAnnotations.openMocks(this);

        Date start_rent;
        Date end_rent;
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.DAY_OF_MONTH,2);
        start_rent = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH,2);
        end_rent = calendar.getTime();

        rentedApartment = RentedApartment.builder()
                .idRent(1L)
                .idApartment(11L)
                .startRent(start_rent)
                .endRent(end_rent)
                .build();
    }

    @Test
    void saveRentApartmentTest(){

        Mockito.when(rentRepositoryMock.findRentApartmentByDate(anyLong(),any(Date.class),any(Date.class))).thenReturn(new ArrayList<>());
        Mockito.when(rentRepositoryMock.save(any(RentedApartment.class))).thenReturn(rentedApartment);

        RentedApartment foundedRentedApartment = rentService.saveRentedApartment(rentedApartment);
        assertNotNull(foundedRentedApartment);
        assertEquals(11L, foundedRentedApartment.getIdApartment());
    }
}
