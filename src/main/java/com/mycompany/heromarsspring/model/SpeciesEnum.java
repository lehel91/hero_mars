
package com.mycompany.heromarsspring.model;

import lombok.Getter;

@Getter
public enum SpeciesEnum {
    RAPTOID("Raptoid",80,170,1,10,10,10,10,10,10,20),
    SAURIAN("Szaurián",90,190,1,10,10,10,10,10,10,15),
    ZETAN("Zéta",60,160,1,10,10,10,10,10,10,25),
    MANTID("Mantid",80,230,1,10,10,10,10,10,10,20),
    PLEIADIAN("Plejádi",70,180,1,10,10,10,10,10,10,22);
    
	private final String description;
    private final int weight;
    private final int height;
    private final int level;
    private final int hp;
    private final int wisdom;
    private final int strenght;
    private final int water;
    private final int food;
    private final int money;
    private final int actionPoint;

    private SpeciesEnum(String description, int weight, int height, int level, int hp, int wisdom, int strenght, int water, int food, int money, int actionPoint) {
        this.description = description;
    	this.weight = weight;
        this.height = height;
        this.level = level;
        this.hp = hp;
        this.wisdom = wisdom;
        this.strenght = strenght;
        this.water = water;
        this.food = food;
        this.money = money;
        this.actionPoint = actionPoint;
    }

}
