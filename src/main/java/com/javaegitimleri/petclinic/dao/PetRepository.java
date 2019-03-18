package com.javaegitimleri.petclinic.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaegitimleri.petclinic.model.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {

}
