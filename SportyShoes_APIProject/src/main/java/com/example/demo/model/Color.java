package com.example.demo.model;

//@author Kavitha S

public enum Color {

	Blue("Blue"), Black("Black"), White("White"), Brown("Brown");

	private String name;

	private Color(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}