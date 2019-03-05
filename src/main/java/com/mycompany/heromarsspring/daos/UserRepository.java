package com.mycompany.heromarsspring.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.heromarsspring.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByUserName(String userName);

	@Query(value = "SELECT h.heroName FROM User u JOIN u.heroes h WHERE u.userName = :userName")
	List<String> getHeroNames(@Param("userName") String userName);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value= "UPDATE User u SET u.password = :password WHERE u.userName = :userName")
	void setUserPassword(@Param("password") String password, @Param("userName") String userName);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value= "UPDATE User u SET u.eMail = ?1 WHERE u.userName = ?2")
	void setUserEmail(String eMail, String userName);
	
}
