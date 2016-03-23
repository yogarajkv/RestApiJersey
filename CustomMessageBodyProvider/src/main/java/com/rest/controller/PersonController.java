package com.rest.controller;

import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rest.model.Person;
import com.rest.service.PersonService;
import com.rest.service.PersonServiceImpl;

@Path("/person")
public class PersonController {

	PersonService service;

	public PersonController() {
		System.out.println("new instance");
		service = new PersonServiceImpl();
	}

	@GET
	@Path("{name}")
	@Produces(MediaType.TEXT_PLAIN)
	public Person getByPersonName(@PathParam("name") String name) {
		System.out.println(name);
		return service.getPesonByName(name);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> getAllPersonDetails() {
		return service.getAllPersons();
	}

}
