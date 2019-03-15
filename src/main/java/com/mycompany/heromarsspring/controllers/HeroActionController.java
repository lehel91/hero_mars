package com.mycompany.heromarsspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.mycompany.heromarsspring.entities.Item;
import com.mycompany.heromarsspring.model.ItemEnum;
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

		} else if (sessionService.getCurrentUserName() == null) {

			return "redirect:/login";

		} else if (sessionService.getCurrentHeroName() == null) {

			return "redirect:/profile";
		}

		model.addAttribute("sessionData", sessionService);

		return "hero_actions.html";
	}

	@RequestMapping(value = "gathering_water", method = RequestMethod.GET)
	public String getWater(Model model) {
		if (sessionService == null) {

			return "redirect:/index";

		} else if (sessionService.getCurrentUserName() == null) {

			return "redirect:/login";

		} else if (sessionService.getCurrentHeroName() == null) {

			return "redirect:/profile";
		}

		String message = heroActionService.gatherWater(sessionService.getCurrentHeroName());
		
		model.addAttribute("message", new Gson().toJson(message));
		model.addAttribute("sessionData", sessionService);
		
		return "redirect:/hero_actions";

	}

	@RequestMapping(value = "gathering_food", method = RequestMethod.GET)
	public String getFood(Model model) {
		if (sessionService == null) {

			return "redirect:/index";

		} else if (sessionService.getCurrentUserName() == null) {

			return "redirect:/login";

		} else if (sessionService.getCurrentHeroName() == null) {

			return "redirect:/profile";
		}
		
		String message = heroActionService.gatherFood(sessionService.getCurrentHeroName());
		
		model.addAttribute("message", new Gson().toJson(message));
		model.addAttribute("sessionData", sessionService);
		
		return "redirect:/hero_actions";
	}

	@RequestMapping(value = "hunting_treasure", method = RequestMethod.GET)
	public String getTreasures(Model model) {
		if (sessionService == null) {

			return "redirect:/index";

		} else if (sessionService.getCurrentUserName() == null) {

			return "redirect:/login";

		} else if (sessionService.getCurrentHeroName() == null) {

			return "redirect:/profile";
		}

		String message = heroActionService.getTreasures(sessionService.getCurrentHeroName());
		
		model.addAttribute("message", new Gson().toJson(message));
		model.addAttribute("sessionData", sessionService);
		
		return "redirect:/hero_actions";
	}
	
	@RequestMapping(value = "go_to_an_adventure", method = RequestMethod.GET)
	public String goToAnAdvanture(Model model) {
		if (sessionService == null) {

			return "redirect:/index";

		} else if (sessionService.getCurrentUserName() == null) {

			return "redirect:/login";

		} else if (sessionService.getCurrentHeroName() == null) {

			return "redirect:/profile";
		}

		String message = heroActionService.goToAnAdvanture(sessionService.getCurrentHeroName());
		
		model.addAttribute("message", new Gson().toJson(message));
		model.addAttribute("sessionData", sessionService);
		
		return "redirect:/hero_actions";
	}
	
	@RequestMapping(value = "learning_welldrilling_skill", method = RequestMethod.GET)
	public String developWelldrillingSkill(Model model) {
		if (sessionService == null) {

			return "redirect:/index";

		} else if (sessionService.getCurrentUserName() == null) {

			return "redirect:/login";

		} else if (sessionService.getCurrentHeroName() == null) {

			return "redirect:/profile";
		}

		String message = heroActionService.developWelldrillingSkill(sessionService.getCurrentHeroName());
		
		model.addAttribute("message", new Gson().toJson(message));
		model.addAttribute("sessionData", sessionService);
		
		return "redirect:/hero_actions";
	}
	
	@RequestMapping(value = "learning_hunting_skill", method = RequestMethod.GET)
	public String developHuntingSkill(Model model) {
		if (sessionService == null) {

			return "redirect:/index";

		} else if (sessionService.getCurrentUserName() == null) {

			return "redirect:/login";

		} else if (sessionService.getCurrentHeroName() == null) {

			return "redirect:/profile";
		}

		String message = heroActionService.developHuntingSkill(sessionService.getCurrentHeroName());
		
		model.addAttribute("message", new Gson().toJson(message));
		model.addAttribute("sessionData", sessionService);
		
		return "redirect:/hero_actions";
	}
	
	@RequestMapping(value = "learning_astronomer_skill", method = RequestMethod.GET)
	public String developAstronomerSkill(Model model) {
		if (sessionService == null) {

			return "redirect:/index";

		} else if (sessionService.getCurrentUserName() == null) {

			return "redirect:/login";

		} else if (sessionService.getCurrentHeroName() == null) {

			return "redirect:/profile";
		}

		String message = heroActionService.developAstronomerSkill(sessionService.getCurrentHeroName());
		
		model.addAttribute("message", new Gson().toJson(message));
		model.addAttribute("sessionData", sessionService);
		
		return "redirect:/hero_actions";
	}
	
	@RequestMapping(value = "learning_treasure_hunter_skill", method = RequestMethod.GET)
	public String developTreasureHunterSkill(Model model) {
		if (sessionService == null) {

			return "redirect:/index";

		} else if (sessionService.getCurrentUserName() == null) {

			return "redirect:/login";

		} else if (sessionService.getCurrentHeroName() == null) {

			return "redirect:/profile";
		}

		String message = heroActionService.developTreasureHunterSkill(sessionService.getCurrentHeroName());
		
		model.addAttribute("message", new Gson().toJson(message));
		model.addAttribute("sessionData", sessionService);
		
		return "redirect:/hero_actions";
	}
}
