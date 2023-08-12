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
@Table(name = "rented_apartments")
public class RentedApartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long idRent;

    @Column(name = "id_apartment")
    private long idApartment;

    @Column(name = "start_rent")
    @Temporal(TemporalType.DATE)
    private Date startRent;

    @Column(name = "end_rent")
    @Temporal(TemporalType.DATE)
    private Date endRent;
}
