package com.personal.microservices.CitizenService.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Citizen {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column
	private String name;
	
	@Column
	private int vaccinationCentreId;

	
	
	public Citizen() {
		super();
	}

	public Citizen(Integer id, String name, int vaccinationCentreId) {
		super();
		this.id = id;
		this.name = name;
		this.vaccinationCentreId = vaccinationCentreId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVaccinationCentreId() {
		return vaccinationCentreId;
	}

	public void setVaccinationCentreId(int vaccinationCentreId) {
		this.vaccinationCentreId = vaccinationCentreId;
	}

	
	
}
