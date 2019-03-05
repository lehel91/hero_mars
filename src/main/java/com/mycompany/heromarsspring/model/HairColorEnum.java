
package com.mycompany.heromarsspring.model;

public enum HairColorEnum {
	BROWN("Barna"),
	BLACK("Fekete"),
	PURPLE("Lila"),
	GREEN("Zöld"),
	BLONDE("Szőke"),
	GINGER("Vörös");
	
	private String description;
	
	private HairColorEnum(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
}
