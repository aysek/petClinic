package com.package1.services;

import java.util.List;

import com.package1.Repository.OwnerRepository;
import com.package1.entity.Owner;

import org.springframework.stereotype.Service;

@Service
public interface PetClinicService {
	List<Owner> findAll();
	Owner findOwner(Long id);
}
