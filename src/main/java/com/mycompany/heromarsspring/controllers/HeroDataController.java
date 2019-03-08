package com.mycompany.heromarsspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.heromarsspring.services.HeroService;
import com.mycompany.heromarsspring.services.SessionService;

@Controller
public class HeroDataController {

	@Autowired
	SessionService sessionService;
	
	@Autowired
	HeroService heroService;
	
	@RequestMapping(value = "hero", method = RequestMethod.GET)
	public String showMainMenu(Model model) {
		
		model.addAttribute("sessionData", sessionService);
		
		model.addAttribute("hero", heroService.findHeroByName(sessionService.getCurrentHeroName()));
		
		return "hero_data.html";
	}
	
}
