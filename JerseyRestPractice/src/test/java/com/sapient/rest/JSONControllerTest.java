package com.sapient.rest;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;
import org.junit.Before;
import org.junit.Test;

public class JSONControllerTest {

	@Before
	public void beforeSetup() {
	}

	// @Test
	public void getAllTest() {
		Client client = ClientBuilder.newClient();

		WebTarget target = client.target(getBaseURI());

		Response response = target.path("rest/json/getAll").request(MediaType.APPLICATION_JSON).get();
		String s = response.readEntity(String.class);
		System.out.println(response.getStatus());
		System.out.println(s);
	}

	 @Test
	public void getSpecificTest() {

		Client client = ClientBuilder.newClient();

		WebTarget target = client.target(getBaseURI());

		Response response = target.path("rest/json").queryParam("id", "1").request(MediaType.APPLICATION_JSON).get();
		String s = response.readEntity(String.class);
		System.out.println(response.getStatus());
		System.out.println(s);
	}

	private URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/RestWithJersey").build();
	}

	@Test
	public void applyingCustomMessageBody() {
		

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(getBaseURI());
		Response response = target.path("rest/json/getAll").request(MediaType.APPLICATION_JSON).get();
		String s = response.readEntity(String.class);
		System.out.println(response.getStatus());
		System.out.println(s);

	}

	public void sendJsonRequest() {

		Client client = ClientBuilder.newClient();

		WebTarget target = client.target(getBaseURI());

		Response response = target.path("rest/json").queryParam("id", "2").request(MediaType.APPLICATION_JSON).get();
		String s = response.readEntity(String.class);
		System.out.println(response.getStatus());
		System.out.println(s);
	}

}
