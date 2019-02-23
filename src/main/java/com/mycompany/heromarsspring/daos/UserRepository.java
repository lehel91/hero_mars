package com.mycompany.heromarsspring.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.heromarsspring.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	
}
