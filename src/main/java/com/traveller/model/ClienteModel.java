package com.traveller.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

//import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "cliente-db")
public class ClienteModel {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long codCliente;
    @Column(nullable = false)
	private String emailCliente;
    @Column(nullable = false)
    private String telefoneCliente;
    
}