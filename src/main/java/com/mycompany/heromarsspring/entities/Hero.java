package com.mycompany.heromarsspring.entities;

import com.mycompany.heromarsspring.model.HairColorEnum;
import com.mycompany.heromarsspring.model.SexEnum;
import com.mycompany.heromarsspring.model.SpeciesEnum;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Heroes")
public class Hero implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer heroId;

    @Column(nullable = false, unique = true)
    private String heroName;

    private LocalDate creationDate;
    
    private LocalDateTime lastActivity;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SpeciesEnum species;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SexEnum sex;

    private Integer height;

    private Integer weight;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private HairColorEnum hairColor;

    @JoinColumn(name = "user", referencedColumnName = "userId")
    @ManyToOne
    private User user;

    private Integer heroLevel;

    private Integer hp;

    private Integer wisdom;

    private Integer strength;

    private Integer water;

    private Integer food;

    private Integer money;
    
    private Integer actionPoint;

    @ManyToMany()
    @JoinTable(name = "hero_skills",
            joinColumns = @JoinColumn(name = "heroId"),
            inverseJoinColumns = @JoinColumn(name = "skillId"))
    private Set<Skill> skills = new HashSet<>();

    @OneToMany(mappedBy = "hero", cascade = CascadeType.REMOVE)
    private Set<Item> items = new HashSet<>();
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (heroId != null ? heroId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the heroId fields are not set
        if (!(object instanceof Hero)) {
            return false;
        }
        Hero other = (Hero) object;
        if ((this.heroId == null && other.heroId != null) || (this.heroId != null && !this.heroId.equals(other.heroId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Hero{" + "heroName=" + heroName + '}';
    }

}
