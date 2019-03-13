package com.mycompany.heromarsspring.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mycompany.heromarsspring.entities.ItemMarket;

@Repository
public interface MarketRepository extends JpaRepository<ItemMarket, Integer>{

	List<ItemMarket> findAll();
	
	@Query("select i from ItemMarket i order by i.price")
	List<ItemMarket> orderedListByPrice();
	
	@Query("select i from ItemMarket i  where i.item.type = ?1")
	List<ItemMarket> findByType(String typeValue);
	
	void deleteById(Integer id);
	
}
