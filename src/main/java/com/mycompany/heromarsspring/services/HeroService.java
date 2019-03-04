package com.mycompany.heromarsspring.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mycompany.heromarsspring.daos.HeroRepository;
import com.mycompany.heromarsspring.daos.UserRepository;
import com.mycompany.heromarsspring.entities.Hero;
import com.mycompany.heromarsspring.entities.User;
import com.mycompany.heromarsspring.model.SpeciesEnum;
import com.mycompany.heromarsspring.viewmodel.HeroFormData;
import com.mycompany.heromarsspring.viewmodel.RegistrationFormData;

@Service
public class HeroService {

	@Autowired
	private HeroRepository heroRepository;
	
	@Autowired UserRepository userRepository;
	
	public Hero findHeroById(Integer heroId) {
		
		return heroRepository.findByHeroId(heroId);
	}
	
	public Hero saveHero(HeroFormData heroFormData) {
		Hero hero = new Hero();
		hero.setUser(userRepository.findByUserName(heroFormData.getUserName()));
		hero.setHeroName(heroFormData.getHeroName());
		hero.setCreationDate(LocalDate.now());
		hero.setSpecies(heroFormData.getSpecies());
		hero.setHairColor(heroFormData.getHairColor());
		
		hero.setFood(hero.getSpecies().getFood());
		hero.setHeight(hero.getSpecies().getHeight());
		hero.setHeroLevel(hero.getSpecies().getLevel());
		hero.setHp(hero.getSpecies().getHp());
		hero.setMoney(hero.getSpecies().getMoney());
		hero.setStrength(hero.getSpecies().getStrenght());
				
		return heroRepository.saveAndFlush(hero);
	}

	public boolean checkUniqueHeroName(String heroName) {
		Hero hero = heroRepository.findByHeroName(heroName);
		
		if (hero == null) {
			return true;
		} 
		
		return false;
	}
}
