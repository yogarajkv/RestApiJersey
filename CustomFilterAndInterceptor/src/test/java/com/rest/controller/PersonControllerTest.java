package com.rest.controller;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientResponse;
import org.junit.Test;

import com.rest.model.Person;

public class PersonControllerTest {

	//@Test
	public void getAllPerson() {
		Client client = ClientBuilder.newClient();
		Response response = client.target(getBaseURI()).path("/person/person").request(MediaType.APPLICATION_JSON)
				.get();
		String s = response.readEntity(String.class);
		System.out.println(response.getStatus());
		System.out.println(s);
		System.out.println(response.getHeaders());
	}

	//@Test
	public void getAllPersonWithClientFilter()
	{
		Client client = ClientBuilder.newClient().
				register(com.rest.customInterceptors.GZipReaderInterceptor.class)
				.register(com.rest.customProviders.JSONListMessageBodyProvider.class)
				.register(com.rest.customProviders.JSONMessageBodyProvider.class);
		Response response = client.target(getBaseURI()).path("/person/person").queryParam("name", "Yogaraj").request(MediaType.APPLICATION_JSON).get();
		String s = response.readEntity(String.class);
		System.out.println(response.getStatus());
		System.out.println(s);
	}
	
	@Test
	public void addPerson()
	{
		Client client = ClientBuilder.newClient().
				register(com.rest.customInterceptors.GZipReaderInterceptor.class)
				.register(com.rest.customInterceptors.GZipWriterInterceptor.class)
				.register(com.rest.customProviders.JSONListMessageBodyProvider.class)
				.register(com.rest.customProviders.JSONMessageBodyProvider.class);
		Person p = new Person("Rahul", 30);
		client.target(getBaseURI()).path("/person/person/add").request(MediaType.APPLICATION_JSON).post(Entity.entity(p, MediaType.APPLICATION_JSON));
		getAllPersonWithClientFilter();
		
		 client.target(getBaseURI()).path("/person/person/delete").request(MediaType.TEXT_PLAIN).delete();
		getAllPersonWithClientFilter();
		
	}
	
	//@Test
	public void interceptorTest()
	{
		Client client = ClientBuilder.newClient().
				register(com.rest.customInterceptors.GZipReaderInterceptor.class)
				.register(com.rest.customProviders.JSONListMessageBodyProvider.class)
				.register(com.rest.customProviders.JSONMessageBodyProvider.class);
		Response response = client.target(getBaseURI()).path("/person/person").request(MediaType.APPLICATION_JSON).get();
		String s = response.readEntity(String.class);
		System.out.println(response.getStatus());
		System.out.println(s);
		System.out.println(response.getHeaders());
	}
	
	private URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/JerseyRestWithCustomMessageBody").build();
	}

}
