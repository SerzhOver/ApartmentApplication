package com.example.springcrud.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class RentDetails {

    private long idApartment;
    private Date startRent;
    private Date endRent;
}