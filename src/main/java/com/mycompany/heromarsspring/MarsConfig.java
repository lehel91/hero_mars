package com.mycompany.heromarsspring;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.mycompany.heromarsspring.services.UserService;

@Configuration
@ComponentScan(basePackages="com.mycompany.heromarsspring")
@EntityScan(basePackages="com.mycompany.heromarsspring.entities")
@EnableScheduling
public class MarsConfig {


	@Bean
	public UserService userService() {
		return new UserService();
	}

}
