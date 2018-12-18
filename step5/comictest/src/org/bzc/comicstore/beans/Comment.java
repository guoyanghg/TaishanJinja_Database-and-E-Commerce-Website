package org.bzc.comicstore.beans;

import java.math.BigDecimal;

public class Comment {
	String itemid;
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}

	public String getItemid() {
		return itemid;
	}
	String userid;
	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserid() {
		return userid;
	}
	BigDecimal rating;
	public void setRating(BigDecimal rating) {
		this.rating = rating;
	}

	public BigDecimal getRating() {
		return rating;
	}
	String content;
	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}
	java.sql.Date date;
	public void setDate(java.sql.Date date) {
		this.date = date;
	}

	public java.sql.Date getDate() {
		return date;
	}
	int orderid;
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getOrderid(){
		return orderid;
	}
	

}
