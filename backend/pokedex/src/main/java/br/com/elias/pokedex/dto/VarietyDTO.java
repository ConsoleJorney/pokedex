package br.com.elias.pokedex.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VarietyDTO {

    private boolean is_default;

    private VarietyPokemonDTO pokemon;

    public boolean isIs_default() {
        return is_default;
    }

    public VarietyPokemonDTO getPokemon() {
        return pokemon;
    }

}