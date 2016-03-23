package com.rest.model;


public class Person {
	
	private final String name;
	private final int id;
	private Address address;
	
	public Person(){
		name ="";
		id =0;
		System.out.println("person default called");
	}
	public Person(String name,int id)
	{
		this.name = name;
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}
	

}
