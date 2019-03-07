package com.mycompany.heromarsspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.heromarsspring.services.SessionService;

@Controller
public class HeroActionController {
	
	@Autowired
	private SessionService sessionService;
	
	@RequestMapping(value = "hero_actions", method = RequestMethod.GET)
	public String showActionsMenu(Model model) {
		
		model.addAttribute("session", sessionService);
		
		return "hero_actions.html";
	}
	
}
