package com.example.rbacconcept.service;

import com.example.rbacconcept.pets.Owner;
import com.example.rbacconcept.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class OwnerService {
    private OwnerRepository ownerRepository;

    @Autowired
    public OwnerService (OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public Owner save(Owner owner) {
        return ownerRepository.save(owner);
    }

    public Collection<Owner> findOwnerByName(Owner owner) throws Exception {
        Collection<Owner> owners = ownerRepository.findOwnerByName(owner.getName());

        if (owners.isEmpty()) {
            throw new Exception("Not Found");
        }

        return owners;
    }

    public Owner updateOwner(Owner owner) throws Exception{
        if (ownerRepository.findById(owner.getId()) == null) {
            throw new Exception("Not Found");
        } else {
            return ownerRepository.save(owner);
        }
    }

    public Owner findOwnerById(Integer ownerId) {
        return ownerRepository.findById(ownerId).orElseThrow(() -> new IllegalArgumentException());
    }
}
