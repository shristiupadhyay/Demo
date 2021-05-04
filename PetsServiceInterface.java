package com.app.demo.service;

import java.util.List;

import com.app.demo.entity.Pets;

public interface PetsServiceInterface {

	public Pets addPets(Pets pets);

	public List<Pets> getAllPets();

	public Pets getPetById(Long petidL);

	public void deletePetById(Long petidL);

	public Pets updatePets(Long petidL, Pets pets);

}
