/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.heromarsspring.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ItemMarkets")
public class ItemMarket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer marketId;

    @OneToOne(mappedBy = "marketPresence", cascade = CascadeType.REFRESH)
    private Item item;

    private Integer price;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (marketId != null ? marketId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the marketId fields are not set
        if (!(object instanceof ItemMarket)) {
            return false;
        }
        ItemMarket other = (ItemMarket) object;
        if ((this.marketId == null && other.marketId != null) || (this.marketId != null && !this.marketId.equals(other.marketId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ItemMarket{" + "marketId=" + marketId + ", price=" + price + '}';
    }

}
