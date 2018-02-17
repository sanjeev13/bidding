package com.xchain.bid.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xchain.bid.dao.BidDao;
import com.xchain.bid.dao.UserDao;
import com.xchain.bid.model.Bid;
import com.xchain.bid.model.BidUser;

@Service
public class UserService {

	@Autowired
	UserDao userDao;
	@Autowired
	BidDao bidDao;
	
	public List<BidUser> getAllUsers() {
		List<BidUser> users = new ArrayList<BidUser>();
		for(BidUser u : userDao.findAll()) {
			users.add(u);
		}
		return users;
	}

	public void save(BidUser user) {
		user.setActive(Boolean.TRUE);
		userDao.save(user);
	}

	public List<String> getUsersDisplayList() {
		List<String> userNames = new ArrayList<>();	
		for(BidUser u : getAllUsers()) {
			userNames.add(u.getName());
		}
		return userNames;
	}

	public List<Bid> getBids(Long userId) {
		List<Bid> bids = new ArrayList<>();
		BidUser user = userDao.findOne(userId);
		if(user != null) {
			bids = bidDao.findByBidder(user);
		} 
		Collections.sort(bids, (b1, b2) -> Float.compare(b2.getAmount(), b1.getAmount()));
		return bids;
	}
}
