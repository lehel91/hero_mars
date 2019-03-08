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
    
    WELLDRILLING_PADAVAN(1,1,1,0.2),
    WELLDRILLING_MASTER(3,2,2,0.4),
    WELLDRILLING_MAGE(6,3,3,0.6),
    HUNTER_PADAVAN(1,2,1,0.2),
    HUNTER_MASTER(2,4,2,0.4),
    HUNTER_MAGE(4,6,3,0.6),
    ASTRONOMER_PADAVAN(1,1,2,0.2),
    ASTRONOMER_MASTER(2,2,4,0.4),
    ASTRONOMER_MAGE(3,3,6,0.6),
    TREASURE_HUNTER_PADAVAN(2,1,1,0.2),
    TREASURE_HUNTER_MASTER(4,3,2,0.4),
    TREASURE_HUNTER_MAGE(6,6,3,0.6);
    
    private final Integer skillHpMod;
    private final Integer skillStrengthMod;
    private final Integer skillWisdomMod;
    private final Double successRate;
    
	private SkillEnum(Integer skillHpMod, Integer skillStrengthMod, Integer skillWisdomMod, Double successRate) {
		this.skillHpMod = skillHpMod;
		this.skillStrengthMod = skillStrengthMod;
		this.skillWisdomMod = skillWisdomMod;
		this.successRate = successRate;
	}
    
}
