package org.bzc.comicstore.beans;

public class Inventory {
	private String itemid;

	public void setItemid(String itemid) {
		this.itemid = itemid;
	}

	public String getItemid() {
		return itemid;
	}

	private Integer qty;

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public Integer getQty() {
		return qty;
	}
}
