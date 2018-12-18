package org.bzc.comicstore.biz;

import java.util.ArrayList;
import java.util.List;

import org.bzc.comicstore.beans.Category;
import org.bzc.comicstore.beans.Comment;
import org.bzc.comicstore.db.ControlDB;

public class CommentBiz {
	ControlDB controlDB = null;

	public CommentBiz() {
		controlDB = new ControlDB();
	}

	public boolean delete(int id) {
		boolean flag = false;
		String sql = "delete from item where id=" + id;
		try {
			controlDB.executeUpdate(sql);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public List searchByitemId(int flag, String itemId) {
		String sql = "";
		List list = new ArrayList();
		if (flag == 0) {
			sql = "select * from comment";
		} else if (flag == 1) {
			sql = "select * from comment where itemid='" + itemId
					+ "'";
		}
		try {
			list = controlDB.executeQueryComment(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public boolean add(Comment comment) {
		String sql = "insert into comment(itemid,userid,rating,content,date,orderid) values('"
				+ comment.getItemid() + "','" + comment.getUserid() + "','"
				+ comment.getRating() + "','"+comment.getContent()+"','"+comment.getDate()+"','"+comment.getOrderid()
						 + "')";
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
