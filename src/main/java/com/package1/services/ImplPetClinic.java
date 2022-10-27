package com.package1.services;

import java.util.List;

import com.package1.Repository.OwnerRepository;
import com.package1.Repository.PetRepository;
import com.package1.entity.Owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ImplPetClinic implements PetClinicService{


	private OwnerRepository ownerRepository;
	private PetRepository petRepository;

	@Autowired
	void setOwnerRepository(OwnerRepository ownerRepository) {
		this.ownerRepository = ownerRepository;
	}

	@Autowired
	void setPetRepository(PetRepository petRepository) {
		this.petRepository = petRepository;
	}

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

	@Override
	public void deleteOwner(Long id) {
		petRepository.deleteByOwnerId(id);
		ownerRepository.delete(id);
		if(true) throw new RuntimeException("testing rollback");
	}
}
