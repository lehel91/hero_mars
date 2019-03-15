package com.mycompany.heromarsspring.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.heromarsspring.daos.HeroRepository;
import com.mycompany.heromarsspring.daos.SkillRepository;
import com.mycompany.heromarsspring.entities.Hero;
import com.mycompany.heromarsspring.entities.Item;
import com.mycompany.heromarsspring.entities.Skill;
import com.mycompany.heromarsspring.model.ItemEnum;
import com.mycompany.heromarsspring.model.SkillEnum;

@Service
public class HeroActionService {

	@Autowired
	private HeroRepository heroRepository;
	
	@Autowired
	private SkillRepository skillRepository;

	public static final int treasureHuntSuccessRateLow = 1;
	public static final int treasureHuntSuccessRateMedium = 2;
	public static final int treasureHuntSuccessRateHigh = 3;

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
		return 2;
	}
	
	public int getBlacksmithVisitingCost() {
		return 2;
	}

	public int getMissionCost() {
		return 2;
	}

	public int getLearningCost() {
		return 2;
	}

	public int getHuntingCost() {
		return 2;
	}
	
	public int getTreasureHuntingCost() {
		return 2;
	}
	
	public String gatherWater(String heroName) {
		int waterGathered;
		
		decreaseActionPoints(heroName, getWaterCost());

		List<String> heroSkills = getStringifiedHeroSkillList(heroName);

		if (heroSkills.contains(SkillEnum.WELLDRILLING_MAGE.getDescription())) {
			waterGathered = (int) (SkillEnum.WELLDRILLING_MAGE.getSuccessRate() * getWisdomModificationRate(heroName)
					* 10);
		} else if (heroSkills.contains(SkillEnum.WELLDRILLING_MASTER.getDescription())) {
			waterGathered = (int) (SkillEnum.WELLDRILLING_MASTER.getSuccessRate() * getWisdomModificationRate(heroName)
					* 10);
		} else if (heroSkills.contains(SkillEnum.WELLDRILLING_PADAVAN.getDescription())) {
			waterGathered = (int) (SkillEnum.WELLDRILLING_PADAVAN.getSuccessRate() * getWisdomModificationRate(heroName)
					* 10);
		} else {
			waterGathered = (int) (0.1 * getWisdomModificationRate(heroName) * 10);
		}

		int actualWaterAmount = heroRepository.findByHeroName(heroName).getWater();
		heroRepository.setWater(heroName, actualWaterAmount + waterGathered);
		return waterGathered + " vizet sikerült szerezned.";

	}

	public String gatherFood(String heroName) {
		int foodGathered;

		decreaseActionPoints(heroName, getHuntingCost());
		
		List<String> heroSkills = getStringifiedHeroSkillList(heroName);

		if (heroSkills.contains(SkillEnum.HUNTER_MAGE.getDescription())) {
			foodGathered = (int) (SkillEnum.HUNTER_MAGE.getSuccessRate() * getWisdomModificationRate(heroName) * 10);
		} else if (heroSkills.contains(SkillEnum.HUNTER_MASTER.getDescription())) {
			foodGathered = (int) (SkillEnum.HUNTER_MASTER.getSuccessRate() * getWisdomModificationRate(heroName) * 10);
		} else if (heroSkills.contains(SkillEnum.HUNTER_PADAVAN.getDescription())) {
			foodGathered = (int) (SkillEnum.HUNTER_PADAVAN.getSuccessRate() * getWisdomModificationRate(heroName) * 10);
		} else {
			foodGathered = (int) (0.1 * getWisdomModificationRate(heroName) * 10);
		}

		int actualFoodAmount = heroRepository.findByHeroName(heroName).getFood();
		heroRepository.setFood(heroName, actualFoodAmount + foodGathered);
		return foodGathered + " kaját sikerült szerezned.";
	}

	public String getTreasure(String heroName) {
		Item item;
		Hero hero = heroRepository.findByHeroName(heroName);
		double treasureHuntSuccessRate = getTreasureHuntingSuccesRate(heroName);
		
		if (treasureHuntSuccessRate > treasureHuntSuccessRateHigh) {
			item = getItemAsTreasureHuntReward(ItemEnum.MAGIC_RING, 3);
		} else if (treasureHuntSuccessRate > treasureHuntSuccessRateMedium) {
			item = getItemAsTreasureHuntReward(ItemEnum.LIGHTSWORD, 3);
		} else {
			item = getItemAsTreasureHuntReward(ItemEnum.HELMET, 3);
		}

		item.setHero(hero);
		hero.getItems().add(item);

		heroRepository.saveAndFlush(hero);
		
		decreaseActionPoints(heroName, getTreasureHuntingCost());

		return item.getType() + "-t sikerült szerezned.";
	}
	
	public String developWelldrillingSkill(String heroName) {
		List<String> heroSkills = getStringifiedHeroSkillList(heroName);
		Hero hero = heroRepository.findByHeroName(heroName);

		if(heroSkills.contains(SkillEnum.WELLDRILLING_MAGE.getDescription())) {
			return "Már maximumra fejlesztetted ezt a képességet.";
		}
		
		Skill skill;
		SkillEnum skillToGain; 
		
		if (heroSkills.contains(SkillEnum.WELLDRILLING_MASTER.getDescription())) {
			skillToGain= SkillEnum.WELLDRILLING_MAGE;
		} else if (heroSkills.contains(SkillEnum.WELLDRILLING_PADAVAN.getDescription())) {
			skillToGain= SkillEnum.WELLDRILLING_MASTER;
		} else {
			skillToGain= SkillEnum.WELLDRILLING_PADAVAN;
		}
		
		Skill existingSkillInDb = skillRepository.findBySkillType(skillToGain);
		skill = getSkillAsLearningReward(skillToGain);
		
		if (existingSkillInDb != null) {
			skill = existingSkillInDb;
		}

		skill.getHeroes().add(hero);
		hero.getSkills().add(skill);
		
		skillRepository.saveAndFlush(skill);
		heroRepository.saveAndFlush(hero);
		
		decreaseActionPoints(heroName, getLearningCost());

		return skill.getSkillType() + "képességet sikerült szerezned.";
	}
	
	public String developHuntingSkill(String heroName) {
		List<String> heroSkills = getStringifiedHeroSkillList(heroName);
		Hero hero = heroRepository.findByHeroName(heroName);

		if(heroSkills.contains(SkillEnum.HUNTER_MAGE.getDescription())) {
			return "Már maximumra fejlesztetted ezt a képességet.";
		}
		
		Skill skill;
		SkillEnum skillToGain; 
		 
		if (heroSkills.contains(SkillEnum.HUNTER_MASTER.getDescription())) {
			skillToGain= SkillEnum.HUNTER_MAGE;
		} else if (heroSkills.contains(SkillEnum.HUNTER_PADAVAN.getDescription())) {
			skillToGain= SkillEnum.HUNTER_MASTER;
		} else {
			skillToGain= SkillEnum.HUNTER_PADAVAN;
		}
		
		Skill existingSkillInDb = skillRepository.findBySkillType(skillToGain);
		skill = getSkillAsLearningReward(skillToGain);
		
		if (existingSkillInDb != null) {
			skill = existingSkillInDb;
		}
		
		skill.getHeroes().add(hero);
		hero.getSkills().add(skill);

		skillRepository.saveAndFlush(skill);
		heroRepository.saveAndFlush(hero);
		
		decreaseActionPoints(heroName, getLearningCost());

		return skill.getSkillType() + "képességet sikerült szerezned.";
	}
	
	public String developAstronomerSkill(String heroName) {
		List<String> heroSkills = getStringifiedHeroSkillList(heroName);
		Hero hero = heroRepository.findByHeroName(heroName);

		if(heroSkills.contains(SkillEnum.ASTRONOMER_MAGE.getDescription())) {
			return "Már maximumra fejlesztetted ezt a képességet.";
		}
		
		Skill skill;
		SkillEnum skillToGain; 
		 
		if (heroSkills.contains(SkillEnum.ASTRONOMER_MASTER.getDescription())) {
			skillToGain= SkillEnum.ASTRONOMER_MAGE;
		} else if (heroSkills.contains(SkillEnum.ASTRONOMER_PADAVAN.getDescription())) {
			skillToGain= SkillEnum.ASTRONOMER_MASTER;
		} else {
			skillToGain= SkillEnum.ASTRONOMER_PADAVAN;
		}
		
		Skill existingSkillInDb = skillRepository.findBySkillType(skillToGain);
		skill = getSkillAsLearningReward(skillToGain);
		
		if (existingSkillInDb != null) {
			skill = existingSkillInDb;
		}
		
		skill.getHeroes().add(hero);
		hero.getSkills().add(skill);

		skillRepository.saveAndFlush(skill);
		heroRepository.saveAndFlush(hero);
		
		decreaseActionPoints(heroName, getLearningCost());

		return skill.getSkillType() + "képességet sikerült szerezned.";
	}
	
	public String developTreasureHunterSkill(String heroName) {
		List<String> heroSkills = getStringifiedHeroSkillList(heroName);
		Hero hero = heroRepository.findByHeroName(heroName);

		if(heroSkills.contains(SkillEnum.TREASURE_HUNTER_MAGE.getDescription())) {
			return "Már maximumra fejlesztetted ezt a képességet.";
		}
		
		Skill skill;
		SkillEnum skillToGain; 
		 
		if (heroSkills.contains(SkillEnum.TREASURE_HUNTER_MASTER.getDescription())) {
			skillToGain= SkillEnum.TREASURE_HUNTER_MAGE;
		} else if (heroSkills.contains(SkillEnum.TREASURE_HUNTER_PADAVAN.getDescription())) {
			skillToGain= SkillEnum.TREASURE_HUNTER_MASTER;
		} else {
			skillToGain= SkillEnum.TREASURE_HUNTER_PADAVAN;
		}
		
		Skill existingSkillInDb = skillRepository.findBySkillType(skillToGain);
		skill = getSkillAsLearningReward(skillToGain);
		
		if (existingSkillInDb != null) {
			skill = existingSkillInDb;
		}
		
		skill.getHeroes().add(hero);
		hero.getSkills().add(skill);

		skillRepository.saveAndFlush(skill);
		heroRepository.saveAndFlush(hero);
		
		decreaseActionPoints(heroName, getLearningCost());

		return skill.getSkillType() + "képességet sikerült szerezned.";
	}

	public double getTreasureHuntingSuccesRate(String heroName) {

		List<String> heroSkills = getStringifiedHeroSkillList(heroName);

		if (heroSkills.contains(SkillEnum.TREASURE_HUNTER_MAGE.getDescription())) {
			return SkillEnum.TREASURE_HUNTER_MAGE.getSuccessRate() * getWisdomModificationRate(heroName);
		} else if (heroSkills.contains(SkillEnum.TREASURE_HUNTER_MASTER.getDescription())) {
			return SkillEnum.TREASURE_HUNTER_MASTER.getSuccessRate() * getWisdomModificationRate(heroName);
		} else if (heroSkills.contains(SkillEnum.TREASURE_HUNTER_PADAVAN.getDescription())) {
			return SkillEnum.TREASURE_HUNTER_PADAVAN.getSuccessRate() * getWisdomModificationRate(heroName);
		} else {
			return 0.1 * getWisdomModificationRate(heroName);
		}
	}

	public List<String> getStringifiedHeroSkillList(String heroName) {
		
		 List<String> heroSkills = findHeroByHeroName(heroName).getSkills().stream()
				.map(s -> s.getSkillType().getDescription())
				.collect(Collectors.toList());
		return heroSkills;
	}

	public Item getItemAsTreasureHuntReward(ItemEnum type, int level) {
		Item item = new Item();
		item.setName(type);
		item.setLevel(level);
		item.setIsInUse(false);
		item.setDurability(item.getName().getDurability());
		item.setItemHpMod(item.getName().getHealthMod() * item.getLevel());
		item.setItemStrengthMod(item.getName().getStrengthMod() * item.getLevel());
		item.setItemWisdomMod(item.getName().getWisdomMod() * item.getLevel());
		item.setType(item.getName().getType());
		item.setMarketPresence(null);
		return item;
	}
	
	public Skill getSkillAsLearningReward(SkillEnum skillType) {
		Skill skill = new Skill();
		skill.setSkillType(skillType);
		return skill;
		
	}

}
