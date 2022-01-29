package com.example.springcrud.model;

import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "apartments")
public class Apartment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "city")
	private String city;

	@Column(name = "price")
	private int price;

	@Column(name = "room")
	private int countOfRoom;

}
