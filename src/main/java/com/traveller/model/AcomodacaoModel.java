package com.traveller.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

//import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "acomodacao")
public class AcomodacaoModel{
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long codAcomodacao;
    @Column(nullable = false)
	private int capacidadeAcomodacao;
    @Column(nullable = false)
    private String tipoCama;
    @Column(nullable = false)
	private boolean wifi;
    @Column(nullable = false)
	private boolean cafeManha;
    @Column(nullable = false)
	private boolean disponibilidade;
	
	
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
	public boolean isDisponibilidade() {
		return disponibilidade;
	}
	public void setDisponibilidade(boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

}
