package com.xchain.bid.model;

import java.util.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import com.xchain.bid.service.BidService;
import java.util.List;

public class BidList extends Observable {

	@Autowired
	BidService bidService;
	
	List<Bid> bidList;

	public BidList() {
		super();
		this.bidList = bidService.getAllBids();
	}

	public List<Bid> getBidList() {
		return bidList;
	}
	
	public void addBid(Bid bid) {
		bidList.add(bid);
        notifyObservers();
	}
	
}
