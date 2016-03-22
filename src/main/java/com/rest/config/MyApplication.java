package com.rest.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class MyApplication extends Application {
	
	
	public Set<Class<?>> getClasses()
	{
		Set<Class<?>> resourceSet = new HashSet<Class<?>>();
		resourceSet.add(com.rest.customProviders.JSONListMessageBodyProvider.class);
		resourceSet.add(com.rest.customProviders.JSONMessageBodyProvider.class);
		resourceSet.add(com.rest.controller.PersonController.class);		
		return resourceSet;
	}

}
