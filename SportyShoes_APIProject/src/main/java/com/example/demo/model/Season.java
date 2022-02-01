package com.example.demo.model;

//@author Kavitha S

public enum Season {
	
	 Winter("Winter"), Summer("Summer"), Rainy("Rainy") ;

   private String name;


	private Season(String name) {
	this.name = name;
}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

    
}