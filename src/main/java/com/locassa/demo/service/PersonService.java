package com.locassa.demo.service;

import java.util.List;

import com.locassa.demo.domain.Address;
import com.locassa.demo.domain.Person;

/**
 * Interface for Person service.
 * 
 * @author Bharat Navali
 */
public interface PersonService {

	/**
	 * Method to save a person.
	 * 
	 * @param person
	 *            object.
	 * @return persisted person object.
	 */
	public Person addPerson(Person person);

	/**
	 * Method to find all persons.
	 * 
	 * @return list of person objects.
	 */
	public List<Person> getAllPersons();

	/**
	 * Method to find a person by id.
	 * 
	 * @param id
	 *            of a person.
	 * @return list of one person object.
	 */
	public Person getPerson(Long id);

	/**
	 * Method to update a person.
	 * 
	 * @param personId
	 *            id of a person
	 * @param address
	 *            of a person
	 * @return persisted Person object.
	 */
	public Person updatePerson(Long personId, Address address);
}
