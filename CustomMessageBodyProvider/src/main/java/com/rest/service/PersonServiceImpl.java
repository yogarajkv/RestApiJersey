package com.rest.service;

import java.util.ArrayList;
import java.util.List;

import com.rest.model.Person;
import com.rest.model.PersonDao;

public class PersonServiceImpl implements PersonService {

	private PersonDao daoObject;

	public PersonServiceImpl() {
		daoObject = PersonDao.instance;
	}

	public int getPersonCount() {

		return daoObject.getModel().size();
	}

	public void addPerson(Person person) {
		daoObject.getModel().put(person.getName(), person);

	}

	public List<Person> getAllPersons() {
		List<Person> list = new ArrayList<Person>();
		for (String key : daoObject.getModel().keySet()) {
			list.add(daoObject.getModel().get(key));
		}
		return list;
	}

	public Person getPesonByName(String id) {

		if (daoObject.getModel().containsKey(id))
			return daoObject.getModel().get(id);
		return null;
	}

	public void deletePersonByName(String id) {
		if (daoObject.getModel().containsKey(id))
			daoObject.getModel().remove(id);
	}

}
