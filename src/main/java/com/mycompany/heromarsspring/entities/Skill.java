/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.heromarsspring.entities;

import com.mycompany.heromarsspring.model.SkillEnum;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author GaussGun
 */
@Entity
@Getter
@Setter
@Table(name = "Skills")
public class Skill implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer skillId;
    
    @Enumerated(EnumType.STRING)
    private SkillEnum skillType;
    
    @ManyToMany(mappedBy="skills")
    private Set<Hero> heroes = new HashSet<>();
    
    @OneToMany(mappedBy="skill")
    private Set<Question> questions = new HashSet<>();


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (skillId != null ? skillId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the skillId fields are not set
        if (!(object instanceof Skill)) {
            return false;
        }
        Skill other = (Skill) object;
        if ((this.skillId == null && other.skillId != null) || (this.skillId != null && !this.skillId.equals(other.skillId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Skill{" + "skillId=" + skillId + ", skillType=" + skillType + '}';
    }

}
