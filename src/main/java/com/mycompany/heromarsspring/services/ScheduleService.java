package com.mycompany.heromarsspring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.mycompany.heromarsspring.daos.HeroRepository;
import com.mycompany.heromarsspring.model.SpeciesEnum;

@Service
public class ScheduleService {

	private static final long fixedRate = 100000L;
	private static final long initialDelay = 100000L;

	@Autowired
	HeroRepository heroRepository;

	@Scheduled(fixedRate = fixedRate, initialDelay = initialDelay)
	public void drinkWater() {

		System.out.println("Fixed rate task: drinkWater - " + System.currentTimeMillis() / 1000);

		List<Object[]> heroNamesAndWater = heroRepository.getAllHeroNamesAndWater();

		for (Object[] hero : heroNamesAndWater) {

			String heroName = (String) hero[0];
			Integer water = (Integer) hero[1];

			if (water > 0) {
				heroRepository.setWater(heroName, water - 1);
			}

		}

		System.out.println("----- End ----- drinkWater - " + System.currentTimeMillis() / 1000);

	}

	@Scheduled(fixedRate = fixedRate * 2, initialDelay = initialDelay * 2)
	public void eatFood() {

		System.out.println("Fixed rate task: eatFood - " + System.currentTimeMillis() / 1000);

		List<Object[]> heroNamesAndFood = heroRepository.getAllHeroNamesAndFood();

		for (Object[] hero : heroNamesAndFood) {

			String heroName = (String) hero[0];
			Integer food = (Integer) hero[1];

			if (food > 0) {
				heroRepository.setFood(heroName, food - 1);
			}

		}

		System.out.println("----- End ----- eatFood - " + System.currentTimeMillis() / 1000);

	}

	@Scheduled(fixedRate = fixedRate / 2, initialDelay = initialDelay / 2)
	public void recoverActionPoint() {

		System.out.println("Fixed rate task: recoverActionPoint - " + System.currentTimeMillis() / 1000);

		List<Object[]> heroNamesAPSpecies = heroRepository.getAllHeroNamesActionPointSpecies();

		for (Object[] hero : heroNamesAPSpecies) {
			
			String heroName = (String) hero[0];
			Integer actionPoint = (Integer) hero[1];
			String speciesName = hero[2].toString();
			SpeciesEnum species = SpeciesEnum.valueOf(speciesName);
			Integer maxActionPoint = species.getActionPoint();

			if (actionPoint < maxActionPoint) {
				heroRepository.setHeroActionPoints(heroName, actionPoint + 1);
			}

		}

		System.out.println("----- End ----- recoverActionPoint - " + System.currentTimeMillis() / 1000);

	}

}
