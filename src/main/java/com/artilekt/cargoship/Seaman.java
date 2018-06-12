package com.artilekt.cargoship;

public class Seaman extends CrewMember {
	private String description;

	public Seaman(String id, String name, int age, String description) {
		super(id, name, age);
		this.description = description;
	}
	
	public Seaman(String id, String name, int age) {
		this(id, name, age, "not defined");
	}
	
	
}
