package com.rest.service;

import java.util.List;

import com.rest.model.Person;



public interface PersonService {
	
	int getPersonCount();

	void addPerson(Person person);

	List<Person> getAllPersons();
	
	Person getPesonByName(String id);
	
	void deletePersonByName(String id);

}
