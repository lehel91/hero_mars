package com.mycompany.heromarsspring.services;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mycompany.heromarsspring.daos.HeroRepository;
import com.mycompany.heromarsspring.daos.UserRepository;
import com.mycompany.heromarsspring.entities.Hero;
import com.mycompany.heromarsspring.viewmodel.HeroFormData;


@Service
public class HeroService {

	@Autowired
	private HeroRepository heroRepository;
	
	@Autowired 
	private UserRepository userRepository;
	
	public Hero findHeroById(Integer heroId) {
		
		return heroRepository.findByHeroId(heroId);
	}
	
	public Hero saveHero(HeroFormData heroFormData, String userName) {
		Hero hero = new Hero();
		hero.setUser(userRepository.findByUserName(userName));
		hero.setHeroName(heroFormData.getHeroName());
		hero.setCreationDate(LocalDate.now());
		hero.setLastActivity(LocalDateTime.now());
		hero.setSpecies(heroFormData.getSpecies());
		hero.setSex(heroFormData.getSex());
		hero.setHairColor(heroFormData.getHairColor());
		
		
		hero.setFood(hero.getSpecies().getFood());
		hero.setHeight(hero.getSpecies().getHeight());
		hero.setWeight(hero.getSpecies().getWeight());
		hero.setWater(hero.getSpecies().getWater());
		hero.setWisdom(hero.getSpecies().getWisdom());
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
