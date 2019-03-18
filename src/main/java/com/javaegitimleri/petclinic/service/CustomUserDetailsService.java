package com.javaegitimleri.petclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.javaegitimleri.petclinic.dao.OwnerRepository;
import com.javaegitimleri.petclinic.model.Owner;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private OwnerRepository ownerRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Owner owner = ownerRepository.findByEmail(username);
		if(owner == null) throw new UsernameNotFoundException("User not found :" + username);
		return owner;
	}

}
