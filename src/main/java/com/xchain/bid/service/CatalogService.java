package com.xchain.bid.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xchain.bid.dao.BidDao;
import com.xchain.bid.dao.CatalogDao;
import com.xchain.bid.dao.ItemDao;
import com.xchain.bid.dao.UserDao;
import com.xchain.bid.model.Bid;
import com.xchain.bid.model.Catalog;
import com.xchain.bid.model.Item;
import com.xchain.bid.model.User;
import com.xchain.bid.model.form.CatalogForm;

@Service
public class CatalogService {

	@Autowired
	UserDao userDao;
	@Autowired
	CatalogDao catalogDao;
	@Autowired
	ItemDao itemDao;
	@Autowired
	BidDao bidDao;

	public void save(CatalogForm catalogForm) {

		User creator = userDao.findByName(catalogForm.getCreator());
		Catalog catalog = new Catalog(catalogForm.getTitle(), catalogForm.getBidStart(),
				catalogForm.getBidEnd(), creator);
		catalogDao.save(catalog);

		Set<Item> curItems = new HashSet<Item>();
		for(Item item : catalogForm.getItems()) {
			item.setCatalog(catalog);
			item.setActive(Boolean.TRUE);
			itemDao.save(item);
		}
		catalog.setItems(curItems);
		catalog.setActive(Boolean.TRUE);
		catalogDao.save(catalog);
	}

	public List<Catalog> getAllCatalogs() {
		List<Catalog> catalogs = new ArrayList<Catalog>();
		for(Catalog c : catalogDao.findAll()) {
			catalogs.add(c);
		}
		return catalogs;
	}

	public List<String> getCatalogsDisplayList() {
		List<String> catalogList = new ArrayList<>();
		for(Catalog c : getAllCatalogs()) {
			catalogList.add(c.getTitle());
		}
		return catalogList;
	}

	public List<Bid> getBids(Long catalogId) {
		List<Bid> bids = new ArrayList<>();
		Catalog catalog = catalogDao.findOne(catalogId);
		if(catalog != null) {
			bids = bidDao.findByCatalog(catalog);
		} 
		Collections.sort(bids, (b1, b2) -> Float.compare(b2.getAmount(), b1.getAmount()));
		return bids;
	}

}
