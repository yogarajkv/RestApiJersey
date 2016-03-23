package com.rest.controller;

import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.rest.model.Person;
import com.rest.service.PersonService;
import com.rest.service.PersonServiceImpl;

@Path("/person")
public class PersonController {

	PersonService service;

	public PersonController() {
		service = new PersonServiceImpl();
	}

	@POST
	//@Path("{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Person getByPersonName(@QueryParam("name") String name) {
		System.out.println(name);
		return service.getPesonByName(name);
	}
	
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addPerson(Person person)
	{
		System.out.println("Add service"+person.getId()+person.getName());
		service.addPerson(person);
	}
	
	@DELETE
	@Path("delete")
	@Produces (MediaType.APPLICATION_JSON)
	@Consumes(MediaType.TEXT_PLAIN)
	public List<Person> deletePerson()
	{
		System.out.println("name");
		//service.deletePersonByName(name);
		return service.getAllPersons();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> getAllPersonDetails() {
		return service.getAllPersons();
	}

}
