package com.javaegitimleri.petclinic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pet {
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	
}
