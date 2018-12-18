package org.bzc.comicstore.biz;

import java.util.ArrayList;
import java.util.List;
import org.bzc.comicstore.beans.*;
import org.bzc.comicstore.db.*;

public class ProductBiz {
	ControlDB controlDB = null;

	public ProductBiz() {
		controlDB = new ControlDB();
	}

	public boolean delete(int id) {
		boolean flag = false;
		String sql = "delete from product where id=" + id;
		try {
			controlDB.executeUpdate(sql);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public List searchById(int flag, String productid) {
		String sql = "";
		List list = new ArrayList();
		if (flag == 0) {
			sql = "select * from product";
		} else if (flag == 1) {
			sql = "select * from product where productid='" + productid + "'";
		}
		try {
			list = controlDB.executeQueryProduct(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public List searchBycategoryId(String categoryId) {
		String sql = "";
		List list = new ArrayList();
		sql = "select * from product where category='" + categoryId + "'";
		try {
			list = controlDB.executeQueryProduct(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public boolean add(Product product) {
		String sql = "insert into product(productid,category,name) values('"
				+ product.getProductid()
				+ "','"
				+ product.getCategory()
				+ "','" + product.getName() + "')";
		boolean flag = false;
		try {
			controlDB.executeUpdate(sql);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean update(Product product) {
		String sql = "update product set category='" + product.getCategory()
				+ "',name='" + product.getName() + "' where id='" + product.getProductid()
				+ "'";
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
