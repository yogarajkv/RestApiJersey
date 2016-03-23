package com.sapient.rest;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sapient.pojo.Todo;
import com.sapient.service.TodoDAOService;
import com.sapient.service.TodoDAOServiceImpl;

@Path("/json")
public class JSONController {

	private TodoDAOService service;

	public JSONController() {
		service = new TodoDAOServiceImpl();
	}

	@Path("getAll")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllTodo() {
		List<Todo> result = service.getAllTodo();
		Response response = Response.ok(new GenericEntity<List<Todo>>(result){}).build();
		return response;
	}
	
	@Path("add")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void add(Todo todo,@Context HttpServletResponse response) throws IOException
	{
		service.addTodo(todo);
		response.sendRedirect("getAll");		
	}
	

	@Path("addAll")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addAll(List<Todo> todoList,@Context HttpServletResponse response) throws IOException
	{
		service.addAll(todoList);
		response.sendRedirect("getAll");
		
	}
	
	@Path("delete/{id}")
	@DELETE	
	public void delete(@PathParam("id") String id, @Context HttpServletResponse response) throws IOException
	
	{
		System.out.println("service came here" + id);
		service.deleteTodo(id);		
	}

	@Path("update")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void put(Todo todo)
	{
		service.addTodo(todo);
	}
	
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	@Path("{id}")
	public Todo getTodo(@PathParam("id") String id, @Context HttpHeaders hh) {
		return service.getTodo(id);
	}

}
