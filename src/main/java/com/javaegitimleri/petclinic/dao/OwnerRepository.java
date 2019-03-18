package com.javaegitimleri.petclinic.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaegitimleri.petclinic.model.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
	Owner findByEmail(String email);
}
