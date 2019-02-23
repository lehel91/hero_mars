/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.heromarsspring.daos;


import java.time.LocalDate;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author GaussGun
 */

public class HeroActionsDao {

//    private static HeroActionsDao instance;
//
//    @PersistenceContext
//    private static EntityManager em;
//
//    private HeroActionsDao() {
//
//    }
//
//    public static HeroActionsDao getInstance() {
//        if (instance == null) {
//            instance = new HeroActionsDao();
//        }
//        return instance;
//    }
//
//    public Optional<Hero> findHeroById(int heroId) {
//
//        TypedQuery<Hero> q = em.createQuery("SELECT t FROM Hero t WHERE t.heroId = :heroId", Hero.class);
//        q.setParameter("heroId", heroId);
//
//        try {
//            Hero result = q.getSingleResult();
//            return Optional.of(result);
//        } catch (NoResultException e) {
//            return Optional.empty();
//        } finally {
//
//        }
//    }
//
//    public void initializeDatabase() {
//
//        Hero hero = new Hero();
//        User user = new User();
//
//        user.setBirthYear(1990);
//        user.setEMail("lol@lol.hu");
//        user.setPassword("lol");
//        user.setUserName("Sanyi");
//
//        hero.setCreationDate(LocalDate.now());
//        hero.setFood(5);
//        hero.setHairColor(HairColorEnum.BROWN);
//        hero.setHeight(190);
//        hero.setHeroName("Lali");
//        hero.setHp(500);
//        hero.setHeroLevel(50);
//        hero.setMoney(500000);
//        hero.setSex(SexEnum.MALE);
//        hero.setSpecies(SpeciesEnum.ELF);
//        hero.setStrength(500);
//        hero.setUser(user);
//        hero.setWater(50);
//        hero.setWeight(80);
//        hero.setWisdom(1000);
//
//        user.getHeroes().add(hero);
//        
//        em.persist(user);
//
//    }

}
