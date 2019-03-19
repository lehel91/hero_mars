package com.mycompany.heromarsspring.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AjaxResponse {
	
	private String message;
	
	private Integer actionPoints;
	
}