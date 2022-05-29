package com.traveller.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AcomodacaoDto {



	    @NotBlank
	    @Size(max = 2)
		private int capacidadeAcomodacao;
	    @NotBlank
	    @Size(max = 15)
		private String tipoCama;
	    @NotBlank
		private boolean wifi;
	    @NotBlank
		private boolean cafeManha;
	    @NotBlank
		private boolean disponibilidade;

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
