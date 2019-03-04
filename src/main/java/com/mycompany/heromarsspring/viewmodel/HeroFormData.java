package com.mycompany.heromarsspring.viewmodel;

import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;

import org.springframework.lang.NonNull;

import com.mycompany.heromarsspring.entities.User;
import com.mycompany.heromarsspring.model.HairColorEnum;
import com.mycompany.heromarsspring.model.SexEnum;
import com.mycompany.heromarsspring.model.SpeciesEnum;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HeroFormData {
	
	@NotEmpty
	private String userName;
	
	@NotEmpty
	private String heroName;
	
	@NonNull
	@Enumerated
	private SpeciesEnum species;
	
	@NonNull
	@Enumerated
	private SexEnum sex;
	
	@NonNull
	@Enumerated
	private HairColorEnum hairColor;
}
