package com.app.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.demo.entity.Pets;

@Repository
public interface PetsRepo extends JpaRepository<Pets,Long> {

}
