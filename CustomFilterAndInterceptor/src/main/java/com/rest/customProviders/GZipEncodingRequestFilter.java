package com.rest.customProviders;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;

@PreMatching
public class GZipEncodingRequestFilter implements ContainerRequestFilter {

	public void filter(ContainerRequestContext requestContext) throws IOException {
		System.out.println("RequestFilter");
		requestContext.getHeaders().add("Content-Encoding", "gzip");
		requestContext.getHeaders().remove("accept-encoding");
		System.out.println(requestContext.getHeaders());
	}
	

}
