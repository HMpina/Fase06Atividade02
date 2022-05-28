package com.traveller.controller;

import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.traveller.model.Acomodacao;
import com.traveller.repository.AcomodacaoRepository;

	
	@RestController
	@RequestMapping("/acomodacao")
	public class AcomodacaoController {

		//@Autowired
		private AcomodacaoRepository acomodacaoRepository;
		
		@GetMapping("/listaAcomodacao")
		public String listaAcomodacao(Model request) {
			List<Acomodacao> lista = acomodacaoRepository.findAll();
			request.addAttribute("listaAcomodacao", lista);
			return "listaAcomodacao";
		}
		
		@GetMapping("/formularioacomodacao2")
		public String formularioacomodacao2(Model request) {
			return "formularioacomodacao2";
		}

		@PostMapping("/acomodacaoNovo2")
		public String acomodacaoNovo2(Acomodacao requisicao) {
			acomodacaoRepository.save(requisicao);
			return "acomodacaoNovo2";
		}

	
	@GetMapping("/criar/{codAcomodacao}/{capacidadeAcomodacao}/{tipoCama}/{wifi}/{cafeManha}/{disponibilidade}")
	public String criar(@PathVariable Long codAcomodacao, @PathVariable int capacidadeAcomodacao, @PathVariable String tipoCama, @PathVariable boolean wifi, @PathVariable boolean cafeManha, @PathVariable boolean disponibilidade) {
	
	Acomodacao trav = acomodacaoRepository.getById(codAcomodacao);
	trav.setCapacidadeAcomodacao(capacidadeAcomodacao);
	trav.setTipoCama(tipoCama);
	trav.setWifi(wifi);
	trav.setCafeManha(cafeManha);
	trav.setDisponibilidade(disponibilidade);
	
	acomodacaoRepository.save(trav);
	
	return "redirect:/listaAcomodacao";
}

	@GetMapping("/reservar/{codAcomodacao}/{disponibilidade}")
	public String update(@PathVariable Long codAcomodacao, @PathVariable boolean disponibilidade) {
	
	Acomodacao trav = acomodacaoRepository.getById(codAcomodacao);
	trav.setDisponibilidade(disponibilidade);
	
	acomodacaoRepository.save(trav);
	
	return "redirect:/listaAcomodacao";
}
	
}
