package com.app.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.demo.entity.Pets;
import com.app.demo.service.PetsServiceInterface;

@Controller
@RequestMapping("/code")
public class PetsController {
	
	@Autowired
	private PetsServiceInterface petsServiceInterface;
	
	@PostMapping("/save")
	public ResponseEntity<Pets> addPets(@RequestBody Pets pets){
		Pets petsSaved = petsServiceInterface.addPets(pets);
		return new ResponseEntity<Pets>(petsSaved, HttpStatus.CREATED);
	}
	
	@PostMapping("/update/{petid}")
	public ResponseEntity<Pets> updatePets(@PathVariable("petid") Long petidL,@RequestBody Pets pets){
		Pets petsSaved = petsServiceInterface.updatePets(petidL,pets);
		return new ResponseEntity<Pets>(petsSaved, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Pets>> getAllPets(){
		List<Pets> allPets = petsServiceInterface.getAllPets();
		return new ResponseEntity<List<Pets>>(allPets, HttpStatus.OK);
	}
	
	@GetMapping("/pet/{petid}")
	public ResponseEntity<Pets> getPetById(@PathVariable("petid") Long petidL){
		Pets petRetrieved = petsServiceInterface.getPetById(petidL);
		return new ResponseEntity<Pets>(petRetrieved, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{petid}")
	public ResponseEntity<Void> deletePetById(@PathVariable("petid") Long petidL){
		petsServiceInterface.deletePetById(petidL);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		
		
		
	}
}
