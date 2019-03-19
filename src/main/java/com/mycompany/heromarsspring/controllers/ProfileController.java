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

		if (sessionService == null) {

			return "redirect:/main";

		} else if (sessionService.getCurrentUserName() == null) {

			return "redirect:/login";

		}

		ProfileData profileData = new ProfileData();
		profileData.setHeroNames(userService.getHeroNames(sessionService.getCurrentUserName()));
		model.addAttribute("profileData", profileData);
		model.addAttribute("sessionData", sessionService);

		return "profile.html";
	}

	@RequestMapping(value = "modifyEmail", method = RequestMethod.POST)
	public String modifyUserEmail(@ModelAttribute("profileData") @Valid ProfileData profileData,
			BindingResult bindingResult, Model model) {

		if (sessionService == null) {

			return "redirect:/main";

		} else if (sessionService.getCurrentUserName() == null) {

			return "redirect:/login";

		}

		if (!bindingResult.hasFieldErrors("eMail")) {
			userService.setUserEmail(profileData.getEMail(), sessionService.getCurrentUserName());
		}

		profileData.setHeroNames(userService.getHeroNames(sessionService.getCurrentUserName()));
		model.addAttribute("sessionData", sessionService);

		return "profile.html";
	}

	@RequestMapping(value = "modifyPassword", method = RequestMethod.POST)
	public String modifyUserPassword(@ModelAttribute("profileData") @Valid ProfileData profileData,
			BindingResult bindingResult, Model model) {

		if (sessionService == null) {

			return "redirect:/main";

		} else if (sessionService.getCurrentUserName() == null) {

			return "redirect:/login";

		}

		if (!bindingResult.hasFieldErrors("newPassword") && !bindingResult.hasFieldErrors("confirmNewPassword")) {
			userService.setUserPassword(profileData.getNewPassword(), sessionService.getCurrentUserName());
		}

		profileData.setHeroNames(userService.getHeroNames(sessionService.getCurrentUserName()));
		model.addAttribute("sessionData", sessionService);

		return "profile.html";
	}

	@RequestMapping(value = "setHero", method = RequestMethod.POST)
	public String setHero(@ModelAttribute("profileData") @Valid ProfileData profileData, BindingResult bindingResult,
			Model model) {

		if (sessionService == null) {

			return "redirect:/main";

		} else if (sessionService.getCurrentUserName() == null) {

			return "redirect:/login";

		}

		String heroName = profileData.getSelectedHeroName();

		if (null == heroName || "".equals(heroName)) {

			return "redirect:/profile";

		}

		sessionService.setCurrentHeroName(profileData.getSelectedHeroName());

		return "redirect:/hero";
	}

}
