package com.javaegitimleri.petclinic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.javaegitimleri.petclinic.exception.OwnerNotFoundException;
import com.javaegitimleri.petclinic.model.Owner;
import com.javaegitimleri.petclinic.service.PetClinicService;

@RestController
@RequestMapping("/rest")
public class PetClinicRestController {
	@Autowired
	private PetClinicService petClinicService;
	
	@PostMapping("/owner")
	@ResponseStatus(code=HttpStatus.CREATED)
	public Long createOwner(@RequestBody Owner owner) {
		petClinicService.create(owner);
		return owner.getId();
	}
	
	
	@PutMapping("/owner/{id}")
	public void createOrUpdate(Owner owner, @PathVariable Long id) {
		Owner ownerFromDB = petClinicService.getOwner(id);
		if(ownerFromDB == null) {
			petClinicService.create(owner);
		} else {
			ownerFromDB.setEmail(owner.getEmail());
			ownerFromDB.setFirstName(owner.getFirstName());
			ownerFromDB.setLastName(owner.getLastName());
			petClinicService.update(ownerFromDB);
		}
	}
	
	@DeleteMapping("/owner/{id}")
	public void delete(@PathVariable Long id) {
		petClinicService.delete(id);
	}
	
	@GetMapping("/owners")
	public List<Owner> getOwners() {
		return petClinicService.getOwners(); 
	}
	
	@GetMapping("/owner/{id}")
	public Owner getOwner(@PathVariable("id") Long id) {
		Owner owner = petClinicService.getOwner(id);
		
		if(owner == null) throw new OwnerNotFoundException();
		
		return owner;
	}
}