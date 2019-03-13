package com.mycompany.heromarsspring.daos;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.heromarsspring.entities.Hero;

@Repository
public interface HeroRepository extends JpaRepository<Hero, Integer> {

	Hero findByHeroId(Integer heroId);

	Hero findByHeroName(String heroName);
	
	@Query(value = "SELECT h.actionPoint FROM Hero h WHERE h.heroName = :heroName")
	int getHeroActionPoints(@Param("heroName") String heroName);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value= "UPDATE Hero h SET h.actionPoint = :actionPointAfterDecrease WHERE h.heroName = :heroName")
	void setHeroActionPoints(@Param("heroName") String heroName, @Param("actionPointAfterDecrease") int actionPointAfterDecrease);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value= "UPDATE Hero h SET h.lastActivity = :lastActivity WHERE h.heroName = :heroName")
	void setLastActivity(@Param("heroName") String heroName, @Param("lastActivity") LocalDateTime lastActivity);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value= "UPDATE Hero h SET h.food = :food WHERE h.heroName = :heroName")
	void setFood(@Param("heroName") String heroName, @Param("food") int food);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value= "UPDATE Hero h SET h.water = :water WHERE h.heroName = :heroName")
	void setWater(@Param("heroName") String heroName, @Param("water") int water);	

	@Transactional
	@Modifying(clearAutomatically = true)	
	@Query(value= "UPDATE Hero h SET h.hp = :hp, h.strength = :strength, h.wisdom = :wisdom WHERE h.heroName = :heroName")
	void updateHeroStats(@Param("heroName") String heroName, @Param("hp") Integer hp, @Param("strength") Integer strength, @Param("wisdom") Integer wisdom);

}
