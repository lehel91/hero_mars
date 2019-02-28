package com.mycompany.heromarsspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainPageController {
	

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String showMainMenu() {

		return "index.html";
	}
	
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String showRegister() {

		return "registration.html";
	}
	
	@RequestMapping(value = "stb", method = RequestMethod.GET)
	public String showStb() {

		return "stb.html";
	}

}
