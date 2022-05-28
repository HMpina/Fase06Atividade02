package com.traveller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.traveller.model.Produto;
import com.traveller.repository.ProdutoRepository;


@Controller
@RequestMapping("/")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping("listaDados")
	public String listaDados(Model request) {
		List<Produto> lista = produtoRepository.findAll();
		request.addAttribute("listaDados", lista);
		return "listaDados";
	}

	@GetMapping("formulario")
	public String formulario(Model request) {
		return "formulario";
	}

	@PostMapping("formularioNovo")
	public String formularioNovo(Produto requisicao) {
		produtoRepository.save(requisicao);
		return "listaDados";
	}
		
	
	
}
