package com.mycompany.heromarsspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.heromarsspring.services.HeroService;
import com.mycompany.heromarsspring.services.MarketService;
import com.mycompany.heromarsspring.services.SessionService;

@Controller
public class MarketController {

	@Autowired
	private SessionService sessionService;
	
	@Autowired
	private HeroService heroService;

	@Autowired
	private MarketService marketService;

	@RequestMapping(value = "market", method = RequestMethod.GET)
	public String showMarket(Model model) {

		if (sessionService == null) {

			return "redirect:/main";

		} else if (sessionService.getCurrentUserName() == null) {

			return "redirect:/login";

		} else if (sessionService.getCurrentHeroName() == null) {

			return "redirect:/profile";
		}

		model.addAttribute("sessionData", sessionService);
		model.addAttribute("hero", heroService.findHeroByName(sessionService.getCurrentHeroName()));
		model.addAttribute("itemMarkets", marketService.getItems());	

		return "marketplace.html";
	}
	
	@RequestMapping(value = "orderedByPrice", method = RequestMethod.GET)
	public String orderedList(Model model) {
		model.addAttribute("sessionData", sessionService);
		model.addAttribute("hero", heroService.findHeroByName(sessionService.getCurrentHeroName()));
		model.addAttribute("itemMarkets", marketService.orderedListByPrice());
		return "marketplace.html";
	}
	
    @RequestMapping(value = "searchByType", method = RequestMethod.GET)
    public String searchByType(@RequestParam (value = "type", required = false) String type, Model model) {
    	model.addAttribute("sessionData", sessionService);
    	model.addAttribute("hero", heroService.findHeroByName(sessionService.getCurrentHeroName()));
        model.addAttribute("itemMarkets", marketService.findByType(type));
        return "marketplace.html";
    }
    
    @RequestMapping(value = "buyItem", method = RequestMethod.GET)
    public String searchByType(@RequestParam (value = "id", required = true) Integer id, Model model) {
    	model.addAttribute("sessionData", sessionService);
    	model.addAttribute("hero", heroService.findHeroByName(sessionService.getCurrentHeroName()));
        model.addAttribute("itemMarkets", marketService.buyItem(id, sessionService.getCurrentHeroName()));
        model.addAttribute("message", marketService.getMessage());
        return "marketplace.html";
    }
}
