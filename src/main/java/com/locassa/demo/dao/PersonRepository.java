package com.locassa.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.Repository;

import com.locassa.demo.domain.Person;

/**
 * Repository class to interact with DB.
 * 
 * @author Bharat Navali
 *
 */
@Transactional
public interface PersonRepository extends Repository<Person, Long> {

	/**
	 * Method to find all persons.
	 * @return list of person objects.
	 */
	List<Person> findAll();

	/**
	 * Method to find a person by id.
	 * @param id of a person.
	 * @return list of one person object.
	 */
	List<Person> findOne(Long id);

	/**
	 * Method to save a person.
	 * @param person object.
	 * @return persisted person object.
	 */
	Person save(Person person);
}
