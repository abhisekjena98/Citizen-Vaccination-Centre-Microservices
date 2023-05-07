package com.personal.microservices.CitizenService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personal.microservices.CitizenService.Entity.Citizen;


public interface CitizenRepo extends JpaRepository<Citizen, Integer>{
	
	public List<Citizen> findByVaccinationCentreId(Integer id);

}
