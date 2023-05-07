package com.personal.microservices.VaccinationCentre.Entity;

import java.util.List;

import com.personal.microservices.CitizenService.Entity.Citizen;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequiredResponse {

	private VaccinationCentre centre;
	
	private List<Citizen> citizens;

	public VaccinationCentre getCentre() {
		return centre;
	}

	public void setCentre(VaccinationCentre centre) {
		this.centre = centre;
	}

	public List<Citizen> getCitizens() {
		return citizens;
	}

	public void setCitizens(List<Citizen> citizens) {
		this.citizens = citizens;
	}
	
	
}
