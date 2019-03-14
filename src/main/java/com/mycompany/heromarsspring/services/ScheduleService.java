package com.mycompany.heromarsspring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.mycompany.heromarsspring.daos.HeroRepository;

@Service
public class ScheduleService {

	@Autowired
	HeroRepository heroRepository;

	@Scheduled(fixedRate = 100000, initialDelay = 100000)
	public void drinkWater() {

		System.out.println("Fixed rate task: drinkWater - " + System.currentTimeMillis() / 1000);

		List<Object[]> heroNamesAndWater = heroRepository.getAllHeroNamesAndWater();

		for (Object[] hero : heroNamesAndWater) {

			String heroName = (String) hero[0];
			Integer water = (Integer) hero[1];

			if (water >= 1) {
				heroRepository.setWater(heroName, water - 1);
			}

		}
		
		System.out.println("----- End ----- drinkWater - " + System.currentTimeMillis() / 1000);

	}

}
