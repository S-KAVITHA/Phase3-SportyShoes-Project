package com.example.demo.model;


//@author Kavitha S

public enum ShoeType {
	
	 Male("Male"), Female("Female"), Both("Both") ;

   private String name;


	private ShoeType(String name) {
	this.name = name;
}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

    
}