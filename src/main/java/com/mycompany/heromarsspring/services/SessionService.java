package com.mycompany.heromarsspring.services;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Service
@Getter
@Setter
@ToString
@Scope(value="session", proxyMode = ScopedProxyMode.TARGET_CLASS)
//@SessionScope
public class SessionService {

	private String currentUserName;
	
	private String currentHeroName;
	
}
