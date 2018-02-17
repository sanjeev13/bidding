package com.xchain.bid.dao;

import org.springframework.data.repository.CrudRepository;
import com.xchain.bid.model.AppUser;

public interface AppUserDao extends CrudRepository<AppUser, Long> {

	AppUser findBySsoId(String ssoId);

}