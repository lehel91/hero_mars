package com.mycompany.heromarsspring.viewmodel;

import com.mycompany.heromarsspring.model.ItemEnum;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SmithData {

	private Integer heroMoney;
	private Integer heroLevel;
	private ItemEnum craftedItem;
	
}
