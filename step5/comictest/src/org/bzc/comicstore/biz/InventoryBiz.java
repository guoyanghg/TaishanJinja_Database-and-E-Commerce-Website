package org.bzc.comicstore.biz;

import java.util.ArrayList;
import java.util.List;
import org.bzc.comicstore.beans.*;
import org.bzc.comicstore.db.*;

public class InventoryBiz {
	ControlDB controlDB = null;

	public InventoryBiz() {
		controlDB = new ControlDB();
	}

	public boolean delete(int id) {
		boolean flag = false;
		String sql = "delete from inventory where id=" + id;
		try {
			controlDB.executeUpdate(sql);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public List searchById(int flag, String itemid) {
		String sql = "";
		List list = new ArrayList();
		if (flag == 0) {
			sql = "select * from inventory order by itemid desc";
		} else if (flag == 1) {
			sql = "select * from inventory where itemid='" + itemid
					+ "' order by itemid desc";
		}
		try {
			list = controlDB.executeQueryInventory(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean add(Inventory inventory) {
		String sql = "insert into inventory(itemid,qty) values('"
				+ inventory.getItemid() + "','" + inventory.getQty() + "')";
		boolean flag = false;
		try {
			controlDB.executeUpdate(sql);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean update(Inventory inventory) {
		String sql = "update inventory set qty='" + inventory.getQty()
				+ "' where itemid='" + inventory.getItemid() + "'";
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
