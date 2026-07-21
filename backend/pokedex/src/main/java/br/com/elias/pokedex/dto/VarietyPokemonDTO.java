package br.com.elias.pokedex.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VarietyPokemonDTO {

    private String name;
    private String url;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

}