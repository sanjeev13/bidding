package com.xchain.bid.model.form;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections.FactoryUtils;
import org.apache.commons.collections.list.LazyList;

import com.xchain.bid.model.Item;

public class DynamicItemsForm {

	List<Item> dynamicRow = 
			LazyList.decorate(new ArrayList<Item>(), FactoryUtils.instantiateFactory(Item.class));
	public DynamicItemsForm() {

	}

	public List<Item> getDynamicRow() {
		return dynamicRow;
	}

	public void setDynamicRow(List<Item> dynamicRow) {
		this.dynamicRow = dynamicRow;
	}
	
}