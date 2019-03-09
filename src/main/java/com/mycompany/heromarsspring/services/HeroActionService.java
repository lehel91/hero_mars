package com.mycompany.heromarsspring.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.heromarsspring.daos.HeroRepository;
import com.mycompany.heromarsspring.entities.Hero;
import com.mycompany.heromarsspring.model.SkillEnum;

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
	
	public int getWisdomModificationRate(String heroName) {
		int currentWisdom = heroRepository.findByHeroName(heroName).getWisdom();
		return (int) (Math.random() * ((currentWisdom + 3) - (currentWisdom - 3) + 1) + (currentWisdom - 3));
	}

	public int getWaterCost() {
		return 6;
	}

	public int getWaterAmount(String heroName) {
		int waterGathered;
		
		if (findHeroByHeroName(heroName).getSkills().contains(SkillEnum.WELLDRILLING_PADAVAN)) {
			waterGathered = (int) (SkillEnum.WELLDRILLING_PADAVAN.getSuccessRate() * getWisdomModificationRate(heroName) * 10);
		} else if (findHeroByHeroName(heroName).getSkills().contains(SkillEnum.WELLDRILLING_MASTER)) {
			waterGathered = (int) (SkillEnum.WELLDRILLING_MASTER.getSuccessRate() * getWisdomModificationRate(heroName) * 10);
		} else if (findHeroByHeroName(heroName).getSkills().contains(SkillEnum.WELLDRILLING_MAGE)) {
			waterGathered = (int) (SkillEnum.WELLDRILLING_MAGE.getSuccessRate() * getWisdomModificationRate(heroName) * 10);
		} else {
			waterGathered = (int) (0.1 * getWisdomModificationRate(heroName) * 10);
		}
		
		int actualWaterAmount = heroRepository.findByHeroName(heroName).getWater();
		heroRepository.setWater(heroName, actualWaterAmount + waterGathered);
		return waterGathered;
		
		
	}

	public int getHuntingCost() {
		return 6;
	}
	
	public int getFood(String heroName) {
		int foodGathered;
		
		if (findHeroByHeroName(heroName).getSkills().contains(SkillEnum.HUNTER_PADAVAN)) {
			foodGathered = (int) (SkillEnum.HUNTER_PADAVAN.getSuccessRate() * getWisdomModificationRate(heroName) * 10);
		} else if (findHeroByHeroName(heroName).getSkills().contains(SkillEnum.WELLDRILLING_MASTER)) {
			foodGathered = (int) (SkillEnum.HUNTER_MASTER.getSuccessRate() * getWisdomModificationRate(heroName) * 10);
		} else if (findHeroByHeroName(heroName).getSkills().contains(SkillEnum.WELLDRILLING_MAGE)) {
			foodGathered = (int) (SkillEnum.HUNTER_MAGE.getSuccessRate() * getWisdomModificationRate(heroName) * 10);
		} else {
			foodGathered = (int) (0.1 * getWisdomModificationRate(heroName) * 10);
		}
		
		int actualFoodAmount = heroRepository.findByHeroName(heroName).getFood();
		heroRepository.setFood(heroName, actualFoodAmount + foodGathered);
		return foodGathered;
	}

	public int getTreasureHuntingCost() {
		return 6;
	}
	
	public int getTreasureHuntingSuccesRate(String heroName) {
		
		if (findHeroByHeroName(heroName).getSkills().contains(SkillEnum.TREASURE_HUNTER_PADAVAN)) {
			return (int) (SkillEnum.TREASURE_HUNTER_PADAVAN.getSuccessRate() * getWisdomModificationRate(heroName) * 10);
		} else if (findHeroByHeroName(heroName).getSkills().contains(SkillEnum.TREASURE_HUNTER_MASTER)) {
			return (int) (SkillEnum.TREASURE_HUNTER_MASTER.getSuccessRate() * getWisdomModificationRate(heroName) * 10);
		} else if (findHeroByHeroName(heroName).getSkills().contains(SkillEnum.TREASURE_HUNTER_MAGE)) {
			return (int) (SkillEnum.TREASURE_HUNTER_MAGE.getSuccessRate() * getWisdomModificationRate(heroName) * 10);
		} else {
			return (int) (0.1 * getWisdomModificationRate(heroName) * 10);
		}
		
		
	}

	public int getBlacksmithVisitingCost() {
		return 6;
	}

	public int getMissionCost() {
		return 6;
	}

	public int getLearningCost() {
		return 6;
	}
	
	

}
