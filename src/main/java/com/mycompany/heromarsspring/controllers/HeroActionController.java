package com.mycompany.heromarsspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
			
		} else if (sessionService.getCurrentUserName()==null) {
			
			return "redirect:/login";
			
		} else if (sessionService.getCurrentHeroName()==null) {
			
			return "redirect:/profile";
		}
		
		model.addAttribute("sessionData", sessionService);
		
		return "hero_actions.html";
	}
	
	@RequestMapping(value = "water_gathering", method = RequestMethod.GET)
	public int getWater() { 
		heroActionService.decreaseActionPoints(sessionService.getCurrentHeroName(), heroActionService.getWaterCost());
		return heroActionService.getWaterAmount(sessionService.getCurrentHeroName());
		
	}
	
	public int getFood() {
		heroActionService.decreaseActionPoints(sessionService.getCurrentHeroName(), heroActionService.getHuntingCost());
		return heroActionService.getFood(sessionService.getCurrentHeroName());
	}
	
	public Item getTreasures() {
		Item item = null;
		
		heroActionService.decreaseActionPoints(sessionService.getCurrentHeroName(), heroActionService.getTreasureHuntingCost());
		if (heroActionService.getTreasureHuntingSuccesRate(sessionService.getCurrentHeroName()) > 0.5) {
			return item;
		}
		return item;
	}
	
	public Item setItemProperties(ItemEnum type, int level) {
		Item item1 = new Item();
		item1.setName(ItemEnum.LIGHTSWORD);
		item1.setLevel(3);
		item1.setIsInUse(false);
		item1.setDurability(item1.getName().getDurability());
		item1.setItemHpMod(item1.getName().getHealthMod() * item1.getLevel());
		item1.setItemStrengthMod(item1.getName().getStrengthMod() * item1.getLevel());
		item1.setItemWisdomMod(item1.getName().getWisdomMod() * item1.getLevel());
		item1.setType(item1.getName().getType());
		item1.setMarketPresence(null);
		//item1.setHero(hero);
		return item1;
		
		
	}
	
}
