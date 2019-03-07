package com.mycompany.heromarsspring.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.mycompany.heromarsspring.services.SessionService;
import com.mycompany.heromarsspring.services.UserService;
import com.mycompany.heromarsspring.viewmodel.LoginFormData;

@Controller
public class LoginController {
	
	@Autowired
	private SessionService sessionService;
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(Model model) {

		model.addAttribute("loginFormData", new LoginFormData());
		model.addAttribute("loggedInUserName", sessionService.getCurrentUserName());
		model.addAttribute("sessionData", sessionService);

		return "login.html";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String submitLogin(@ModelAttribute("loginFormData") @Valid LoginFormData loginFormData, BindingResult bindingResult,  Model model) {

		System.out.println(loginFormData);
		
		boolean isValidUser = userService.isValidLogin(loginFormData);

		if (!bindingResult.hasErrors() && isValidUser) {

			sessionService.setCurrentUserName(loginFormData.getUserName());
			sessionService.setCurrentHeroName(null);
			
			return "redirect:/profile";
		}

		model.addAttribute("loggedInUserName", sessionService.getCurrentUserName());
		model.addAttribute("sessionData", sessionService);
		
		return "login.html";
	}

}
