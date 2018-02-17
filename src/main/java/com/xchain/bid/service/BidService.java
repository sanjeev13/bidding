package com.xchain.bid.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xchain.bid.dao.BidDao;
import com.xchain.bid.dao.CatalogDao;
import com.xchain.bid.dao.UserDao;
import com.xchain.bid.model.Bid;
import com.xchain.bid.model.Catalog;
import com.xchain.bid.model.BidUser;
import com.xchain.bid.model.form.BidForm;

@Service
public class BidService {

	@Autowired
	BidDao bidDao;
	@Autowired
	UserDao userDao;
	@Autowired
	CatalogDao catalogDao;

	public void save(BidForm bidForm) {
		
		BidUser bidder = userDao.findByName(bidForm.getBidder());
		Catalog catalog = catalogDao.findByTitle(bidForm.getCatalog()); 
		
		Bid bid = new Bid(bidForm.getBidTime(),bidForm.getAmount(),bidder,catalog);
		bid.setActive(Boolean.TRUE);
	
		bidDao.save(bid);
	}

	public List<Bid> getAllBids() {
		List<Bid> bids = new ArrayList<Bid>();
		for(Bid b : bidDao.findAll()) {
			bids.add(b);
		}
		return bids;
	}

	public void save(Bid bid) {
		bidDao.save(bid);
	}
	
}
