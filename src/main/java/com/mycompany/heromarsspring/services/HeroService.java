package com.mycompany.heromarsspring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mycompany.heromarsspring.daos.HeroRepository;
import com.mycompany.heromarsspring.entities.Hero;

@Service
public class HeroService {

	@Autowired
	private HeroRepository heroRepository;
	
	public Hero findHeroById(Integer heroId) {
		
		return heroRepository.findByHeroId(heroId);
	}
	
}
