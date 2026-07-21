
package br.com.elias.pokedex.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AbilityDTO {

	private AbilityInfoDTO ability;


	public void AbilityInfoDTO() {
	}


	public void AbilityInfoDTO(AbilityInfoDTO ability) {
		this.ability = ability;
	}


	public AbilityInfoDTO getAbility() {
		return ability;
	}


	public void setAbility(AbilityInfoDTO ability) {
		this.ability = ability;
	}
}