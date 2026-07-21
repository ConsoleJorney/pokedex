package br.com.elias.pokedex.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NameDTO {

    private String name;
    private LanguageDTO language;

    public String getName() {
        return name;
    }

    public LanguageDTO getLanguage() {
        return language;
    }

}