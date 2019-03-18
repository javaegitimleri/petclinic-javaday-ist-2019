package com.javaegitimleri.petclinic.init;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javaegitimleri.petclinic.model.Owner;
import com.javaegitimleri.petclinic.service.PetClinicService;

@Component
public class SampleDataPopulator {
	
	@Autowired
	private PetClinicService petClinicService;
	
	@PostConstruct
	public void init() {
		Owner o1 = new Owner();
		o1.setEmail("ksevindik@gmail.com");
		o1.setFirstName("Kenan");
		o1.setLastName("Sevindik");
		o1.setPassword("secret");
		
		petClinicService.create(o1);
	}
}
