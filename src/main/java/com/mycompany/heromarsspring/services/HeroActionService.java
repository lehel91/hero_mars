package com.mycompany.heromarsspring.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.heromarsspring.daos.HeroRepository;
import com.mycompany.heromarsspring.entities.Hero;

@Service
public class HeroActionService {

	@Autowired
	private HeroRepository heroRepository;

	public Hero findHeroByHeroName(String heroName) {
		return heroRepository.findByHeroName(heroName);
	}

	public void decreaseActionPoints(String heroName, int decreaseAmount) {
		
		int actionPoints = heroRepository.getHeroActionPoints(heroName);
		
		if (actionPoints >= decreaseAmount) {
			heroRepository.setHeroActionPoints(heroName, actionPoints - decreaseAmount);
			heroRepository.setLastActivity(heroName, LocalDateTime.now());
		}
	}

}
