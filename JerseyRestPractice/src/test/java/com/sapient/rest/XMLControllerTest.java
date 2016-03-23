package com.sapient.rest;

import java.net.URI;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.junit.Test;

import com.sapient.pojo.Todo;

public class XMLControllerTest {

	// @Test
	public void run() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(getBaseURI());
		String response = target.path("rest").path("xmltest").request().accept(MediaType.APPLICATION_XML)
				.get(String.class).toString();
		System.out.println(response);
	}

	private URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/RestWithJersey").build();
	}

	// @Test
	public void FormTest() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(getBaseURI());
		Form form = new Form();
		form.param("id", "3");
		form.param("description", "test description");
		target.path("rest").path("xmltest").request().accept(MediaType.APPLICATION_FORM_URLENCODED)
				.post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED));
		List<Todo> todoList = target.path("rest").path("xmltest").path("getAll").request()
				.accept(MediaType.APPLICATION_XML).get(new GenericType<List<Todo>>() {
				});
		for (Todo todo : todoList) {
			System.out.println(todo.getName() + ":" + todo.getDescription());
		}

		Response response = target.path("rest/xmltest/getAll").request().get();
		todoList = response.readEntity(new GenericType<List<Todo>>() {
		});

		for (Todo todo : todoList) {
			System.out.println(todo.getName() + ":" + todo.getDescription());
		}

	}

}
