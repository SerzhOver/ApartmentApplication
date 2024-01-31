package com.example.springcrud;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.springcrud.persistence.entity.ApartmentEntity;
import com.example.springcrud.persistence.mapper.ApartmentMapper;
import com.example.springcrud.model.Apartment;
import com.example.springcrud.persistence.repository.ApartmentRepository;
import com.example.springcrud.service.ApartmentService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class ApartmentServiceTest {

    @InjectMocks
    private ApartmentService fixture;

    @Mock
    private ApartmentRepository apartmentRepositoryMock;
    @Mock
    private ApartmentMapper apartmentMapper;

    private ApartmentEntity apartmentEntity;
    private Apartment apartment;

    private static ApartmentEntity mockApartmentEntity() {
        return ApartmentEntity.builder()
            .id(1L)
            .city("Berlin")
            .price(3000)
            .countOfRooms(2)
            .build();
    }

    private static Apartment mockApartment() {
        return Apartment.builder()
            .city("Berlin")
            .price(3000)
            .countOfRooms(2)
            .build();
    }

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        apartmentEntity = mockApartmentEntity();
        apartment = mockApartment();
    }

    @Test
    void saveApartmentTest() {
        when(apartmentMapper.toEntity(any(Apartment.class))).thenReturn(apartmentEntity);

        fixture.saveApartment(apartment);

        verify(apartmentRepositoryMock).save(any(ApartmentEntity.class));
    }

    @Test
    void getApartmentTest() {
        when(apartmentRepositoryMock.findById(anyLong())).thenReturn(Optional.of(apartmentEntity));
        when(apartmentMapper.toDto(any(ApartmentEntity.class))).thenReturn(apartment);

        Apartment foundedApartment = fixture.findApartmentById(1L);

        assertNotNull(foundedApartment);
        assertEquals("Berlin", foundedApartment.getCity());

        verify(apartmentRepositoryMock, Mockito.times(1)).findById(1L);

    }

    @Test
    void getAllApartmentTest() {
        List<ApartmentEntity> testApartmentListEntity = new ArrayList<>() {{
            add(apartmentEntity);
            add(apartmentEntity);
        }};

        when(apartmentRepositoryMock.findAll()).thenReturn(testApartmentListEntity);

        List<Apartment> apartmentList = fixture.findAllApartments();

        assertNotNull(apartmentList);
        assertEquals(2, apartmentList.size());
    }

    @Test
    void editApartmentTest() {
        when(apartmentRepositoryMock.findById(anyLong())).thenReturn(Optional.of(apartmentEntity));
        when(apartmentRepositoryMock.save(any(ApartmentEntity.class))).thenReturn(apartmentEntity);

        Apartment foundedApartment = fixture.findApartmentById(1L);
        foundedApartment.setCity("Gdansk");

        fixture.saveApartment(foundedApartment);

        verify(apartmentRepositoryMock.save(any(ApartmentEntity.class)));
    }

    @Test
    void deleteApartmentTest() {
        fixture.deleteById(1L);
        Mockito.verify(apartmentRepositoryMock, Mockito.times(1)).deleteById(anyLong());
    }
}