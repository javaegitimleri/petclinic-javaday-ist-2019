package com.javaegitimleri.petclinic.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javaegitimleri.petclinic.service.PetClinicService;

@Controller
public class OwnersController {
	
	@Autowired
	private PetClinicService petClinicService;
	
	@GetMapping
	public String displayIndex() {
		return "redirect:/owners";
	}
	
	
	@GetMapping("/owners")
	public ModelAndView displayOwnersPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/jsp/owners.jsp");
		mav.addObject("owners", petClinicService.getOwners());
		return mav;
	}
}
