package org.bzc.comicstore.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.bzc.comicstore.utils.*;
import org.bzc.comicstore.beans.*;
import org.bzc.comicstore.biz.*;
import org.bzc.comicstore.db.ControlDB;

public class OrderstatusServlet extends HttpServlet {
	ControlDB controlDB =null;
	public void init() throws ServletException {
		controlDB = new ControlDB();
	}

	public void destroy() {
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public boolean onOrderSuccess(Orders orders,boolean flag) {
		AccountBiz accountbiz= new AccountBiz();
		InventoryBiz ibiz= new InventoryBiz();
		Account seller=(Account) accountbiz.searchById(1, orders.getSellerid()).get(0);
		
		Account customer= (Account) accountbiz.searchById(1, orders.getUserid()).get(0);
		
		Inventory inv=(Inventory) ibiz.searchById(1, orders.getItemid()).get(0);
		seller.setBalance(seller.getBalance().add(new BigDecimal(orders.getTotalprice())));
		customer.setBalance(customer.getBalance().subtract(new BigDecimal(orders.getTotalprice())));
		inv.setQty(inv.getQty()-orders.getQty());
		
		
		if(flag==true){
		accountbiz.update(customer);
		accountbiz.update(seller);
		}
		ibiz.update(inv);
		
		return true;
		
	}



	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String path = request.getParameter("path");
		HttpSession session = request.getSession();
		Signon signon=(Signon) session.getAttribute("user");
		ConvertUtil cutils = new ConvertUtil();
		List<Orderstatus> listOrderstatus = new ArrayList();
		List<Orders> listOrdernumber = new ArrayList();
		OrderstatusBiz orderstatusbiz = new OrderstatusBiz();
		OrdersBiz ordersbiz = new OrdersBiz();
		String tourl = "";
		String error = "";
		if ("showmyorder".equals(path)) {
			listOrdernumber=ordersbiz.searchByuserId(1, signon.getUsername());
			System.out.println(listOrdernumber.size());
			for(int i=0;i<listOrdernumber.size();i++)
			{
				System.out.println(listOrdernumber.get(i).getOrderid());				
				if(orderstatusbiz.searchById(1, listOrdernumber.get(i).getOrderid()).size()>=1){
				Orderstatus s=(Orderstatus) orderstatusbiz.searchById(1, listOrdernumber.get(i).getOrderid()).get(0);
				listOrderstatus.add(i, s);
				}
			}
			session.setAttribute("listOrderstatus", listOrderstatus);
			tourl = "/account/MyOrder.jsp";
		} else if ("showmystoreorder".equals(path)) {
			listOrdernumber=ordersbiz.searchBysellerId(1, signon.getUsername());
			System.out.println(listOrdernumber.size());
			for(int i=0;i<listOrdernumber.size();i++)
			{
				System.out.println(listOrdernumber.get(i).getOrderid());				
				if(orderstatusbiz.searchById(1, listOrdernumber.get(i).getOrderid()).size()>=1){
				Orderstatus s=(Orderstatus) orderstatusbiz.searchById(1, listOrdernumber.get(i).getOrderid()).get(0);
				listOrderstatus.add(i, s);
				}
			}
			session.setAttribute("storelistOrderstatus", listOrderstatus);
			tourl = "/account/MyStoreOrder.jsp";
		}else if("updatetoyifahuo".equals(path)){
			
			String orderid = request.getParameter("orderid");

			Orderstatus os=(Orderstatus) orderstatusbiz.searchById(1, Integer.parseInt(orderid)).get(0);
			os.setStatus("YF");
			orderstatusbiz.update(os);
			tourl = "/account/MyAccount.jsp";
		}else if("updatetoyishouhuo".equals(path)){
			
			String orderid = request.getParameter("orderid");
			Orderstatus os=(Orderstatus) orderstatusbiz.searchById(1, Integer.parseInt(orderid)).get(0);
			os.setStatus("OK");
			orderstatusbiz.update(os);
			//Ȼ��������б�
			Orders o = (Orders) ordersbiz.searchById(1, Integer.parseInt(orderid)).get(0);
			System.out.println(o.getTotalprice());
			if(o.getCardtype().equals("null")){
			this.onOrderSuccess(o,true);
			 AccountBiz ab= new AccountBiz();
			 Account a=(Account) ab.searchById(1, signon.getUsername()).get(0);
			 session.setAttribute("account", a);
			}else{
			this.onOrderSuccess(o,false);	
			}
			tourl = "/account/MyAccount.jsp";
		}
		request.getRequestDispatcher(tourl).forward(request, response);
	}
}
