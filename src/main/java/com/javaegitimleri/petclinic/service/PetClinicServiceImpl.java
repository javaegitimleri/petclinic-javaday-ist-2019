package com.javaegitimleri.petclinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaegitimleri.petclinic.dao.OwnerRepository;
import com.javaegitimleri.petclinic.dao.PetRepository;
import com.javaegitimleri.petclinic.model.Owner;

@Service
@Transactional
public class PetClinicServiceImpl implements PetClinicService {
	@Autowired
	private OwnerRepository ownerRepository;
	
	@Autowired
	private PetRepository petRepository;
	
	private PasswordEncoder passwordEncoder = 
			PasswordEncoderFactories.createDelegatingPasswordEncoder();

	@Override
	public List<Owner> getOwners() {
		return ownerRepository.findAll();
	}

	@Override
	public Owner getOwner(Long id) {
		return ownerRepository.findById(id).orElse(null);
	}

	@Override
	public void create(Owner owner) {
		owner.setPassword(passwordEncoder.encode(owner.getPassword()));
		ownerRepository.save(owner);
		//petRepository.save(pet);
	}

	@Override
	public void update(Owner owner) {
		ownerRepository.save(owner);
	}

	@Override
	public void delete(Long id) {
		ownerRepository.deleteById(id);
	}
	
	
	
}
