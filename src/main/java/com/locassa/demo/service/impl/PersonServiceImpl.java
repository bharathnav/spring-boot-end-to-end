package com.locassa.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.locassa.demo.dao.PersonRepository;
import com.locassa.demo.domain.Address;
import com.locassa.demo.domain.Person;
import com.locassa.demo.service.PersonService;

@Service("personService")
public class PersonServiceImpl implements PersonService {

	/*
	 * Reference to repository class.
	 */
	@Autowired
	PersonRepository personRepository;

	/**
	 * Method to save a person.
	 * 
	 * @param person
	 *            object.
	 * @return persisted person object.
	 */
	@Override
	public Person addPerson(Person person) {
		return personRepository.save(person);
	}
	
	/**
	 * Method to find all persons.
	 * 
	 * @return list of person objects.
	 */
	@Override
	public List<Person> getAllPersons() {
		return personRepository.findAll();
	}
	
	/**
	 * Method to find a person by id.
	 * 
	 * @param id
	 *            of a person.
	 * @return list of one person object.
	 */
	@Override
	public Person getPerson(Long id) {
		Person person = null;
		List<Person> persons = personRepository.findOne(id); 
		if (null != persons && persons.size() > 0) {
			person = persons.get(0);
		}
		return person;
	}
	
	/**
	 * Method to update a person.
	 * 
	 * @param personId
	 *            id of a person
	 * @param address
	 *            of a person
	 * @return persisted Person object.
	 */
	@Override
	public Person updatePerson(Long personId, Address address) {
		List<Person> persons = personRepository.findOne(personId);
		Person person = null;
		if (null != persons && persons.size() > 0) {
			person = persons.get(0);
			person.setAddress(address);
			personRepository.save(person);
		}
		return person;
	}
}
