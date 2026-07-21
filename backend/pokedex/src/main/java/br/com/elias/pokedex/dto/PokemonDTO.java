package br.com.elias.pokedex.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonDTO {

	private int id;
	private String name;
	private int height;
	private int weight;
	private SpriteDTO sprites;
	private List<PokemonTypeDTO> types;

	private List<PokemonStatsDTO> stats;
	private List<AbilityDTO> abilities;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getHeight() {
		return height;
	}

	public int getWeight() {
		return weight;
	}

	public SpriteDTO getSprites() {
		return sprites;
	}

	public void setSprites(SpriteDTO sprites) {
		this.sprites = sprites;
	}

	public List<PokemonTypeDTO> getTypes() {
		return types;
	}

	public void setTypes(List<PokemonTypeDTO> types) {
		this.types = types;
	}

	public List<PokemonStatsDTO> getStats() {
		return stats;
	}

	public void setStats(List<PokemonStatsDTO> stats) {
		this.stats = stats;
	}

	public List<AbilityDTO> getAbilities() {
		return abilities;
	}

	public void setAbilities(List<AbilityDTO> abilities) {
		this.abilities = abilities;
	}
}