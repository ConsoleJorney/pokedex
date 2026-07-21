package br.com.elias.pokedex.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonSpeciesDTO {

	@JsonProperty("flavor_text_entries")
	private List<FlavorTextDTO> flavorTextEntries;

	@JsonProperty("names")
	private List<NameDTO> names;

	@JsonProperty("varieties")
	private List<VarietyDTO> varieties;

	public PokemonSpeciesDTO() {
	}

	public List<FlavorTextDTO> getFlavorTextEntries() {
		return flavorTextEntries;
	}

	public void setFlavorTextEntries(List<FlavorTextDTO> flavorTextEntries) {
		this.flavorTextEntries = flavorTextEntries;
	}

	public List<NameDTO> getNames() {
		return names;
	}

	public void setNames(List<NameDTO> names) {
		this.names = names;
	}

	public List<VarietyDTO> getVarieties() {
		return varieties;
	}

	public void setVarieties(List<VarietyDTO> varieties) {
		this.varieties = varieties;
	}

}