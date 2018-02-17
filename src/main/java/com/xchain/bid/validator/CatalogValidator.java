package com.xchain.bid.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xchain.bid.model.Catalog;
import com.xchain.bid.service.CatalogService;

@Service
public class CatalogValidator {

	@Autowired
	CatalogService catalogService;
	public boolean isValid(Long id) {
		Boolean valid = Boolean.FALSE;
		Catalog catalog = catalogService.getCatalog(id);
		if(catalog != null) {
			valid = Boolean.TRUE;
		}
		return valid.booleanValue();
	}
	
}
