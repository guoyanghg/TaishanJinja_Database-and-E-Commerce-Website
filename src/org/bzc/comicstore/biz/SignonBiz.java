package org.bzc.comicstore.biz;

import java.util.ArrayList;
import java.util.List;
import org.bzc.comicstore.beans.*;
import org.bzc.comicstore.db.*;

public class SignonBiz {
	ControlDB controlDB = null;

	public SignonBiz() {
		controlDB = new ControlDB();
	}

	public boolean delete(int id) {
		boolean flag = false;
		String sql = "delete from signon where id=" + id;
		try {
			controlDB.executeUpdate(sql);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public List searchById(int flag, int id) {
		String sql = "";
		List list = new ArrayList();
		if (flag == 0) {
			sql = "select * from signon";
		} else if (flag == 1) {
			sql = "select * from signon where id=" + id + "";
		}
		try {
			list = controlDB.executeQuerySignon(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean add(Signon signon) {
		String sql = "insert into signon(username,password) values('"
				+ signon.getUsername() + "','" + signon.getPassword() + "')";
		boolean flag = false;
		try {
			controlDB.executeUpdate(sql);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean update(Signon signon) {
		String sql = "update signon set password='" + signon.getPassword()
				+ "' where id='" + signon.getUsername() + "'";
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
