package com.traveller.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.traveller.model.Traveller;
import com.traveller.repository.TravellerRepository;

@RestController
@RequestMapping("/traveller")
public class TravellerControllerAPI {

	@Autowired
	private TravellerRepository travellerRepository;
	
	@GetMapping("/health")
	public String health(){
		return "Aplicacao online";
	}
	
	@PostMapping
	public Traveller adicionar(@RequestBody Traveller traveller) {
		return travellerRepository.save(traveller);
	}
	
	@GetMapping
	public List<Traveller> listar() {
		return travellerRepository.findAll();
	}
 
	@GetMapping("/{cod_localidade}")
	public ResponseEntity<Traveller> buscar(@PathVariable Long codLocalidade) {
		
		Traveller traveller = travellerRepository.getById(codLocalidade);
		
		if (traveller == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(traveller);
	}
	
	@PutMapping("/{cod_localidade}")
	public ResponseEntity<Traveller> atualizar(@PathVariable Long codLocalidade, 
			@RequestBody Traveller traveller) {
		Traveller existente = travellerRepository.getById(codLocalidade);
		
		if (existente == null) {
			return ResponseEntity.notFound().build();
		}
		
		BeanUtils.copyProperties(traveller, existente, "cod_localidade");
		
		existente = travellerRepository.save(existente);
		
		return ResponseEntity.ok(existente);
	}

	@DeleteMapping("/{cod_localidade}")
	public ResponseEntity<Void> remover(@PathVariable Long codLocalidade) {
		Traveller traveller = travellerRepository.getById(codLocalidade);
		
		if (traveller == null) {
			return ResponseEntity.notFound().build();
		}
		
		travellerRepository.delete(traveller);
		
		return ResponseEntity.noContent().build();
	}
}


