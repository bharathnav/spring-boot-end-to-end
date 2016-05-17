package com.locassa.demo.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * Pojo or model class to represent Address of a person.
 * 
 * @author Bharat Navali
 */
@Entity
@Table(name = "address")
public class Address {
	
	/*
	 * Id of a person.
	 */
	@Id
    @GeneratedValue
    private Long id;

	/*
	 * House number for address of a person.
	 */
	@JsonView(View.Summary.class)
	private String houseNumber;

	/*
	 * Street name for address of a person.
	 */
	@JsonView(View.Summary.class)
	private String streetName;

	/*
	 * City for address of a person.
	 */
	@JsonView(View.Summary.class)
	private String city;
	
	/*
	 * Address for a person.
	 */
	@OneToOne(fetch = FetchType.EAGER)
	@PrimaryKeyJoinColumn
	@Fetch(FetchMode.JOIN)
	private Person person;
	
	/**
	 * Method to get id of an address.
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Method to set id of an address.
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Method to get the house number for address of a person.
	 * 
	 * @return houseNumber
	 */
	public String getHouseNumber() {
		return houseNumber;
	}

	/**
	 * Method to set the house number for address of a person.
	 * 
	 * @param houseNumber
	 */
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	/**
	 * Method to get the street name for address of a person.
	 * 
	 * @return streetName
	 */
	public String getStreetName() {
		return streetName;
	}

	/**
	 * Method to set the street name for address of a person.
	 * 
	 * @param streetName
	 */
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	/**
	 * Method to get the city name for address of a person.
	 * 
	 * @return city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Method to set the city name for address of a person.
	 * 
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Method to get person of an address.
	 * @return {@link Person}
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * Method to set person of an address.
	 * @param person
	 */
	public void setPerson(Person person) {
		this.person = person;
	}
}
