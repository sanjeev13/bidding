package com.xchain.bid.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="item")
public class Item extends BaseEntity{

	@Column(name = "name", nullable = false)
	String name;
	@Column(name = "description", nullable = false)
	String description;

	@ManyToOne
    @JoinColumn(name = "catalog_id")
	Catalog catalog;
	
	public Item(String name, String description, Catalog catalog) {
		super();
		this.name = name;
		this.description = description;
		this.catalog = catalog;
	}
	
	public Catalog getCatalog() {
		return catalog;
	}

	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}

	public Item() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", description=" + description + "]";
	}
}
