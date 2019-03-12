package com.mycompany.heromarsspring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.heromarsspring.daos.MarketRepository;
import com.mycompany.heromarsspring.entities.Item;
import com.mycompany.heromarsspring.entities.ItemMarket;

@Service
public class MarketService {

	@Autowired MarketRepository marketRepo;
	
	public void saveItem(Item item, Integer price) {
		
		ItemMarket market = new ItemMarket();
		
		market.setItem(item);
		market.setPrice(price);
		
		marketRepo.saveAndFlush(market);
	}
	
	public List<ItemMarket> getItems(){
		return marketRepo.findAll();
	}
}
