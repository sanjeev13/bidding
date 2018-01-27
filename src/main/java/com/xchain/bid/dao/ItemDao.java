package com.xchain.bid.dao;

import org.springframework.data.repository.CrudRepository;
import com.xchain.bid.model.Item;

public interface ItemDao extends CrudRepository<Item,Long>{

}
