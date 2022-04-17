package com.example.springcrud.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "rent_apartment")
public class RentApartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id_rent;

    @Column(name = "id_apartment")
    private long id_apartment;

    @Column(name = "start_rent")
    @Temporal(TemporalType.DATE)
    private Date start_rent;

    @Column(name = "end_rent")
    @Temporal(TemporalType.DATE)
    private Date end_rent;
}
