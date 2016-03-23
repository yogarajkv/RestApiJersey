package com.rest.controller;

import java.io.IOException;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class CheckRequestFilter implements ClientRequestFilter {

	public void filter(ClientRequestContext requestContext) throws IOException {
		if (requestContext.getHeaders().get("Client-Name")==null)
		{
			requestContext.abortWith(Response.status(Status.BAD_REQUEST).entity("Client name required").build());
		}
		
	}

}
