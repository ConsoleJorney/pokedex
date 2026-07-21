package br.com.elias.pokedex.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonStatsDTO {

	private int base_stat;
	private StatDTO stat;


	public int getBase_stat() {
		return base_stat;
	}


	public void setBase_stat(int base_stat) {
		this.base_stat = base_stat;
	}


	public StatDTO getStat() {
		return stat;
	}


	public void setStat(StatDTO stat) {
		this.stat = stat;
	}

}