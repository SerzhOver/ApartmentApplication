package com.example.springcrud.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Apartment {

    private String city;
    private int price;
    private int countOfRooms;
}