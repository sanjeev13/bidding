package com.xchain.bid.model;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity(name="user")
public class BidUser extends BaseEntity{

	@Column(name = "name", nullable = false)
	String name;
	@Column(name = "type", nullable = false)
	String type;
	
	@OneToMany(targetEntity=Catalog.class, mappedBy="creator", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	Set<Catalog> catalogs;
	
	@OneToMany(targetEntity=Bid.class, mappedBy="bidder", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    Set<Bid> bids;
	
	public BidUser(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}

	public BidUser() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", id=" + id + "]";
	}
}
