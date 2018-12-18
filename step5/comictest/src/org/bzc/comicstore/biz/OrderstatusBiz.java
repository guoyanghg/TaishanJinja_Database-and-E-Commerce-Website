package org.bzc.comicstore.biz;

import java.util.ArrayList;
import java.util.List;
import org.bzc.comicstore.beans.*;
import org.bzc.comicstore.db.*;

public class OrderstatusBiz {
	ControlDB controlDB = null;

	public OrderstatusBiz() {
		controlDB = new ControlDB();
	}

	public boolean delete(int id) {
		boolean flag = false;
		String sql = "delete from orderstatus where id=" + id;
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
			sql = "select * from orderstatus order by orderid desc";
		} else if (flag == 1) {
			sql = "select * from orderstatus where orderid=" + orderid
					+ " order by orderid desc";
		}
		try {
			list = controlDB.executeQueryOrderstatus(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean add(Orderstatus orderstatus) {
		String sql = "insert into orderstatus(orderid,linenum,timestamp,status) values('"
				+ orderstatus.getOrderid()
				+ "','"
				+ orderstatus.getLinenum()
				+ "','"
				+ orderstatus.getTimestamp()
				+ "','"
				+ orderstatus.getStatus() + "')";
		boolean flag = false;
		try {
			controlDB.executeUpdate(sql);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean update(Orderstatus orderstatus) {
		String sql = "update orderstatus set linenum='"
				+ orderstatus.getLinenum() + "',timestamp='"
				+ orderstatus.getTimestamp() + "',status='"
				+ orderstatus.getStatus() + "' where orderid='"
				+ orderstatus.getOrderid() + "'";
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
