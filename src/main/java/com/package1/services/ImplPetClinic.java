package com.package1.services;

import java.util.List;

import com.package1.Repository.OwnerRepository;
import com.package1.entity.Owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImplPetClinic implements PetClinicService{

	@Autowired
	private OwnerRepository ownerRepository;


	@Override
	public List<Owner> findAll() {
		return ownerRepository.findAll();
	}

	@Override
	public Owner findOwner(Long id) {
		return ownerRepository.findOwners(id);
	}

	@Override
	public void createOwner(Owner owner) {
	ownerRepository.create(owner);
	}
}
