package com.mycompany.heromarsspring.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.heromarsspring.entities.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

	Item findByItemId(Integer itemId);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value= "UPDATE Item i SET i.isInUse = :isInUse WHERE i.itemId = :itemId")
	void updateItemUsage(@Param("itemId") Integer itemId, @Param("isInUse") Boolean isInUse);
}
