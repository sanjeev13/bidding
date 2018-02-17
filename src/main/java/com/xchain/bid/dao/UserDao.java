package com.xchain.bid.dao;

import org.springframework.data.repository.CrudRepository;
import com.xchain.bid.model.BidUser;

public interface UserDao extends CrudRepository<BidUser, Long>{

	BidUser findByName(String name);
	BidUser findByNameAndType(String name,String type);
}
