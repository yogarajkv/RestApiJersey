package com.rest.customInterceptors;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.ReaderInterceptor;
import javax.ws.rs.ext.ReaderInterceptorContext;

public class GZipReaderInterceptor implements ReaderInterceptor {

	public Object aroundReadFrom(ReaderInterceptorContext context) throws IOException, WebApplicationException {
		byte[] b = new byte[1024];
		context.getInputStream().read(b);
		System.out.println("Reader Interceptor"+ new String(b));
		final InputStream iStream = context.getInputStream();
	
		context.setInputStream(new GZIPInputStream(iStream));
		return context.proceed();
	}

}
