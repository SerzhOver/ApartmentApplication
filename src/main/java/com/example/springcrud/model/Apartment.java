package com.example.springcrud.model;

import lombok.*;


@Getter
@Setter
@ToString
@AllArgsConstructor
public class Apartment {

	private int id;
	private String city;
	private int price;
	private int countOfRoom;

}
