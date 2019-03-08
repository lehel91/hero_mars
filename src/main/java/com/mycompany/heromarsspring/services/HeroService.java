package com.mycompany.heromarsspring.services;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mycompany.heromarsspring.daos.HeroRepository;
import com.mycompany.heromarsspring.daos.UserRepository;
import com.mycompany.heromarsspring.entities.Hero;
import com.mycompany.heromarsspring.entities.Item;
import com.mycompany.heromarsspring.model.ItemEnum;
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
		hero.setActionPoint(hero.getSpecies().getActionPoint());

		Item item1 = new Item();
		item1.setName(ItemEnum.LIGHTSWORD);
		item1.setLevel(3);
		item1.setIsInUse(false);
		item1.setDurability(item1.getName().getDurability());
		item1.setItemHpMod(item1.getName().getHealthMod() * item1.getLevel());
		item1.setItemStrengthMod(item1.getName().getStrengthMod() * item1.getLevel());
		item1.setItemWisdomMod(item1.getName().getWisdomMod() * item1.getLevel());
		item1.setType(item1.getName().getType());
		item1.setMarketPresence(null);
		item1.setHero(hero);
		
		Item item2 = new Item();
		item2.setName(ItemEnum.MACE);
		item2.setLevel(1);
		item2.setIsInUse(true);
		item2.setDurability(item2.getName().getDurability());
		item2.setItemHpMod(item2.getName().getHealthMod() * item2.getLevel());
		item2.setItemStrengthMod(item2.getName().getStrengthMod() * item2.getLevel());
		item2.setItemWisdomMod(item2.getName().getWisdomMod() * item2.getLevel());
		item2.setType(item2.getName().getType());
		item2.setMarketPresence(null);
		item2.setHero(hero);
		
		Item item3 = new Item();
		item3.setName(ItemEnum.SHIELD);
		item3.setLevel(2);
		item3.setIsInUse(false);
		item3.setDurability(item3.getName().getDurability());
		item3.setItemHpMod(item3.getName().getHealthMod() * item3.getLevel());
		item3.setItemStrengthMod(item3.getName().getStrengthMod() * item3.getLevel());
		item3.setItemWisdomMod(item3.getName().getWisdomMod() * item3.getLevel());
		item3.setType(item3.getName().getType());
		item3.setMarketPresence(null);
		item3.setHero(hero);
				
		hero.getItems().add(item1);
		hero.getItems().add(item2);
		hero.getItems().add(item3);
				
		return heroRepository.saveAndFlush(hero);
	}

	public boolean checkUniqueHeroName(String heroName) {
		Hero hero = heroRepository.findByHeroName(heroName);

		if (hero == null) {
			return true;
		}

		return false;
	}

	public Hero findHeroByName(String heroName) {

		return heroRepository.findByHeroName(heroName);

	}
}
