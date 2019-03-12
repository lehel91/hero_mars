package com.mycompany.heromarsspring.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.heromarsspring.entities.Skill;



@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer> {
	
	Skill findBySkillId(Integer skillId);
	
	Skill findBySkillName(String skillName);
	
	List<Skill> findAll();

}
