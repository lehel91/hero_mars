package com.mycompany.heromarsspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.mycompany.heromarsspring.services.HeroService;

@SpringBootApplication
public class HeromarsspringApplication {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = SpringApplication.run(new Class<?>[]{HeromarsspringApplication.class, MarsConfig.class}, args);
		
		HeroService heroService = context.getBean(HeroService.class);
		
		System.out.println(heroService.findHeroById(2));
		
	}

}
