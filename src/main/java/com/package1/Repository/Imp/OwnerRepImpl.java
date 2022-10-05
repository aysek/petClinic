package com.package1.Repository.Imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.package1.Repository.OwnerRepository;
import com.package1.entity.Owner;

import org.springframework.stereotype.Repository;

@Repository
public class OwnerRepImpl implements OwnerRepository {

	private Map<Long,Owner> ownersMap = new HashMap<>();

	public OwnerRepImpl(){
		Owner owner1=new Owner();
		owner1.setId(1L);
		owner1.setFirstName("ayse");
		owner1.setLastName("aaa");

		Owner owner2=new Owner();
		owner2.setId(2L);
		owner2.setFirstName("ayse2");
		owner2.setLastName("aaa2");

		Owner owner3=new Owner();
		owner3.setId(2L);
		owner3.setFirstName("ayse3");
		owner3.setLastName("aaa3");

		Owner owner4=new Owner();
		owner4.setId(2L);
		owner4.setFirstName("ayse4");
		owner4.setLastName("aaa4");

		ownersMap.put(owner1.getId(),owner1);
		ownersMap.put(owner2.getId(),owner2);
		ownersMap.put(owner3.getId(),owner3);
		ownersMap.put(owner4.getId(),owner4);
	}
	@Override
	public List<Owner> findAll() {
		return new ArrayList<>(ownersMap.values());
	}
}
