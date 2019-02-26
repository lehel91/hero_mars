package com.mycompany.heromarsspring.viewmodel;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginFormData {

	@NotEmpty
	private String userName;
	
	@NotEmpty
	private String password;
	
}
