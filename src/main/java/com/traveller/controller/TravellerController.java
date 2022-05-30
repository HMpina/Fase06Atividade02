package com.traveller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.traveller.model.AcomodacaoModel;
import com.traveller.repository.AcomodacaoRepository;

public class TravellerController {

	
	@Controller
	@RequestMapping("/")
	public class AcomodacaoController {

		@Autowired
	    private AcomodacaoRepository acomodacaoRepository;



	    @GetMapping("listaAcomodacao")
		public String listaAcomodacao(Model request) {
			List<AcomodacaoModel> lista = acomodacaoRepository.findAll();
			request.addAttribute("listaAcomodacao", lista);	
			return "listaAcomodacao";
	    }
	
	}
}
