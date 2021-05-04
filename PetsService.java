package com.app.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.demo.entity.Pets;
import com.app.demo.repos.PetsRepo;

@Service
public class PetsService implements PetsServiceInterface {
	
	@Autowired
	private PetsRepo petsRepo;

	@Override
	public Pets addPets(Pets pets) {
		Pets p = new Pets();
		p.setName(pets.getName());
		p.setType(pets.getType());
		p.setPrice(pets.getPrice());
		Pets savedPets = petsRepo.save(p);
		return savedPets;
		
	}

	@Override
	public List<Pets> getAllPets() {
		return petsRepo.findAll();
	}

	@Override
	public Pets getPetById(Long petidL) {
		return petsRepo.findById(petidL).get();
	}

	@Override
	public void deletePetById(Long petidL) {
		petsRepo.deleteById(petidL);
		
	}

	@Override
	public Pets updatePets(Long petidL, Pets pets) {
		Optional<Pets> pet=Optional.ofNullable(petsRepo.findById(petidL).get());
		if(pet.isPresent()) {
			Pets p1=pet.get();
			if(pets.getName()!= null) {
				p1.setName(pets.getName());
			}
			
			if(pets.getType()!= null) {
				p1.setType(pets.getType());
			}
			
			if(pets.getPrice()!= 0) {
				p1.setPrice(pets.getPrice());
			}
			petsRepo.save(p1);
			return p1;
		}
		return null;
	}
	
	

}
