package com.locassa.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.locassa.demo.domain.Address;
import com.locassa.demo.domain.Person;
import com.locassa.demo.domain.View;
import com.locassa.demo.service.impl.PersonServiceImpl;
import com.locassa.demo.util.LocassaConstants;

/**
 * Controller.
 * 
 * @author Bharat Navali
 */
@RestController
public class TestController {

	/*
	 * Person service reference.
	 */
	@Autowired
	private PersonServiceImpl personService;

	/**
	 * Service method to add a person.
	 * 
	 * @param person
	 *            object in JSON format.
	 * @return status of the request.
	 */
	@CrossOrigin
	@RequestMapping(value = "/addPerson", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<String> addPerson(@RequestBody Person person) {
		ResponseEntity<String> responseEntity = null;
		String response = "";
		if (person != null) {
			personService.addPerson(person);
			response = LocassaConstants.PERSON_CREATED_SUCCESSFULLY + person.getId();
			responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response = LocassaConstants.INVALID_REQUEST;
			responseEntity = new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}

	/**
	 * Service method to get all persons.
	 * 
	 * @return list of persons.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@CrossOrigin
	@JsonView(View.Summary.class)
	@RequestMapping(value = "/getAllPersons", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Person>> getAllPersons() {
		return new ResponseEntity(personService.getAllPersons(), HttpStatus.OK);
	}

	/**
	 * Service method to get a person.
	 * 
	 * @param id
	 *            of a person.
	 * @return person object.
	 */
	@CrossOrigin
	@JsonView(View.Summary.class)
	@RequestMapping(value = "/getPerson/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Object> getPerson(@PathVariable Long id) {
		ResponseEntity<Object> responseEntity = null;
		Person person = null;
		if (id >= 0) {
			person = personService.getPerson(id);
			if (person != null) {
				responseEntity = new ResponseEntity<>(person, HttpStatus.OK);
			} else {
				responseEntity = new ResponseEntity<>(LocassaConstants.PERSON_NOT_FOUND, HttpStatus.OK);
			}
		} else {
			responseEntity = new ResponseEntity<>(LocassaConstants.INVALID_ID,
					HttpStatus.NOT_ACCEPTABLE);
		}
		return responseEntity;
	}

	/**
	 * Service method to add an address to an existing person.
	 * 
	 * @param id
	 *            of a person.
	 * @param address
	 *            in JSON format.
	 * @return status of the request.
	 */
	@CrossOrigin
	@RequestMapping(value = "/addAddressToPerson/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<String> addAddressToPerson(@PathVariable Long id,
			@RequestBody Address address) {
		ResponseEntity<String> responseEntity = null;
		if (id >= 0 && null != address) {
			Person person = personService.updatePerson(id, address);
			if (null != person.getAddress() && person.getAddress().getId() > 0) {
				responseEntity = new ResponseEntity<>(LocassaConstants.ADDRESS_ADDED_SUCCESSFULLY, HttpStatus.OK);
			}
		} else {
			responseEntity = new ResponseEntity<>(LocassaConstants.INVALID_REQUEST,
					HttpStatus.NOT_ACCEPTABLE);
		}
		return responseEntity;
	}

}
