package com.mycompany.heromarsspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.heromarsspring.services.HeroService;
import com.mycompany.heromarsspring.services.SessionService;
import com.mycompany.heromarsspring.viewmodel.SmithData;

@Controller
public class SmithController {

	@Autowired
	SessionService sessionService;
	
	@Autowired
	HeroService heroService;
	
	@RequestMapping(value = "smith", method = RequestMethod.GET)
	public String showMainMenu(Model model) {
		
		if (sessionService == null) {
			
			return "redirect:/main";
			
		} else if (sessionService.getCurrentUserName()==null) {
			
			return "redirect:/login";
			
		} else if (sessionService.getCurrentHeroName()==null) {
			
			return "redirect:/profile";
		}
		
		model.addAttribute("sessionData", sessionService);
		model.addAttribute("smithData", heroService.getSmithData(sessionService.getCurrentHeroName()));
		
		return "smith.html";
	}
	
	@RequestMapping(value = "smith", method = RequestMethod.POST)
	public String showMainMenu(@ModelAttribute("smithData") SmithData heroFormData, Model model) {
		
		if (sessionService == null) {
			
			return "redirect:/main";
			
		} else if (sessionService.getCurrentUserName()==null) {
			
			return "redirect:/login";
			
		} else if (sessionService.getCurrentHeroName()==null) {
			
			return "redirect:/profile";
		}
		
		if (null == heroFormData.getCraftedItem()) {
			return "redirect:/smith";
		}
		
		String craftMessage = heroService.craftItem(sessionService.getCurrentHeroName(), heroFormData.getCraftedItem());
		
		model.addAttribute("craftMessage", craftMessage);
		model.addAttribute("sessionData", sessionService);
		model.addAttribute("smithData", heroService.getSmithData(sessionService.getCurrentHeroName()));
		
		return "smith.html";
	}
	
}
