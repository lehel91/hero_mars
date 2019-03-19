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
    
    WELLDRILLING_PADAVAN("Kútfúró inas",1,1,1,0.2),
    WELLDRILLING_MASTER("Kútfúró mester",3,2,1,0.4),
    WELLDRILLING_MAGE("Kútfúró mágus",6,3,1,0.6),
    HUNTER_PADAVAN("Vadász inas",1,1,1,0.2),
    HUNTER_MASTER("Vadász mester",2,4,1,0.4),
    HUNTER_MAGE("Vadász mágus",4,6,1,0.6),
    ASTRONOMER_PADAVAN("Csillagvizsgáló inas",1,1,2,0.2),
    ASTRONOMER_MASTER("Csillagvizsgáló mester",2,4,2,0.4),
    ASTRONOMER_MAGE("Csillagvizsgáló mágus", 3,3,2,0.6),
    TREASURE_HUNTER_PADAVAN("Kincsvadász inas",1,1,1,0.2),
    TREASURE_HUNTER_MASTER("Kincsvadász mester",4,3,1,0.4),
    TREASURE_HUNTER_MAGE("Kincsvadász mágus",6,6,1,0.6);
    
	private final String description;
    private final Integer skillHpMod;
    private final Integer skillStrengthMod;
    private final Integer skillWisdomMod;
    private final Double successRate;

    
	private SkillEnum(String description, Integer skillHpMod, Integer skillStrengthMod, Integer skillWisdomMod,
			Double successRate) {
		this.description = description;
		this.skillHpMod = skillHpMod;
		this.skillStrengthMod = skillStrengthMod;
		this.skillWisdomMod = skillWisdomMod;
		this.successRate = successRate;
	}
    
    
    
}
