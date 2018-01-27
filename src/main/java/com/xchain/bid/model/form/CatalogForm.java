package com.xchain.bid.model.form;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections.FactoryUtils;
import org.apache.commons.collections.list.LazyList;
import org.springframework.format.annotation.DateTimeFormat;
import com.xchain.bid.model.Item;

public class CatalogForm {

	private String title;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date bidStart;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date bidEnd;
	private String creator;
	
	private List<Item> items = 
			LazyList.decorate(new ArrayList<Item>(),FactoryUtils.instantiateFactory(Item.class));
	
	public CatalogForm() {
	}
	
	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getBidStart() {
		return bidStart;
	}
	public void setBidStart(Date bidStart) {
		this.bidStart = bidStart;
	}
	public Date getBidEnd() {
		return bidEnd;
	}
	public void setBidEnd(Date bidEnd) {
		this.bidEnd = bidEnd;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
}
