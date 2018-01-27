package com.xchain.bid.dao;

import org.springframework.data.repository.CrudRepository;
import com.xchain.bid.model.User;

public interface UserDao extends CrudRepository<User, Long>{

	User findByName(String name);

}
