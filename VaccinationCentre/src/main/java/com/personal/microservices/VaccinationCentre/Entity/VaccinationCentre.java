package com.personal.microservices.VaccinationCentre.Entity;

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
public class VaccinationCentre {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column
	private String centreName;
	
	@Column
	private String centreAddress;

	
	public VaccinationCentre() {
		super();
	}


	public VaccinationCentre(int id, String centreName, String centreAddress) {
		super();
		this.id = id;
		this.centreName = centreName;
		this.centreAddress = centreAddress;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCentreName() {
		return centreName;
	}


	public void setCentreName(String centreName) {
		this.centreName = centreName;
	}


	public String getCentreAddress() {
		return centreAddress;
	}


	public void setCentreAddress(String centreAddress) {
		this.centreAddress = centreAddress;
	}
	
	

}
