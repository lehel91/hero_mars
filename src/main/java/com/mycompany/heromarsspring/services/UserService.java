package com.mycompany.heromarsspring.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mycompany.heromarsspring.daos.UserRepository;
import com.mycompany.heromarsspring.entities.Hero;
import com.mycompany.heromarsspring.entities.User;
import com.mycompany.heromarsspring.model.HairColorEnum;
import com.mycompany.heromarsspring.model.SexEnum;
import com.mycompany.heromarsspring.model.SpeciesEnum;
import com.mycompany.heromarsspring.viewmodel.LoginFormData;
import com.mycompany.heromarsspring.viewmodel.RegistrationFormData;

public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User saveUser(RegistrationFormData registrationFormData) {
		User user = new User();
		user.setUserName(registrationFormData.getUserName());
		user.setPassword(registrationFormData.getPassword());
		user.setEMail(registrationFormData.getEMail());
		user.setBirthYear(registrationFormData.getBirthYear());

//		List<Hero> heroes = new ArrayList<>();
//		
//		for (int i = 0; i < 2; i++) {
//
//			Hero hero = new Hero();
//			hero.setCreationDate(LocalDate.now());
//			hero.setFood(100);
//			hero.setHairColor(HairColorEnum.BLACK);
//			hero.setHeight(100);
//			hero.setHeroLevel(1);
//			hero.setHeroName("Pista_" + i + "_" + LocalDateTime.now().toString());
//			hero.setHp(100);
//			hero.setLastActivity(LocalDateTime.now());
//			hero.setMoney(100);
//			hero.setSex(SexEnum.MALE);
//			hero.setSpecies(SpeciesEnum.PLEIADIAN);
//			hero.setStrength(40);
//			hero.setWater(30);
//			hero.setWeight(90);
//			hero.setWisdom(20);
//			hero.setUser(user);
//			
//			heroes.add(hero);
//
//		}
//		
//		user.setHeroes(heroes);

		return userRepository.saveAndFlush(user);
	}

	public boolean checkUniqueUserName(String userName) {
		User user = userRepository.findByUserName(userName);

		if (user == null) {
			return true;
		}

		return false;
	}

	public boolean isValidLogin(LoginFormData loginFormData) {

		User user = userRepository.findByUserName(loginFormData.getUserName());

		if (user == null) {
			return false;

		} else if (loginFormData.getPassword().equals(user.getPassword())) {
			return true;

		}
		return false;
	}

	public List<String> getHeroNames(String username) {

		List<String> heroNames = userRepository.getHeroNames(username);
		
		if (heroNames.isEmpty()) {
			
			return null;
			
		}
		
		return heroNames;

	}
	
	public void setUserEmail(String eMail, String userName) {
		userRepository.setUserEmail(eMail, userName);
	}
	
	public void setUserPassword(String password, String userName) {
		System.out.println(password + " " + userName);
		userRepository.setUserPassword(password, userName);
	}
}
