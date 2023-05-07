package com.personal.microservices.VaccinationCentre.Controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.personal.microservices.CitizenService.Entity.Citizen;
import com.personal.microservices.VaccinationCentre.Entity.RequiredResponse;
import com.personal.microservices.VaccinationCentre.Entity.VaccinationCentre;
import com.personal.microservices.VaccinationCentre.Repository.CentreRepo;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;



@RestController
@RequestMapping(path="/vaccinationcentre")
public class VaccinationCentreController {

	@Autowired
	private CentreRepo centrerepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	//Logger log = LoggerFactory.getLogger(VaccinationCentreController.class);
	
	private static final Logger log = LogManager.getLogger(VaccinationCentreController.class);
	
	@PostMapping(path="/add")
	public ResponseEntity<VaccinationCentre> addVaccinationCentre(@RequestBody VaccinationCentre reqObj) {
		
		VaccinationCentre respObj = centrerepo.save(reqObj);
		
		return new ResponseEntity<>(respObj,HttpStatus.OK);
	}
	
	@GetMapping(path="/id/{id}")
	@CircuitBreaker(name = "vaccinationService" ,fallbackMethod = "findByIdFallBack")
	public ResponseEntity<RequiredResponse> findById(@PathVariable Integer id){
		
		RequiredResponse respObj = new RequiredResponse();
		
		// first get vaccination centre detail
		VaccinationCentre centres = centrerepo.findById(id).get();
		
		respObj.setCentre(centres);
		
		//then get all citizen registered or vaccination centre
		
		List<Citizen> citizenList = restTemplate.getForObject("http://CITIZEN-SERVICE/citizen/id/"+id, List.class);
		
		log.info(citizenList);
		respObj.setCitizens(citizenList);
		
		return new ResponseEntity<>(respObj,HttpStatus.OK);
	}
	
	public ResponseEntity<RequiredResponse> findByIdFallBack(@PathVariable Integer id,Exception e){
		
		RequiredResponse respObj = new RequiredResponse();
		
		
		VaccinationCentre centres = centrerepo.findById(id).get();
		
		respObj.setCentre(centres);
		
		log.info("FALL BACK METHOD Called CITIZEN SERVICE is Down");
		
		return new ResponseEntity<>(respObj,HttpStatus.OK);
	}
}
