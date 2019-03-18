package com.javaegitimleri.petclinic.service;

import java.util.List;

import com.javaegitimleri.petclinic.model.Owner;

public interface PetClinicService {
	List<Owner> getOwners();
	Owner getOwner(Long id);
	void create(Owner owner);
	void update(Owner owner);
	void delete(Long id);
}
