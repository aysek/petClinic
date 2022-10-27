package com.package1.controller;

import java.net.URI;
import java.util.List;

import com.package1.entity.Owner;
import com.package1.services.PetClinicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/rest")//Sınıf dzeyinde tanımladık tüm metodlara eklememize gerek bırakmyor
public class PetClinicRestController {
	@Autowired
	private PetClinicService petClinicService;

	@RequestMapping(method = RequestMethod.POST,value = "/owner")
	public ResponseEntity<URI> createOwner(@RequestBody Owner owner){
		try {
			petClinicService.createOwner(owner);
			Long id = owner.getId();
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
			return ResponseEntity.created(location).build();
		}catch (Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@RequestMapping(method = RequestMethod.GET,value = "owners")
	public ResponseEntity<List<Owner>> getOwners(){
		List<Owner> owners =petClinicService.findAll();
		return ResponseEntity.ok(owners);
	}

	@RequestMapping(method = RequestMethod.GET,value = "/owner/{id}")//(http://localhost:9081/rest/owner?id=1)
	public ResponseEntity<Owner> getOwner(@PathVariable("id") Long id){
		Owner owner=petClinicService.findOwner(id);
		return ResponseEntity.ok(owner);
	}

}
