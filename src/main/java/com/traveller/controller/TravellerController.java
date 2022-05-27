package com.traveller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@GetMapping("update/{codLocalidade}/{latitude}/{longitude}/{logradouro}/{numero}/{complemento}/{CEP}/{site}")
	public String update(@PathVariable Long codLocalidade, @PathVariable double latitude, @PathVariable double longitude, @PathVariable String logradouro, @PathVariable String numero, @PathVariable String complemento, @PathVariable String CEP, @PathVariable String site) {
		
		Traveller trav = travellerRepository.getById(codLocalidade);
		trav.setLatitude(latitude);
		trav.setLongitude(longitude);
		trav.setLogradouro(logradouro);
		trav.setNumero(numero);
		trav.setComplemento(complemento);
		trav.setCEP(CEP);
		trav.setSite(site);
		
		travellerRepository.save(trav);
		
		return "redirect:/listaDados";
	}
	
}
