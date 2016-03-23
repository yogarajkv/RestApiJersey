package com.sapient.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class RestController {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello() {
		
		return "Hello";
	}
	
	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayPlainXMLHello() {
		
		return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey" + "</hello>";
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayPlainHTMLHello() {
		
		return "<html><body>Hello Body</body></html>";
	}
}
