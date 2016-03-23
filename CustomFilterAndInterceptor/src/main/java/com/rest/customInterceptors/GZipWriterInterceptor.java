package com.rest.customInterceptors;

import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;

public class GZipWriterInterceptor implements WriterInterceptor{

	public void aroundWriteTo(WriterInterceptorContext context) throws IOException, WebApplicationException {		
		System.out.println("WriterInterceptor");
		context.setOutputStream(new GZIPOutputStream(context.getOutputStream()));
		context.getHeaders().add("Content-Encoding","gzip");
		context.proceed();
	}

}
