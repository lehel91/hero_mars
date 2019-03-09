package com.mycompany.heromarsspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.heromarsspring.services.HeroActionService;
import com.mycompany.heromarsspring.services.SessionService;

@Controller
public class HeroActionController {
	
	@Autowired
	private SessionService sessionService;
	
	@Autowired
	private HeroActionService heroActionService;
	
	@RequestMapping(value = "hero_actions", method = RequestMethod.GET)
	public String showActionsMenu(Model model) {
		
		if (sessionService == null) {
			
			return "redirect:/index";
			
		} else if (sessionService.getCurrentUserName()==null) {
			
			return "redirect:/login";
			
		} else if (sessionService.getCurrentHeroName()==null) {
			
			return "redirect:/profile";
		}
		
		model.addAttribute("sessionData", sessionService);
		
		return "hero_actions.html";
	}
	
}
