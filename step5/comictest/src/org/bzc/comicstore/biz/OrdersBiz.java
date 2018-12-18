package org.bzc.comicstore.biz;

import java.util.ArrayList;
import java.util.List;
import org.bzc.comicstore.beans.*;
import org.bzc.comicstore.db.*;

public class OrdersBiz {
	ControlDB controlDB = null;

	public OrdersBiz() {
		controlDB = new ControlDB();
	}

	public boolean delete(int id) {
		boolean flag = false;
		String sql = "delete from orders where id=" + id;
		try {
			controlDB.executeUpdate(sql);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public List searchById(int flag, int orderid) {
		String sql = "";
		List list = new ArrayList();
		if (flag == 0) {
			sql = "select * from orders order by orderid desc";
		} else if (flag == 1) {
			sql = "select * from orders where orderid=" + orderid + " order by orderid desc";
		}
		try {
			list = controlDB.executeQueryOrders(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public List searchByuserId(int flag, String userid) {
		String sql = "";
		List list = new ArrayList();
		if (flag == 0) {
			sql = "select * from orders order by userid desc";
		} else if (flag == 1) {
			sql = "select * from orders where userid='" + userid + "' order by userid desc";
		}
		try {
			list = controlDB.executeQueryOrders(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public List searchByitemId(int flag, String itemid) {
		String sql = "";
		List list = new ArrayList();
		if (flag == 0) {
			sql = "select * from orders order by itemid desc";
		} else if (flag == 1) {
			sql = "select * from orders where itemid='" + itemid + "' order by itemid desc";
		}
		try {
			list = controlDB.executeQueryOrders(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public List searchBysellerId(int flag, String sellerid) {
		String sql = "";
		List list = new ArrayList();
		if (flag == 0) {
			sql = "select * from orders order by sellerid desc";
		} else if (flag == 1) {
			sql = "select * from orders where sellerid='" + sellerid + "' order by sellerid desc";
		}
		try {
			list = controlDB.executeQueryOrders(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List searchBydate(int flag, String date) {
		String sql = "";
		List list = new ArrayList();
		if (flag == 0) {
			sql = "select * from orders order by orderdate desc";
		} else if (flag == 1) {
			sql = "select * from orders where orderdate='" + date + "' order by orderdate desc";
		}
		try {
			list = controlDB.executeQueryOrders(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean add(Orders orders) {
		String sql = "insert into orders(userid,orderdate,shipaddr1,shipaddr2,shipcity,shipstate,shipzip,shipcountry,billaddr1,billaddr2,billcity,billstate,billzip,billcountry,courier,totalprice,billtofirstname,billtolastname,shiptofirstname,shiptolastname,creditcard,exprdate,cardtype,sellerid,itemid,qty) values('"
				
				+ orders.getUserid()
				+ "','"
				+ orders.getOrderdate()
				+ "','"
				+ orders.getShipaddr1()
				+ "','"
				+ orders.getShipaddr2()
				+ "','"
				+ orders.getShipcity()
				+ "','"
				+ orders.getShipstate()
				+ "','"
				+ orders.getShipzip()
				+ "','"
				+ orders.getShipcountry()
				+ "','"
				+ orders.getBilladdr1()
				+ "','"
				+ orders.getBilladdr2()
				+ "','"
				+ orders.getBillcity()
				+ "','"
				+ orders.getBillstate()
				+ "','"
				+ orders.getBillzip()
				+ "','"
				+ orders.getBillcountry()
				+ "','"
				+ orders.getCourier()
				+ "','"
				+ orders.getTotalprice()
				+ "','"
				+ orders.getBilltofirstname()
				+ "','"
				+ orders.getBilltolastname()
				+ "','"
				+ orders.getShiptofirstname()
				+ "','"
				+ orders.getShiptolastname()
				+ "','"
				+ orders.getCreditcard()
				+ "','"
				+ orders.getExprdate()
				+ "','"
				+ orders.getCardtype()
				 +"','"+orders.getSellerid()+
				"','"+orders.getItemid()
				+ "','"
				+orders.getQty()+
				"')";
		boolean flag = false;
		try {
			controlDB.executeUpdate(sql);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean update(Orders orders) {
		String sql = "update orders set userid='" + orders.getUserid()
				+ "',orderdate='" + orders.getOrderdate() + "',shipaddr1='"
				+ orders.getShipaddr1() + "',shipaddr2='"
				+ orders.getShipaddr2() + "',shipcity='" + orders.getShipcity()
				+ "',shipstate='" + orders.getShipstate() + "',shipzip='"
				+ orders.getShipzip() + "',shipcountry='"
				+ orders.getShipcountry() + "',billaddr1='"
				+ orders.getBilladdr1() + "',billaddr2='"
				+ orders.getBilladdr2() + "',billcity='" + orders.getBillcity()
				+ "',billstate='" + orders.getBillstate() + "',billzip='"
				+ orders.getBillzip() + "',billcountry='"
				+ orders.getBillcountry() + "',courier='" + orders.getCourier()
				+ "',totalprice='" + orders.getTotalprice()
				+ "',billtofirstname='" + orders.getBilltofirstname()
				+ "',billtolastname='" + orders.getBilltolastname()
				+ "',shiptofirstname='" + orders.getShiptofirstname()
				+ "',shiptolastname='" + orders.getShiptolastname()
				+ "',creditcard='" + orders.getCreditcard() + "',exprdate='"
				+ orders.getExprdate() + "',cardtype='" + orders.getCardtype()
				 +"',sellerid='"+orders.getSellerid()+ "' where orderid='"
				+ orders.getOrderid() + "'";
		boolean flag = false;
		try {
			controlDB.executeUpdate(sql);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
