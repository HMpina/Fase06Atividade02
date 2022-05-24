package com.traveller.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class Traveller {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	
	private Long codLocalidade;
	private String nomeLocal;
	private double avaliacaoMedia;
	private String categoria;
	private double latitude;
	private double longitude;
	private String logradouro;
	private String numero;
	private String complemento;
	private String estado;
	private String cidade;
	private String CEP;
	private String site;
	private String telefoneLocal;
	
	
	
	public Long getCodLocalidade() {
		return codLocalidade;
	}
	public void setCodLocalidade(Long codLocalidade) {
		this.codLocalidade = codLocalidade;
	}
	public String getNomeLocal() {
		return nomeLocal;
	}
	public void setNomeLocal(String nomeLocal) {
		this.nomeLocal = nomeLocal;
	}
	public double getAvaliacaoMedia() {
		return avaliacaoMedia;
	}
	public void setAvaliacaoMedia(double avaliacaoMedia) {
		this.avaliacaoMedia = avaliacaoMedia;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String número) {
		this.numero = número;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getCEP() {
		return CEP;
	}
	public void setCEP(String cEP) {
		CEP = cEP;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getTelefoneLocal() {
		return telefoneLocal;
	}
	public void setTelefoneLocal(String telefoneLocal) {
		this.telefoneLocal = telefoneLocal;
	}

	
	
}
