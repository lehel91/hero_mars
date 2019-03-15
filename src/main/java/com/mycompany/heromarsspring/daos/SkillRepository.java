package com.mycompany.heromarsspring.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.heromarsspring.entities.Skill;
import com.mycompany.heromarsspring.model.SkillEnum;



@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer> {
	
	Skill findBySkillId(Integer skillId);
	
	Skill findBySkillType(SkillEnum skillType);
	
	List<Skill> findAll();

}
