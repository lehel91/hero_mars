package com.mycompany.heromarsspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.heromarsspring.services.SessionService;

@Controller
public class HeroDataController {

	@Autowired
	SessionService sessionService;
	
	@RequestMapping(value = "hero", method = RequestMethod.GET)
	public String showMainMenu(Model model) {
		
		model.addAttribute("sessionData", sessionService);
		
		return "hero_data.html";
	}
	
}
