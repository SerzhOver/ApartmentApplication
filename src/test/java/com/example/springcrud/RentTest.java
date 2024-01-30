package com.example.springcrud;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.springcrud.entity.RentDetailsEntity;
import com.example.springcrud.mapper.RentDetailsMapper;
import com.example.springcrud.model.RentDetails;
import com.example.springcrud.repository.RentRepository;
import com.example.springcrud.service.RentService;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class RentTest {

    @InjectMocks
    private RentService rentService;

    @Mock
    private RentRepository rentRepositoryMock;
    @Mock
    private RentDetailsMapper rentDetailsMapper;

    private RentDetailsEntity rentDetailsEntity;
    private RentDetails rentDetails;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);

        Date start_rent;
        Date end_rent;
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.DAY_OF_MONTH, 2);
        start_rent = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH, 2);
        end_rent = calendar.getTime();

        rentDetailsEntity = RentDetailsEntity.builder()
            .id(1L)
            .idApartment(11L)
            .startRent(start_rent)
            .endRent(end_rent)
            .build();

        rentDetails = RentDetails.builder()
            .idApartment(11L)
            .startRent(start_rent)
            .endRent(end_rent)
            .build();
    }

    @Test
    void saveRentApartmentTest() {
        when(rentRepositoryMock.findRentDetailsByDate(anyLong(), any(Date.class), any(Date.class)))
            .thenReturn(new ArrayList<>());
        when(rentRepositoryMock.save(any(RentDetailsEntity.class))).thenReturn(rentDetailsEntity);

        rentService.saveRentDetails(rentDetails);

        verify(rentRepositoryMock.save(any(RentDetailsEntity.class)));
    }
}