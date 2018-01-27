package com.xchain.bid.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.xchain.bid.model.Bid;
import com.xchain.bid.model.Catalog;
import com.xchain.bid.model.User;

public interface BidDao extends CrudRepository<Bid, Long>{

	List<Bid> findByCatalog(Catalog catalog);

	List<Bid> findByBidder(User user);

}
