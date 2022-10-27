package com.package1.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement//xml formatında görüntüleyebilmek için
@Entity
@Table(name="owner")
public class Owner {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "petClinicSeqGen")
	@SequenceGenerator(name="petClinicSeqGen",sequenceName = "petclinic_sequence")
	private Long id;

	private String firstName;

	private String lastName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
