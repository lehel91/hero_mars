package com.mycompany.heromarsspring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;

import com.mycompany.heromarsspring.daos.UserRepository;
import com.mycompany.heromarsspring.entities.User;
import com.mycompany.heromarsspring.viewmodel.LoginFormData;
import com.mycompany.heromarsspring.viewmodel.RegistrationFormData;

public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User saveUser(RegistrationFormData registrationFormData) {
		User user = new User();
		user.setUserName(registrationFormData.getUserName());
		user.setPassword(BCrypt.hashpw(registrationFormData.getPassword(), BCrypt.gensalt()));
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
	
	public User findByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}
	
	public boolean isValidLogin(LoginFormData loginFormData) {
		
		User user = userRepository.findByUserName(loginFormData.getUserName());
		
		if (user == null) {
			return false;
			
		} else if (BCrypt.checkpw(loginFormData.getPassword(), user.getPassword())) {
			return true;
			
		}
		return false;
	}
	
	public List<String> getHeroNames(String username) {

		List<String> heroNames = userRepository.getHeroNames(username);
		
		if (heroNames.isEmpty()) {
			
			return null;
			
		}
		
		return heroNames;

	}
	
	public void setUserEmail(String eMail, String userName) {
		userRepository.setUserEmail(eMail, userName);
	}
	
	public void setUserPassword(String password, String userName) {
		System.out.println(password + " " + userName);
		userRepository.setUserPassword(BCrypt.hashpw(password, BCrypt.gensalt()), userName);
	}

}
