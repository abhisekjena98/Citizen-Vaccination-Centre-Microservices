package com.personal.microservices.CitizenService.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personal.microservices.CitizenService.Entity.Citizen;
import com.personal.microservices.CitizenService.Repository.CitizenRepo;

@RestController
@RequestMapping("/citizen")
public class CitizenController {
	
	@Autowired
	private CitizenRepo citizenRepo;
	
	@RequestMapping(path="/test")
	public ResponseEntity<String> test(){
		
		return new ResponseEntity<>("HELLO TEST",HttpStatus.OK);
	}
	
	@RequestMapping(path="/id/{id}")
	public ResponseEntity<List<Citizen>> getById(@PathVariable int id){
			
		List<Citizen> respObj = citizenRepo.findByVaccinationCentreId(id);
		
		return new ResponseEntity<>(respObj,HttpStatus.OK);
	}
	
	@PostMapping(path="/add")
	public ResponseEntity<Citizen> addCitizen(@RequestBody Citizen reqObj) {
		
		//Citizen demo = new citi;
		//demo.getId();
		//System.out.println(reqObj.getName());
		Citizen respObj = citizenRepo.save(reqObj);
		
		return new ResponseEntity<>(respObj , HttpStatus.OK);
		
	}

}
