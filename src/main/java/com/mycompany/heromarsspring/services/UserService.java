package com.mycompany.heromarsspring.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.mycompany.heromarsspring.daos.UserRepository;
import com.mycompany.heromarsspring.entities.User;

public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User saveUser(User user) {

		return userRepository.saveAndFlush(user);
	}

}
