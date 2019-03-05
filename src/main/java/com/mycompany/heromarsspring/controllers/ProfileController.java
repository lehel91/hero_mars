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
import com.mycompany.heromarsspring.viewmodel.ProfileData;

@Controller
public class ProfileController {

	@Autowired
	SessionService sessionService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "profile", method = RequestMethod.GET)
	public String showProfile(Model model) {

		model.addAttribute("loggedInUserName", sessionService.getCurrentUserName());
		model.addAttribute("currentHeroName", sessionService.getCurrentHeroName());
		
		ProfileData profileData = new ProfileData();
		profileData.setHeroNames(userService.getHeroNames(sessionService.getCurrentUserName()));
		model.addAttribute("profileData", profileData);
		
		return "profile.html";
	}
	
	@RequestMapping(value = "modifyEmail", method = RequestMethod.POST)
	public String modifyUserEmail(@ModelAttribute("profileData") @Valid ProfileData profileData, BindingResult bindingResult,  Model model) {

		if (!bindingResult.hasFieldErrors("eMail")) {
			userService.setUserEmail(profileData.getEMail(), sessionService.getCurrentUserName());
		}
		
		model.addAttribute("loggedInUserName", sessionService.getCurrentUserName());
		model.addAttribute("currentHeroName", sessionService.getCurrentHeroName());
		profileData.setHeroNames(userService.getHeroNames(sessionService.getCurrentUserName()));
		
		
		return "profile.html";
	}
	
	@RequestMapping(value = "modifyPassword", method = RequestMethod.POST)
	public String modifyUserPassword(@ModelAttribute("profileData") @Valid ProfileData profileData, BindingResult bindingResult,  Model model) {
		
		
		if (!bindingResult.hasFieldErrors("newPassword") && !bindingResult.hasFieldErrors("confirmNewPassword")) {
		userService.setUserPassword(profileData.getNewPassword(), sessionService.getCurrentUserName());
		}
		
		model.addAttribute("loggedInUserName", sessionService.getCurrentUserName());
		model.addAttribute("currentHeroName", sessionService.getCurrentHeroName());
		profileData.setHeroNames(userService.getHeroNames(sessionService.getCurrentUserName()));
		
		return "profile.html";
	}
	
	@RequestMapping(value = "setHero", method = RequestMethod.POST)
	public String setHero(@ModelAttribute("profileData") @Valid ProfileData profileData, BindingResult bindingResult,  Model model) {

		sessionService.setCurrentHeroName(profileData.getSelectedHeroName());
		
		return "redirect:/profile";
	}

}
