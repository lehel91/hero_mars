package com.mycompany.heromarsspring.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mycompany.heromarsspring.entities.Hero;

@Repository
public interface HeroRepository extends JpaRepository<Hero, Integer> {

	Hero findByHeroId(Integer heroId);

	Hero findByHeroName(String heroName);
	
}
