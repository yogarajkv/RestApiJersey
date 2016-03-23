package com.sapient.rest;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.junit.Test;

public class RestControllerTest {
	
	public void setUp()
	{
		
	}
	@Test
	public void run()
	{
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(getBaseURI());
		String response = target.path("rest").path("hello").request().accept(MediaType.TEXT_HTML).get(String.class);
		String plainAnswer = target.path("rest").path("hello").request().accept(MediaType.TEXT_PLAIN).get(String.class);
		String xmlAnswer = target.path("rest").path("hello").request().accept(MediaType.TEXT_XML).get(String.class);
		System.out.println(response);
		System.out.println(plainAnswer);
		System.out.println(xmlAnswer);
	}
	
	private URI getBaseURI()
	{
		return UriBuilder.fromUri("http://localhost:8080/RestWithJersey").build();
	}

}
