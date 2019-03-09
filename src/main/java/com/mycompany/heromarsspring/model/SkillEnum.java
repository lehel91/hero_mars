/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.heromarsspring.model;

import lombok.Getter;

/**
 *
 * @author GaussGun
 */
@Getter
public enum SkillEnum {
    
    WELLDRILLING_PADAVAN("Kútfúró inas",1,1,1,0.2,5),
    WELLDRILLING_MASTER("Kútfúró mester",3,2,2,0.4,7),
    WELLDRILLING_MAGE("Kútfúró mágus",6,3,3,0.6,9),
    HUNTER_PADAVAN("Vadász inas",1,1,1,0.2,6),
    HUNTER_MASTER("Vadász mester",2,4,2,0.4,8),
    HUNTER_MAGE("Vadász mágus",4,6,3,0.6,10),
    ASTRONOMER_PADAVAN("Csillagvizsgáló inas",1,1,1,0.2,7),
    ASTRONOMER_MASTER("Csillagvizsgáló mester",2,2,4,0.4,9),
    ASTRONOMER_MAGE("Csillagvizsgáló mágus", 3,3,6,0.6,11),
    TREASURE_HUNTER_PADAVAN("Kincsvadász inas",1,1,1,0.2,8),
    TREASURE_HUNTER_MASTER("Kincsvadász mester",4,3,2,0.4,10),
    TREASURE_HUNTER_MAGE("Kincsvadász mágus",6,6,3,0.6,12);
    
	private final String description;
    private final Integer skillHpMod;
    private final Integer skillStrengthMod;
    private final Integer skillWisdomMod;
    private final Double successRate;
    private final Integer actionPointCost;
    
	private SkillEnum(String description, Integer skillHpMod, Integer skillStrengthMod, Integer skillWisdomMod,
			Double successRate, Integer actionPointCost) {
		this.description = description;
		this.skillHpMod = skillHpMod;
		this.skillStrengthMod = skillStrengthMod;
		this.skillWisdomMod = skillWisdomMod;
		this.successRate = successRate;
		this.actionPointCost = actionPointCost;
	}
    
    
    
}
