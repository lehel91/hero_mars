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
import com.mycompany.heromarsspring.viewmodel.RegistrationFormData;

@Controller
public class RegistrationController {

	@Autowired
	private SessionService sessionService;
	
	@Autowired
	private UserService userservice;

	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String register(Model model) {

		model.addAttribute("registrationFormData", new RegistrationFormData());

		return "registration.html";
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String submitRegistration(
			@ModelAttribute("registrationFormData") @Valid RegistrationFormData registrationFormData,
			BindingResult bindingResult, Model model) {

		System.out.println(registrationFormData);

		boolean hasUniqueUserName = userservice.checkUniqueUserName(registrationFormData.getUserName());
		
		if (!bindingResult.hasErrors() && hasUniqueUserName
				&& registrationFormData.getPassword().equals(registrationFormData.getConfirmPassword())) {
			userservice.saveUser(registrationFormData);

			model.addAttribute("loginFormData", new LoginFormData());

			return "login.html";
		}

		return "registration.html";
	}
}
