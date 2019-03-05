package com.mycompany.heromarsspring.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.heromarsspring.services.HeroService;
import com.mycompany.heromarsspring.services.SessionService;
import com.mycompany.heromarsspring.services.UserService;
import com.mycompany.heromarsspring.viewmodel.HeroFormData;

@Controller
public class HeroController {

	@Autowired
	private SessionService sessionService;

	@Autowired
	private HeroService heroService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "create_hero", method = RequestMethod.GET)
	public String createHero(Model model) {

		model.addAttribute("heroFormData", new HeroFormData());

		return "hero_creation.html";
	}

	@RequestMapping(value = "create_hero", method = RequestMethod.POST)
	public String submitHeroCreation(@ModelAttribute("heroFormData") @Valid HeroFormData heroFormData,
			/* @ModelAttribute("userName") @Valid String userName, */
			BindingResult bindingResult, Model model) {
		heroFormData.setUser(userService.findByUserName(sessionService.getCurrentUserName()));
		
		System.out.println(heroFormData);

		boolean hasUniqueHeroName = heroService.checkUniqueHeroName(heroFormData.getHeroName());

		if (!bindingResult.hasErrors() && hasUniqueHeroName) {
			heroService.saveHero(heroFormData);

			return "profile.html";
		}

		return "hero_creation.html";
	}
}
