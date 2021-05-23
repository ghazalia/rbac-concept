package com.example.rbacconcept.repository;

import com.example.rbacconcept.pets.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends CrudRepository<Pet, Integer> {

}
