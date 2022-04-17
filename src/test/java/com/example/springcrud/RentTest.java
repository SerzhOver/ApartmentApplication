package com.example.springcrud;

import com.example.springcrud.model.RentApartment;
import com.example.springcrud.repository.RentRepository;
import com.example.springcrud.service.RentService;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

public class RentTest {

    @InjectMocks
    private RentService rentService;

    @Mock
    private RentRepository rentRepositoryMock;

    private List<RentApartment> rentApartmentList;
    private RentApartment rentApartment;

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

        rentApartment = RentApartment.builder()
                .id_rent(1L)
                .id_apartment(11L)
                .start_rent(start_rent)
                .end_rent(end_rent)
                .build();
    }

    @Test
    public void saveRentApartmentTest(){

        Mockito.when(rentRepositoryMock.findRentApartmentByDate(anyLong(),any(Date.class),any(Date.class))).thenReturn(new ArrayList<>());
        Mockito.when(rentRepositoryMock.save(any(RentApartment.class))).thenReturn(rentApartment);

        RentApartment foundedRentApartment = rentService.saveRentApartment(rentApartment);
        assertNotNull(foundedRentApartment);
        assertEquals(11L,foundedRentApartment.getId_apartment());
    }
}
