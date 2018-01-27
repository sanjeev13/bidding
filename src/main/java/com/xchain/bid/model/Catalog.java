package com.xchain.bid.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="catalog")
public class Catalog extends BaseEntity{
	
	@Column(name = "title", nullable = false)
	String title;
	@Column(name = "bid_start", nullable = false)
	Date bidStart;
	@Column(name = "bid_end", nullable = false)
	Date bidEnd;
	
	@ManyToOne
    @JoinColumn(name = "creator_id")
	User creator;
	
	@OneToMany(targetEntity=Item.class, mappedBy="catalog", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    Set<Item> items;

	@OneToMany(targetEntity=Bid.class, mappedBy="catalog", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    Set<Bid> bids;

	public Catalog(String title, Date bidStart, Date bidEnd, User creator) {
		super();
		this.title = title;
		this.bidStart = bidStart;
		this.bidEnd = bidEnd;
		this.creator = creator;
	}
	
	public Catalog() {
		
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public Date getBidStart() {
		return bidStart;
	}

	public void setBidStart(Date bidStart) {
		this.bidStart = bidStart;
	}

	public Date getBidEnd() {
		return bidEnd;
	}

	public void setBidEnd(Date bidEnd) {
		this.bidEnd = bidEnd;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	public List<String> getItemsList() {
		List<String> itemNames = new ArrayList<>();
		for(Item i: this.items) {
			itemNames.add(i.getName());
		}
		return itemNames;
	}
	
	@Override
	public String toString() {
		return "[title=" + title  + ", creator=" + creator+ "]";
	}
}