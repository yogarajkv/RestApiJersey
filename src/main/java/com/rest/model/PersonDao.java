package com.rest.model;

import java.util.HashMap;
import java.util.Map;

public enum PersonDao {
	
	instance;
	
private Map<String, Person> contentMap = new HashMap<String, Person>();
	
	private PersonDao()
	{
		contentMap.put("Yogaraj", new Person("Yogaraj",12));
		contentMap.get("Yogaraj").setAddress(new Address("Siruvachur"));
		contentMap.put("Maniraj", new Person("Maniraj",13));
	}
		
	public Map<String, Person> getModel()
	{
		return contentMap;
	}

}
