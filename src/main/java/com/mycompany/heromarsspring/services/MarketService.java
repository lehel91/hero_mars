package com.mycompany.heromarsspring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.heromarsspring.daos.HeroRepository;
import com.mycompany.heromarsspring.daos.ItemRepository;
import com.mycompany.heromarsspring.daos.MarketRepository;
import com.mycompany.heromarsspring.entities.Hero;
import com.mycompany.heromarsspring.entities.Item;
import com.mycompany.heromarsspring.entities.ItemMarket;

@Service
public class MarketService {

	@Autowired
	private MarketRepository marketRepo;

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private HeroRepository heroRepository;

	public String saveItem(Integer itemId, Integer price) {

		Item item = itemRepository.findByItemId(itemId);
		ItemMarket market = new ItemMarket();

		market.setPrice(price);
		item.setMarketPresence(market);

		marketRepo.saveAndFlush(market);

		return "Sikeresen kitetted a " + item.getName().getDescription() + "eszközödet a piacra " + price
				+ "buznyák áron";
	}

	public List<ItemMarket> getItems() {
		return marketRepo.findAll();
	}

	public List<ItemMarket> orderedListByPrice() {
		return marketRepo.orderedListByPrice();
	}

	public List<ItemMarket> findByType(String type) {
		return marketRepo.findByType(type);
	}

	public List<ItemMarket> buyItem(Integer id, String heroName) {

		ItemMarket itemMarket = marketRepo.getOne(id);

		Item item = itemMarket.getItem();

		Hero sellerHero = item.getHero();

		Hero buyerHero = heroRepository.findByHeroName(heroName);

		buyerHero.setMoney(buyerHero.getMoney() - itemMarket.getPrice());
		item.setHero(buyerHero);

		sellerHero.setMoney(sellerHero.getMoney() + itemMarket.getPrice());

		item.setMarketPresence(null);

		marketRepo.deleteById(id);

		return marketRepo.findAll();
	}
}
