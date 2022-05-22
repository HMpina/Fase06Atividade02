package com.fiapguliver.traveller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiapguliver.traveller.model.Traveller;
import com.fiapguliver.traveller.repository.TravellerRepository;


@RestController
@RequestMapping("/traveller")
public class TravellerController {

	@Autowired
	private TravellerRepository travellerRepository;
	
	@GetMapping("/health")
	public String health(){
		return "Aplicacao online";
	}
	

}
