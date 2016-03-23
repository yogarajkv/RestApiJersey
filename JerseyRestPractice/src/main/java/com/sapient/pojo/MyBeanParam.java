package com.sapient.pojo;

import javax.ws.rs.FormParam;

public class MyBeanParam {

	@FormParam(value = "id")
	private String id;
	
	@FormParam(value="description")
	private String description;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
