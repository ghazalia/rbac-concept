package com.example.rbacconcept.repository;

import com.example.rbacconcept.pets.Owner;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Integer> {

    @Query("select DISTINCT owner FROM Owner owner left join fetch owner.pets WHERE owner.name LIKE :name%")
    Collection<Owner> findOwnerByName(@Param("name") String name);

}
