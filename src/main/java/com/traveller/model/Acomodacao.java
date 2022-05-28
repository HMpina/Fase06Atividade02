package com.traveller.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class Acomodacao{
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long codAcomodacao;
	private int capacidadeAcomodacao;
	private String tipoCama;
	private boolean wifi;
	private boolean cafeManha;
	private boolean disponibilidade;
	
	
	public boolean isDisponibilidade() {
		return disponibilidade;
	}
	public void setDisponibilidade(boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
	public Long getCodAcomodacao() {
		return codAcomodacao;
	}
	public void setCodAcomodacao(Long codAcomodacao) {
		this.codAcomodacao = codAcomodacao;
	}
	public int getCapacidadeAcomodacao() {
		return capacidadeAcomodacao;
	}
	public void setCapacidadeAcomodacao(int capacidadeAcomodacao) {
		this.capacidadeAcomodacao = capacidadeAcomodacao;
	}
	public String getTipoCama() {
		return tipoCama;
	}
	public void setTipoCama(String tipoCama) {
		this.tipoCama = tipoCama;
	}
	public boolean isWifi() {
		return wifi;
	}
	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}
	public boolean isCafeManha() {
		return cafeManha;
	}
	public void setCafeManha(boolean cafeManha) {
		this.cafeManha = cafeManha;
	}

}
