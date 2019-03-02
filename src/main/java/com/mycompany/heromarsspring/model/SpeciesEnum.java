
package com.mycompany.heromarsspring.model;

public enum SpeciesEnum {
    RAPTOID(80,170,1,10,10,10,10,10,10),
    SAURIAN(90,190,1,10,10,10,10,10,10),
    ZETAN(60,160,1,10,10,10,10,10,10),
    MANTID(80,230,1,10,10,10,10,10,10),
    PLEIADIAN(70,180,1,10,10,10,10,10,10);
    
    private final int weight;
    private final int height;
    private final int level;
    private final int hp;
    private final int wisdom;
    private final int strenght;
    private final int water;
    private final int food;
    private final int money;

    private SpeciesEnum(int weight, int height, int level, int hp, int wisdom, int strenght, int water, int food, int money) {
        this.weight = weight;
        this.height = height;
        this.level = level;
        this.hp = hp;
        this.wisdom = wisdom;
        this.strenght = strenght;
        this.water = water;
        this.food = food;
        this.money = money;
    }

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    public int getLevel() {
        return level;
    }

    public int getHp() {
        return hp;
    }

    public int getWisdom() {
        return wisdom;
    }

    public int getStrenght() {
        return strenght;
    }

    public int getWater() {
        return water;
    }

    public int getFood() {
        return food;
    }

    public int getMoney() {
        return money;
    }
    
    
    
    
}
