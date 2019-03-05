package com.mycompany.heromarsspring.viewmodel;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProfileData {

	@NotEmpty
	private String newPassword;
	
	@NotEmpty
	private String confirmNewPassword;
	
	@NotEmpty
	@Email
	private String eMail;
	
	private List<String> heroNames;
	
	private String selectedHeroName;
	
}
