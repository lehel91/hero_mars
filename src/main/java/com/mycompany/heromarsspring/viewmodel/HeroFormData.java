package com.mycompany.heromarsspring.viewmodel;

import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;

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
	private String heroName;
	
	@NotEmpty
	@Enumerated
	private SpeciesEnum species;
	
	@NotEmpty
	@Enumerated
	private SexEnum sex;
	
	@NotNull
	@NumberFormat
	private Integer height;

	@NotNull
	@NumberFormat
    private Integer weight;
	
	@NotEmpty
	@Enumerated
	private SexEnum hairColor;
}
