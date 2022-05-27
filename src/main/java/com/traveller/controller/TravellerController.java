package com.traveller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.traveller.model.Traveller;
import com.traveller.repository.TravellerRepository;

@Controller
@RequestMapping("/")
public class TravellerController {

	@Autowired
	private TravellerRepository travellerRepository;
	
	@GetMapping("hotel")
	public String hotel(Model request) {
		request.addAttribute("categoria", "hotel");
		return "hotel";
	}
	
	@GetMapping("listaDados")
	public String listaDados(Model request) {
		List<Traveller> lista = travellerRepository.findAll();
		request.addAttribute("listaDados", lista);
		return "listaDados";
	}

	@GetMapping("formulario")
	public String formulario(Model request) {
		return "formulario";
	}

	@PostMapping("formularioNovo")
	public String formularioNovo(Traveller requisicao) {
		travellerRepository.save(requisicao);
		return "listaDados";
	}

	
}
