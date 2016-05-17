package com.locassa.demo.domain;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * Pojo or model class to represent Person.
 * 
 * @author Bharat Navali
 */
@Entity
@Table(name = "person")
public class Person {
	
	/*
	 * Id of a person.
	 */
	@Id
    @GeneratedValue
    @JsonView(View.Summary.class)
    private Long id;

	/*
	 * Name of the person.
	 */
	@JsonView(View.Summary.class)
	private String name;

	/*
	 * Age of the person.
	 */
	@JsonView(View.Summary.class)
	private int age;

	/*
	 * Address of a person.
	 */
	@OneToOne(fetch = FetchType.EAGER, mappedBy = "person", cascade=CascadeType.ALL)
	@Fetch(FetchMode.JOIN)
	@JsonView(View.Summary.class)
	private Address address;
	
	/**
	 * Method to get id of person.
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Method to set id of a person.
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Method to get the name of a person.
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Method to set the name of a person
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Method to get the age of a person.
	 * 
	 * @return age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Method to set the age of a person
	 * 
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Method to get address of a person.
	 * 
	 * @return {@link Address}
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * Method to set address of a person.
	 * 
	 * @param address
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
}
