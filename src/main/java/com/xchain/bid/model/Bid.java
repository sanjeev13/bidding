package com.xchain.bid.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.xchain.bid.utils.DateUtils;

@Entity(name="bid")
public class Bid extends BaseEntity{

	@ManyToOne
    @JoinColumn(name = "catalog_id")
	Catalog catalog;
	
	@ManyToOne
    @JoinColumn(name = "bidder_id")
	BidUser bidder;
	
	@Column(name = "amount", nullable = false)
	Float amount;

	@Column(name = "bid_time", nullable = false)
	Date bidTime;


	public Bid(Date bidTime, Float amount, BidUser bidder, Catalog catalog) {
		super();
		this.bidTime = bidTime;
		this.amount = amount;
		this.bidder = bidder;
		this.catalog = catalog;
	}

	public Bid() {
		super();
	}

	public Date getBidTime() {
		return bidTime;
	}

	public void setBidTime(Date bidTime) {
		this.bidTime = bidTime;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public BidUser getBidder() {
		return bidder;
	}

	public void setBidder(BidUser bidder) {
		this.bidder = bidder;
	}

	public Catalog getCatalog() {
		return catalog;
	}

	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}

	@Override
	public String toString() {
		return "Bid [catalog=" + catalog + ", bidder=" + bidder + ", amount=" + amount 
				+ ", bidTime=" + DateUtils.getDateOnly(bidTime) + ", id=" + id + "]";
	}

}
