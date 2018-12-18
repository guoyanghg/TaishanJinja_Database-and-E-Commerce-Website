package org.bzc.comicstore.beans;

public class Orderstatus {
	private Integer orderid;

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public Integer getOrderid() {
		return orderid;
	}

	private Integer linenum;

	public void setLinenum(Integer linenum) {
		this.linenum = linenum;
	}

	public Integer getLinenum() {
		return linenum;
	}

	private String timestamp;

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getTimestamp() {
		return timestamp;
	}

	private String status;

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
}
