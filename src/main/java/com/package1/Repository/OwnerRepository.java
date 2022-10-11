package com.package1.Repository;

import java.util.List;

import com.package1.entity.Owner;

public interface OwnerRepository{
	List<Owner> findAll();
	Owner findOwners(Long id);
	void create(Owner owner);

}
