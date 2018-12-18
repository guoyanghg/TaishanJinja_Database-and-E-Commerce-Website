package org.bzc.comicstore.biz;

import java.util.ArrayList;
import java.util.List;
import org.bzc.comicstore.beans.*;
import org.bzc.comicstore.db.*;

public class CategoryBiz {
	ControlDB controlDB = null;

	public CategoryBiz() {
		controlDB = new ControlDB();
	}

	public boolean delete(int id) {
		boolean flag = false;
		String sql = "delete from category where id=" + id;
		try {
			controlDB.executeUpdate(sql);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public List searchById(int flag, String catid) {
		String sql = "";
		List list = new ArrayList();
		if (flag == 0) {
			sql = "select * from category";
		} else if (flag == 1) {
			sql = "select * from category where catid='" + catid + "'";
		}
		System.out.println(sql);
		try {
			list = controlDB.executeQueryCategory(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean add(Category category) {
		String sql = "insert into category(catid,name) values('"
				+ category.getCatid() + "','" + category.getName()  + "')";
		boolean flag = false;
		try {
			controlDB.executeUpdate(sql);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean update(Category category) {
		String sql = "update category set name='" + category.getName()
				 + "' where id='"
				+ category.getCatid() + "'";
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
