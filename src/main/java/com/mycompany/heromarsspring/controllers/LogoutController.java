package com.mycompany.heromarsspring.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.heromarsspring.services.SessionService;


@Controller
public class LogoutController {
	
	@Autowired
	SessionService sessionService;

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logut(HttpSession session) {

		if (sessionService == null) {
			
			return "redirect:/index";
			
		} else if (sessionService.getCurrentUserName()==null) {
			
			return "redirect:/login";
			
		}
		
		session.invalidate();

		return "redirect:/index";
	}
}
