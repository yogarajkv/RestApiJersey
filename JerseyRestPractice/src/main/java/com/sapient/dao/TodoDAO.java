package com.sapient.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sapient.pojo.Todo;

public enum TodoDAO {

	instance;
	
	private Map<String, Todo> contentMap = new HashMap<String, Todo>();
	
	private TodoDAO()
	{
		List<String> list = new ArrayList<String>();
		list.add("Monday");
		list.add("Tuesday");
		list.add("Wednesday");
		contentMap.put("1", new Todo("1","Learn Rest"));
		contentMap.get("1").setDate(list);
		contentMap.put("2", new Todo("2","Learn Spring Boot"));
	}
		
	public Map<String, Todo> getModel()
	{
		return contentMap;
	}
	
	
}
