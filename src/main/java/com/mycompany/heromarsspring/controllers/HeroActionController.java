package com.mycompany.heromarsspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycompany.heromarsspring.exceptions.InsufficientActionPointsException;
import com.mycompany.heromarsspring.model.AjaxResponse;
import com.mycompany.heromarsspring.services.HeroActionService;
import com.mycompany.heromarsspring.services.HeroService;
import com.mycompany.heromarsspring.services.SessionService;

@Controller
public class HeroActionController {

	@Autowired
	private SessionService sessionService;

	@Autowired
	private HeroActionService heroActionService;
	
	@Autowired
	private HeroService heroService;

	@RequestMapping(value = "hero_actions", method = RequestMethod.GET)
	public String showActionsMenu(Model model) {

		if (sessionService == null) {

			return "redirect:/main";

		} else if (sessionService.getCurrentUserName() == null) {

			return "redirect:/login";

		} else if (sessionService.getCurrentHeroName() == null) {

			return "redirect:/profile";
		}

		model.addAttribute("sessionData", sessionService);
		model.addAttribute("hero", heroService.findHeroByName(sessionService.getCurrentHeroName()));
		model.addAttribute("waterGatheringCost", heroActionService.getWaterCost());
		model.addAttribute("foodGatheringCost", heroActionService.getHuntingCost());
		model.addAttribute("treasureHuntingCost", heroActionService.getTreasureHuntingCost());
		model.addAttribute("adventureCost", heroActionService.getAdventureCost());
		model.addAttribute("padavanLearningCost", heroActionService.getPadavanLearningCost());
		model.addAttribute("masterLearningCost", heroActionService.getMasterLearningCost());
		model.addAttribute("mageLearningCost", heroActionService.getMageLearningCost());
		

		return "hero_actions.html";
	}

	@RequestMapping(value = "gathering_water", method = RequestMethod.GET)
	public @ResponseBody AjaxResponse getWater(Model model) {
		
		String message;
		AjaxResponse waterResponse = new AjaxResponse();
		try {
			message = heroActionService.gatherWater(sessionService.getCurrentHeroName());
		} catch (InsufficientActionPointsException e) {
			waterResponse.setMessage(e.getMessage());
			waterResponse.setActionPoints(heroService.findHeroByName(sessionService.getCurrentHeroName()).getActionPoint());
			return waterResponse;
		}
		
		waterResponse.setMessage(message);
		waterResponse.setActionPoints(heroService.findHeroByName(sessionService.getCurrentHeroName()).getActionPoint());

		return waterResponse;
		
	}
	
	@RequestMapping(value = "gathering_food", method = RequestMethod.GET)
	public @ResponseBody AjaxResponse getFood(Model model) {
		
		String message;
		AjaxResponse foodResponse = new AjaxResponse();
		try {
			message = heroActionService.gatherFood(sessionService.getCurrentHeroName());
		} catch (InsufficientActionPointsException e) {
			foodResponse.setMessage(e.getMessage());
			foodResponse.setActionPoints(heroService.findHeroByName(sessionService.getCurrentHeroName()).getActionPoint());
			return foodResponse;
		}
		
		foodResponse.setMessage(message);
		foodResponse.setActionPoints(heroService.findHeroByName(sessionService.getCurrentHeroName()).getActionPoint());

		return foodResponse;
		
	}

	@RequestMapping(value = "hunting_treasure", method = RequestMethod.GET)
	public @ResponseBody AjaxResponse getTreasures(Model model) {
		
		String message;
		AjaxResponse treasureResponse = new AjaxResponse();
		try {
			message = heroActionService.getTreasures(sessionService.getCurrentHeroName());
		} catch (InsufficientActionPointsException e) {
			treasureResponse.setMessage(e.getMessage());
			treasureResponse.setActionPoints(heroService.findHeroByName(sessionService.getCurrentHeroName()).getActionPoint());
			return treasureResponse;
		}
		
		treasureResponse.setMessage(message);
		treasureResponse.setActionPoints(heroService.findHeroByName(sessionService.getCurrentHeroName()).getActionPoint());

		return treasureResponse;	
	}
	
	@RequestMapping(value = "go_to_an_adventure", method = RequestMethod.GET)
	public @ResponseBody AjaxResponse goToAnAdvanture(Model model) {
		
		String message;
		AjaxResponse adventureResponse = new AjaxResponse();
		try {
			message = heroActionService.goToAnAdvanture(sessionService.getCurrentHeroName());
		} catch (InsufficientActionPointsException e) {
			adventureResponse.setMessage(e.getMessage());
			adventureResponse.setActionPoints(heroService.findHeroByName(sessionService.getCurrentHeroName()).getActionPoint());
			return adventureResponse;
		}
		
		adventureResponse.setMessage(message);
		adventureResponse.setActionPoints(heroService.findHeroByName(sessionService.getCurrentHeroName()).getActionPoint());

		return adventureResponse;	
	}
	
	@RequestMapping(value = "learning_welldrilling_skill", method = RequestMethod.GET)
	public @ResponseBody AjaxResponse developWelldrillingSkill(Model model) {
		
		String message;
		AjaxResponse welldrillingResponse = new AjaxResponse();
		try {
			message = heroActionService.developWelldrillingSkill(sessionService.getCurrentHeroName());
		} catch (InsufficientActionPointsException e) {
			welldrillingResponse.setMessage(e.getMessage());
			welldrillingResponse.setActionPoints(heroService.findHeroByName(sessionService.getCurrentHeroName()).getActionPoint());
			return welldrillingResponse;
		}
		
		welldrillingResponse.setMessage(message);
		welldrillingResponse.setActionPoints(heroService.findHeroByName(sessionService.getCurrentHeroName()).getActionPoint());

		return welldrillingResponse;	
	}
	
	@RequestMapping(value = "learning_hunting_skill", method = RequestMethod.GET)
	public @ResponseBody AjaxResponse developHuntingSkill(Model model) {
		
		String message;
		AjaxResponse huntingResponse = new AjaxResponse();
		try {
			message = heroActionService.developHuntingSkill(sessionService.getCurrentHeroName());
		} catch (InsufficientActionPointsException e) {
			huntingResponse.setMessage(e.getMessage());
			huntingResponse.setActionPoints(heroService.findHeroByName(sessionService.getCurrentHeroName()).getActionPoint());
			return huntingResponse;
		}
		
		huntingResponse.setMessage(message);
		huntingResponse.setActionPoints(heroService.findHeroByName(sessionService.getCurrentHeroName()).getActionPoint());

		return huntingResponse;	
	}
	
	@RequestMapping(value = "learning_astronomer_skill", method = RequestMethod.GET)
	public @ResponseBody AjaxResponse developAstronomerSkill(Model model) {
		
		String message;
		AjaxResponse astronomerResponse = new AjaxResponse();
		try {
			message = heroActionService.developAstronomerSkill(sessionService.getCurrentHeroName());
		} catch (InsufficientActionPointsException e) {
			astronomerResponse.setMessage(e.getMessage());
			astronomerResponse.setActionPoints(heroService.findHeroByName(sessionService.getCurrentHeroName()).getActionPoint());
			return astronomerResponse;
		}
		
		astronomerResponse.setMessage(message);
		astronomerResponse.setActionPoints(heroService.findHeroByName(sessionService.getCurrentHeroName()).getActionPoint());

		return astronomerResponse;	
	}
	
	@RequestMapping(value = "learning_treasure_hunter_skill", method = RequestMethod.GET)
	public @ResponseBody AjaxResponse developTreasureHunterSkill(Model model) {
		
		String message;
		AjaxResponse treasureHunterResponse = new AjaxResponse();
		try {
			message = heroActionService.developTreasureHunterSkill(sessionService.getCurrentHeroName());
		} catch (InsufficientActionPointsException e) {
			treasureHunterResponse.setMessage(e.getMessage());
			treasureHunterResponse.setActionPoints(heroService.findHeroByName(sessionService.getCurrentHeroName()).getActionPoint());
			return treasureHunterResponse;
		}
		
		treasureHunterResponse.setMessage(message);
		treasureHunterResponse.setActionPoints(heroService.findHeroByName(sessionService.getCurrentHeroName()).getActionPoint());

		return treasureHunterResponse;	
	}
	
}
