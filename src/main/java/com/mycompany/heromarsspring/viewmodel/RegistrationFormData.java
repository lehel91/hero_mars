package com.mycompany.heromarsspring.viewmodel;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RegistrationFormData {

	@NotEmpty
	private String userName;
	
	@NotEmpty
	private String password;
	
	@NotEmpty
	private String confirmPassword;
	
	@NotEmpty
	@Email
	private String eMail;
	
	@NotNull
	@NumberFormat
	private Integer birthYear;
	
	
	
}
