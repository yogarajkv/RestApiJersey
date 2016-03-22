package com.rest.controller;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.junit.Test;

public class PersonControllerTest {

	@Test
	public void getAllPerson() {
		Client client = ClientBuilder.newClient();
		Response response = client.target(getBaseURI()).path("/person/person").request(MediaType.APPLICATION_JSON)
				.get();
		String s = response.readEntity(String.class);
		System.out.println(response.getStatus());
		System.out.println(s);
	}

	private URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/JerseyRestWithCustomMessageBody").build();
	}

}
