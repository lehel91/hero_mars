
package com.mycompany.heromarsspring.entities;

import com.mycompany.heromarsspring.model.ItemEnum;
import java.io.Serializable;
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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Items")
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer itemId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ItemEnum name;

    @Column(nullable = false)
    private Integer itemHpMod;

    @Column(nullable = false)
    private Integer itemStrengthMod;

    @Column(nullable = false)
    private Integer skillWisdomMod;
    
    @Column(nullable = false)
    private Integer durability;
    
    @Column(nullable = false)
    private Integer level;
    
    @Column(nullable = false)
    private String type;
    
    @Column(nullable = false)
    private Boolean isInUse;

    @JoinColumn(name = "hero", referencedColumnName = "heroId")
    @ManyToOne(cascade = CascadeType.REFRESH) //ha az item-ek megváltoztatjuk a Heroját, akkor a régi hero itemlistájából törlődjön, az újnál pedig adódjon hozzá automatikusan az elem
    private Hero hero;
    
    @OneToOne(cascade = CascadeType.REMOVE)
    private ItemMarket marketPresence;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemId != null ? itemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the itemId fields are not set
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.itemId == null && other.itemId != null) || (this.itemId != null && !this.itemId.equals(other.itemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Item{" + "itemId=" + itemId + ", type=" + name + '}';
    }



}
