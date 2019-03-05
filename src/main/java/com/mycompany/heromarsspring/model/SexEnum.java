package com.mycompany.heromarsspring.model;

public enum SexEnum {
    MALE("Férfi"),
    FEMALE("Nő");
	
	private String description;
	
	SexEnum(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
}
