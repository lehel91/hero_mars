package com.mycompany.heromarsspring.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.heromarsspring.entities.ItemMarket;

@Repository
public interface MarketRepository extends JpaRepository<ItemMarket, Integer>{

	List<ItemMarket> findAll();
	
	
}
