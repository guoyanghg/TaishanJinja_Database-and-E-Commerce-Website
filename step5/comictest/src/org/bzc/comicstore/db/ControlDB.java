package org.bzc.comicstore.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.bzc.comicstore.beans.*;

public class ControlDB {

	public List executeQueryAccount(String sql) throws Exception {
		ResultSet rs = null;
		List list = new ArrayList();
		Connection con = null;
		Statement stmt = null;
		try {
			con = ConnectionFactory.getConnection();
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Account account = new Account();
				int i = 1;
				account.setUserid(rs.getString(i++));
				account.setEmail(rs.getString(i++));
				account.setFirstname(rs.getString(i++));
				account.setLastname(rs.getString(i++));
				account.setStatus(rs.getString(i++));
				account.setAddr1(rs.getString(i++));
				account.setAddr2(rs.getString(i++));
				account.setCity(rs.getString(i++));
				account.setState(rs.getString(i++));
				account.setZip(rs.getString(i++));
				account.setCountry(rs.getString(i++));
				account.setPhone(rs.getString(i++));
				account.setBalance(rs.getBigDecimal(i++));
				list.add(account);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseUtils.closeObject(rs, stmt, con);
		}
		return list;
	}

	public List executeQueryBannerdata(String sql) throws Exception {
		ResultSet rs = null;
		List list = new ArrayList();
		Connection con = null;
		Statement stmt = null;
		try {
			con = ConnectionFactory.getConnection();
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Bannerdata bannerdata = new Bannerdata();
				int i = 1;
				bannerdata.setFavcategory(rs.getString(i++));
				bannerdata.setBannername(rs.getString(i++));
				list.add(bannerdata);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseUtils.closeObject(rs, stmt, con);
		}
		return list;
	}

	public List executeQueryCategory(String sql) throws Exception {
		ResultSet rs = null;
		List list = new ArrayList();
		Connection con = null;
		Statement stmt = null;
		try {
			con = ConnectionFactory.getConnection();
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Category category = new Category();
				int i = 1;
				category.setCatid(rs.getString(i++));
				category.setName(rs.getString(i++));
				list.add(category);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseUtils.closeObject(rs, stmt, con);
		}
		return list;
	}

	public List executeQueryInventory(String sql) throws Exception {
		ResultSet rs = null;
		List list = new ArrayList();
		Connection con = null;
		Statement stmt = null;
		try {
			con = ConnectionFactory.getConnection();
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Inventory inventory = new Inventory();
				int i = 1;
				inventory.setItemid(rs.getString(i++));
				inventory.setQty(rs.getInt(i++));
				list.add(inventory);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseUtils.closeObject(rs, stmt, con);
		}
		return list;
	}

	public List executeQueryItem(String sql) throws Exception {
		ResultSet rs = null;
		List list = new ArrayList();
		Connection con = null;
		Statement stmt = null;
		try {
			con = ConnectionFactory.getConnection();
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Item item = new Item();
				int i = 1;
				item.setItemid(rs.getString(i++));
				item.setProductid(rs.getString(i++));
				item.setListprice(rs.getBigDecimal(i++));
				item.setAccountid(rs.getString(i++));
				item.setStatus(rs.getString(i++));
				item.setAttr1(rs.getString(i++));
				item.setAttr2(rs.getString(i++));
				item.setAttr3(rs.getString(i++));
				item.setAttr4(rs.getString(i++));
				item.setAttr5(rs.getString(i++));
				list.add(item);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseUtils.closeObject(rs, stmt, con);
		}
		return list;
	}

	public List executeQueryLineitem(String sql) throws Exception {
		ResultSet rs = null;
		List list = new ArrayList();
		Connection con = null;
		Statement stmt = null;
		try {
			con = ConnectionFactory.getConnection();
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Lineitem lineitem = new Lineitem();
				int i = 1;
				lineitem.setOrderid(rs.getInt(i++));
				lineitem.setLinenum(rs.getInt(i++));
				lineitem.setItemid(rs.getString(i++));
				lineitem.setQuantity(rs.getInt(i++));
				lineitem.setUnitprice(rs.getString(i++));
				list.add(lineitem);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseUtils.closeObject(rs, stmt, con);
		}
		return list;
	}

	public List executeQueryOrders(String sql) throws Exception {
		ResultSet rs = null;
		List list = new ArrayList();
		Connection con = null;
		Statement stmt = null;
		try {
			con = ConnectionFactory.getConnection();
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Orders orders = new Orders();
				int i = 1;
				orders.setOrderid(rs.getInt(i++));
				orders.setUserid(rs.getString(i++));
				orders.setOrderdate(rs.getDate(i++));
				orders.setShipaddr1(rs.getString(i++));
				orders.setShipaddr2(rs.getString(i++));
				orders.setShipcity(rs.getString(i++));
				orders.setShipstate(rs.getString(i++));
				orders.setShipzip(rs.getString(i++));
				orders.setShipcountry(rs.getString(i++));
				orders.setTotalprice(rs.getString(i++));
				orders.setShiptofirstname(rs.getString(i++));
				orders.setShiptolastname(rs.getString(i++));
				orders.setBilladdr1(rs.getString(i++));
				orders.setBilladdr2(rs.getString(i++));
				orders.setBillcity(rs.getString(i++));
				orders.setBillstate(rs.getString(i++));
				orders.setBillzip(rs.getString(i++));
				orders.setBillcountry(rs.getString(i++));
				orders.setCourier(rs.getString(i++));
				orders.setBilltofirstname(rs.getString(i++));
				orders.setBilltolastname(rs.getString(i++));
				orders.setCreditcard(rs.getString(i++));
				orders.setExprdate(rs.getDate(i++));
				orders.setCardtype(rs.getString(i++));
				orders.setSellerid(rs.getString(i++));
				orders.setItemid(rs.getString(i++));
				orders.setQty(rs.getInt(i++));
				list.add(orders);
				
			}
		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseUtils.closeObject(rs, stmt, con);
		}
		return list;
	}

	public List executeQueryOrderstatus(String sql) throws Exception {
		ResultSet rs = null;
		List list = new ArrayList();
		Connection con = null;
		Statement stmt = null;
		try {
			con = ConnectionFactory.getConnection();
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Orderstatus orderstatus = new Orderstatus();
				int i = 1;
				orderstatus.setOrderid(rs.getInt(i++));
				orderstatus.setLinenum(rs.getInt(i++));
				orderstatus.setTimestamp(rs.getString(i++));
				orderstatus.setStatus(rs.getString(i++));
				list.add(orderstatus);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseUtils.closeObject(rs, stmt, con);
		}
		return list;
	}

	public List executeQueryProduct(String sql) throws Exception {
		ResultSet rs = null;
		List list = new ArrayList();
		Connection con = null;
		Statement stmt = null;
		try {
			con = ConnectionFactory.getConnection();
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Product product = new Product();
				int i = 1;
				product.setProductid(rs.getString(i++));
				product.setCategory(rs.getString(i++));
				product.setName(rs.getString(i++));
				list.add(product);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseUtils.closeObject(rs, stmt, con);
		}
		return list;
	}

	public List executeQueryProfile(String sql) throws Exception {
		ResultSet rs = null;
		List list = new ArrayList();
		Connection con = null;
		Statement stmt = null;
		try {
			con = ConnectionFactory.getConnection();
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Profile profile = new Profile();
				int i = 1;
				profile.setUserid(rs.getString(i++));
				profile.setLangpref(rs.getString(i++));
				profile.setFavcategory(rs.getString(i++));
				profile.setMylistopt(rs.getString(i++));
				profile.setBanneropt(rs.getString(i++));
				list.add(profile);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseUtils.closeObject(rs, stmt, con);
		}
		return list;
	}

	public List executeQuerySequence(String sql) throws Exception {
		ResultSet rs = null;
		List list = new ArrayList();
		Connection con = null;
		Statement stmt = null;
		try {
			con = ConnectionFactory.getConnection();
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Sequence sequence = new Sequence();
				int i = 1;
				sequence.setName(rs.getString(i++));
				sequence.setNextid(rs.getInt(i++));
				list.add(sequence);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseUtils.closeObject(rs, stmt, con);
		}
		return list;
	}

	public List executeQuerySignon(String sql) throws Exception {
		ResultSet rs = null;
		List list = new ArrayList();
		Connection con = null;
		Statement stmt = null;
		try {
			con = ConnectionFactory.getConnection();
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Signon signon = new Signon();
				int i = 1;
				signon.setUsername(rs.getString(i++));
				signon.setPassword(rs.getString(i++));
				list.add(signon);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseUtils.closeObject(rs, stmt, con);
		}
		return list;
	}

	public List executeQueryComment(String sql) throws Exception {
		ResultSet rs = null;
		List list = new ArrayList();
		Connection con = null;
		Statement stmt = null;
		try {
			con = ConnectionFactory.getConnection();
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Comment comment = new Comment();
				int i = 1;
				comment.setItemid(rs.getString(i++));
				comment.setUserid(rs.getString(i++));
				comment.setRating(rs.getBigDecimal(i++));
				comment.setContent(rs.getString(i++));
				comment.setDate(rs.getDate(i++));
				comment.setOrderid(rs.getInt(i++));
				list.add(comment);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseUtils.closeObject(rs, stmt, con);
		}
		return list;
	}

	public void executeUpdate(String sql) throws Exception {
		Connection con = null;
		Statement stmt = null;
		try {
			con = ConnectionFactory.getConnection();
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DatabaseUtils.closeObject(stmt, con);
		}
	}
}
