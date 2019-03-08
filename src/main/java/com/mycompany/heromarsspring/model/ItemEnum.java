
package com.mycompany.heromarsspring.model;

import lombok.Getter;

@Getter
public enum ItemEnum {

	LIGHTSWORD("Fénykard", 2, 0, 0, 100, "ATK"), MACE("Buzogány", 1, 0, 0, 80, "ATK"),
	SHIELD("Pajzs", 0, 1, 0, 100, "DEF"), HELMET("Sisak", 0, 2, 0, 70, "DEF"),
	MAGIC_RING("Varázsgyűrű", 0, 0, 1, 100, "MISC"), TALISMAN("Talizmán", 0, 0, 2, 90, "MISC");

	private final String description;
	private final int strengthMod;
	private final int healthMod;
	private final int wisdomMod;
	private final int durability;
	private final String type;

	private ItemEnum(String description, int strengthMod, int healthMod, int wisdomMod, int durability, String type) {
		this.description = description;
		this.strengthMod = strengthMod;
		this.healthMod = healthMod;
		this.wisdomMod = wisdomMod;
		this.durability = durability;
		this.type = type;
	}

}
