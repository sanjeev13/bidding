package com.xchain.bid.db.service;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.xchain.bid.config.RootConfig;
import com.xchain.bid.model.Catalog;
import com.xchain.bid.model.Bid;
import com.xchain.bid.model.BidUser;
import com.xchain.bid.service.BidService;
import com.xchain.bid.service.CatalogService;
import com.xchain.bid.service.UserService;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})

public class CatalogServiceTest {

	@Autowired
	CatalogService catalogService;
	@Autowired
	UserService userService;
	@Autowired
	BidService bidService;

	@Test
	public void testCreateDeleteCatalog(){
		String title = "unitTest11";
		BidUser creator = userService.getAllUsers().get(0); 
		Catalog catalog = new Catalog(title, new Date(), new Date(), creator);

		catalogService.save(catalog);
		Catalog readBack = catalogService.getCatalog(title);

		Assert.assertNotNull(readBack);
		Assert.assertEquals("Title doesn't match", readBack.getTitle(), catalog.getTitle());

		catalogService.delete(readBack.getId());
		readBack = catalogService.getCatalog(readBack.getId());

	//	Assert.assertNull(readBack);
	}

	@Test
	public void testGetAllCatalog(){
		String title = "unitTest12";
		Boolean exists = Boolean.FALSE;

		BidUser creator = userService.getAllUsers().get(0); 
		Catalog catalog = new Catalog(title, new Date(), new Date(), creator);

		catalogService.save(catalog);
		List<Catalog> readCatalogs = catalogService.getAllCatalogs();
		for(Catalog readCatalog : readCatalogs) {
			if(title.equals(readCatalog.getTitle())){
				exists = Boolean.TRUE;
			}
		}
		Assert.assertTrue("Test catalog doesn't exists in all catalog list", exists);
	}

	@Test
	public void testGetAllBids() {
		Boolean exists = Boolean.FALSE;

		BidUser creator = userService.getAllUsers().get(0); 
		Catalog catalog = catalogService.getAllCatalogs().get(0);

		Bid bid = new Bid(new Date(),(float) 1000, creator, catalog);
		bidService.save(bid);

		List<Bid> readBids = catalogService.getBids(catalog.getId());
		for(Bid readBid : readBids) {
			if(readBid.getId() == bid.getId()) {
				exists = Boolean.TRUE;
			}
		}
		Assert.assertTrue("Test bid for catalog doesn't exists bid list", exists);
	}

}