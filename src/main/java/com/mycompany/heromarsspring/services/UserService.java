package com.mycompany.heromarsspring.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.mycompany.heromarsspring.daos.UserRepository;
import com.mycompany.heromarsspring.entities.User;
import com.mycompany.heromarsspring.viewmodel.RegistrationFormData;

public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User saveUser(RegistrationFormData registrationFormData) {
		User user = new User();
		user.setUserName(registrationFormData.getUserName());
		user.setPassword(registrationFormData.getPassword());
		user.setEMail(registrationFormData.getEMail());
		user.setBirthYear(registrationFormData.getBirthYear());
		
		return userRepository.saveAndFlush(user);
	}

	public boolean checkUniqueUserName(String userName) {
		User user = userRepository.findByUserName(userName);
		
		if (user == null) {
			return true;
		} 
		
		return false;
	}
}
