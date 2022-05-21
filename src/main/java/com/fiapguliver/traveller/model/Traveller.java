package com.fiapguliver.traveller.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Traveller {
	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	
	private Long codLocalidade;
	private String nomeLocal;
	private double avaliacaoMedia;
	private String categoria;
	private double latitude;
	private double longitude;
	private String logradouro;
	private String número;
	private String complemento;
	private String estado;
	private String cidade;
	private String CEP;
	private String site;
	private String telefoneLocal;
	
	
	
}
