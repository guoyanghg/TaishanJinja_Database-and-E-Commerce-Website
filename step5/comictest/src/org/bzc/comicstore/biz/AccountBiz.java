package org.bzc.comicstore.biz;

import java.util.ArrayList;
import java.util.List;
import org.bzc.comicstore.beans.*;
import org.bzc.comicstore.db.*;

public class AccountBiz {
	ControlDB controlDB = null;

	public AccountBiz() {
		controlDB = new ControlDB();
	}

	public boolean delete(int id) {
		boolean flag = false;
		String sql = "delete from account where id=" + id;
		try {
			controlDB.executeUpdate(sql);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public List searchById(int flag, String userid) {
		String sql = "";
		List list = new ArrayList();
		if (flag == 0) {
			sql = "select * from account";
		} else if (flag == 1) {
			sql = "select * from account where userid='" + userid + "'";
		}
		try {
			list = controlDB.executeQueryAccount(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean add(Account account) {
		String sql = "insert into account(userid,email,firstname,lastname,status,addr1,addr2,city,state,zip,country,phone,balance) values('"
				+ account.getUserid()
				+ "','"
				+ account.getEmail()
				+ "','"
				+ account.getFirstname()
				+ "','"
				+ account.getLastname()
				+ "','"
				+ account.getStatus()
				+ "','"
				+ account.getAddr1()
				+ "','"
				+ account.getAddr2()
				+ "','"
				+ account.getCity()
				+ "','"
				+ account.getState()
				+ "','"
				+ account.getZip()
				+ "','"
				+ account.getCountry() + "','" + account.getPhone()+"','" + account.getBalance() + "')";
		boolean flag = false;
		try {
			controlDB.executeUpdate(sql);
			System.out.println("ִ��ע��sql");
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean update(Account account) {
		String sql = "update account set email='" + account.getEmail()
				+ "',firstname='" + account.getFirstname() + "',lastname='"
				+ account.getLastname() + "',status='" + account.getStatus()
				+ "',addr1='" + account.getAddr1() + "',addr2='"
				+ account.getAddr2() + "',city='" + account.getCity()
				+ "',state='" + account.getState() + "',zip='"
				+ account.getZip() + "',country='" + account.getCountry()
				+ "',phone='" + account.getPhone() +"',balance='" + account.getBalance() + "' where userid='"
				+ account.getUserid() + "'";
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
