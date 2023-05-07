package com.personal.microservices.VaccinationCentre.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personal.microservices.VaccinationCentre.Entity.VaccinationCentre;

public interface CentreRepo extends JpaRepository<VaccinationCentre,Integer>{
	
	//public List<VaccinationCentre> findBy

}
