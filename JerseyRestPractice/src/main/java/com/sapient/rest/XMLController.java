package com.sapient.rest;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import com.sapient.pojo.MyBeanParam;
import com.sapient.pojo.Todo;
import com.sapient.service.TodoDAOService;
import com.sapient.service.TodoDAOServiceImpl;

@Path("/xmltest")
public class XMLController {

	private TodoDAOService service;
	
	@Context
	private UriInfo uriInfo;
	
	@Context
	private Request request;
	
	
	 public XMLController() {
		 service = new TodoDAOServiceImpl();
	 }
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Todo getTodoXML()
	{
		Todo temp = new Todo();
		temp.setName("My first Todo");
		temp.setDescription("My first todo description");
		return temp;
	}
	
	@GET
	@Path("count")
	@Produces(MediaType.TEXT_PLAIN)
	public int getTodoSize()
	{
		return service.getTodoCount();
	}
	
	@GET
	@Path("getAll")
	//@Produces(MediaType.TEXT_XML)
	public List<Todo> getAllTodo()
	{
		
		return service.getAllTodo();
	}
	
	@GET
	@Path("{id}")
	public Todo getTodo(@PathParam("id") String id)
	{
		return service.getTodo(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	//public void addTodo( MultivaluedMap<String,String> formParams, @Context  HttpServletResponse response, @Context HttpHeaders hh) throws IOException
	public void addTodo( @BeanParam MyBeanParam formParams, @Context  HttpServletResponse response, @Context HttpHeaders hh) throws IOException
	{
		System.out.println("Add To Do");
		System.out.println(formParams.getId()+":"+formParams.getDescription());
		
		service.addTodo(new Todo(formParams.getId(), formParams.getDescription()));
		
		MultivaluedMap< String, String> multivaluedMap = hh.getRequestHeaders();
		for(String key: multivaluedMap.keySet())
		{
			System.out.println(key+":" +multivaluedMap.get(key));
		}
		response.sendRedirect("./xmltest/getAll");
	}
	
	@POST
	@Path("postTodo")
	@Consumes(MediaType.APPLICATION_XML)
	public String addTodo(Todo todo, @Context HttpServletResponse response) throws IOException
	{
		System.out.println("addTododo");
		service.addTodo(todo);
		 return todo.toString();
	}
	
	
}
