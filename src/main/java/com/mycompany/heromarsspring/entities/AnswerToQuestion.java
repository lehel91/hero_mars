/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.heromarsspring.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
@Table(name = "AnswerToQuestions")
public class AnswerToQuestion implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer itqId;

    @ManyToOne
    private Question question;
    
    @ManyToOne
    private Answer answer;
    
    private Boolean isCorrect;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itqId != null ? itqId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the itqId fields are not set
        if (!(object instanceof AnswerToQuestion)) {
            return false;
        }
        AnswerToQuestion other = (AnswerToQuestion) object;
        if ((this.itqId == null && other.itqId != null) || (this.itqId != null && !this.itqId.equals(other.itqId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AnswerToQuestion{" + "id=" + itqId + ", isCorrect=" + isCorrect + '}';
    }
   
}
