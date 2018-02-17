package com.xchain.bid.dao;

import org.springframework.data.repository.CrudRepository;
import com.xchain.bid.model.Catalog;

public interface CatalogDao extends CrudRepository<Catalog,Long>{

	Catalog findByTitle(String catalog);

}