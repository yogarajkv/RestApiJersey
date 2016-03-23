package com.sapient.pojo;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Todo {

	private String name;
	private String description;
	
	private List<String> date;
	
	public Todo(){}
	public Todo (String name, String description)
	{
		this.name = name;
		this.description = description;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<String> getDate() {
		return date;
	}
	public void setDate(List<String> date) {
		this.date = date;
	}
	
	@Override
	public String toString()
	{
		return getName()+":"+ getDescription()+":" +getDate();
	}
	
	
}
