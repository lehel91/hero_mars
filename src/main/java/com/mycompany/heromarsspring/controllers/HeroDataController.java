package com.mycompany.heromarsspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
		
		if (sessionService == null) {
			
			return "redirect:/index";
			
		} else if (sessionService.getCurrentUserName()==null) {
			
			return "redirect:/login";
			
		} else if (sessionService.getCurrentHeroName()==null) {
			
			return "redirect:/profile";
		}
		
		model.addAttribute("sessionData", sessionService);
		model.addAttribute("hero", heroService.findHeroByName(sessionService.getCurrentHeroName()));
		
		return "hero_data.html";
	}
	
	@RequestMapping(value = "itemChange", method = RequestMethod.GET)
	public String changeItem(@RequestParam Integer itemId, Model model) {
		
		if (sessionService == null) {
			
			return "redirect:/index";
			
		} else if (sessionService.getCurrentUserName()==null) {
			
			return "redirect:/login";
			
		} else if (sessionService.getCurrentHeroName()==null) {
			
			return "redirect:/profile";
		}
		
		String message = heroService.changeItems(itemId, sessionService.getCurrentHeroName());
		
		model.addAttribute("sessionData", sessionService);
		model.addAttribute("itemChangeMessage", message);
		model.addAttribute("hero", heroService.findHeroByName(sessionService.getCurrentHeroName()));
		
		return "hero_data.html";
	}
	
}
