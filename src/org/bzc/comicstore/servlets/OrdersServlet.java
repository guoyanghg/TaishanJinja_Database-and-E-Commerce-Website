package org.bzc.comicstore.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.bzc.comicstore.utils.*;
import org.bzc.comicstore.beans.*;
import org.bzc.comicstore.biz.*;

public class OrdersServlet extends HttpServlet {
	
	public void init() throws ServletException {
	}

	public void destroy() {
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String tourl = "/account/SignonForm.jsp";
		String path = request.getParameter("path");
		InventoryBiz inventorybiz=new InventoryBiz();
		HttpSession session = request.getSession();
		if("neworderform".equals(path)){
			Cart cart=(Cart) session.getAttribute("cart");
			Signon signon = (Signon) session.getAttribute("user");
			if (signon!=null) {
				String userid = signon.getUsername();
				AccountBiz accountBiz = new AccountBiz();
				List accountlist = accountBiz.searchById(1, userid);
				if(accountlist.size()>0){
					Account account = (Account)accountlist.get(0);
					session.setAttribute("account", account);
					tourl = "/order/NewOrderForm.jsp";
					System.out.println("in");
				}
				Iterator items = cart.getAllCartItems();//���ÿһ��item�ֱ��¶���
				while (items.hasNext()) {
					CartItem cartItem = (CartItem) items.next();
					Item item = cartItem.getItem();
					Inventory inventory=(Inventory) inventorybiz.searchById(1, item.getItemid()).get(0);
					if(inventory.getQty()<cartItem.getQuantity()){
						
						tourl = "/catalog/Main.jsp";
					}				
					
				}
			} else {
				tourl = "/account/SignonForm.jsp";
				
			}
		}else if("newOrder".equals(path)){
			Cart cart=(Cart) session.getAttribute("cart");//�õ����ﳵ�õ��ܼ�
			Signon signon=(Signon)session.getAttribute("user");
			OrdersBiz ordersbiz = new OrdersBiz();
			OrderstatusBiz orderstatusbiz = new OrderstatusBiz();
			Orders fakeorder=new Orders();
			fakeorder.setTotalprice(cart.getSubTotal().toString());			
			fakeorder.setUserid(new String(signon.getUsername().getBytes("iso-8859-1"),"utf-8"));
			fakeorder.setOrderdate(new java.sql.Date(new Date().getTime()));
			fakeorder.setBilladdr1(new String(request.getParameter("billAddress1").getBytes("iso-8859-1"),"utf-8"));
			fakeorder.setBilladdr2(new String(request.getParameter("billAddress2").getBytes("iso-8859-1"),"utf-8"));
			fakeorder.setBillcity(new String(request.getParameter("billCity").getBytes("iso-8859-1"),"utf-8"));
			fakeorder.setBillcountry(new String(request.getParameter("billCountry").getBytes("iso-8859-1"),"utf-8"));
			fakeorder.setBillstate(new String(request.getParameter("billState").getBytes("iso-8859-1"),"utf-8"));
			fakeorder.setBilltofirstname(new String(request.getParameter("billToFirstName").getBytes("iso-8859-1"),"utf-8"));
			fakeorder.setBilltolastname(new String(request.getParameter("billToLastName").getBytes("iso-8859-1"),"utf-8"));
			fakeorder.setBillzip(new String(request.getParameter("billZip").getBytes("iso-8859-1"),"utf-8"));
			
			//��ʼ���ö���״̬*/
			
			//os.setStatus("�ȴ��");
			//os.setTimestamp(order.getOrderdate().toString());
			//OrderstatusBiz osbiz= new OrderstatusBiz();
			//osbiz.add(os);
			Iterator items = cart.getAllCartItems();//���ÿһ��item�ֱ��¶���
			while (items.hasNext()) {
				CartItem cartItem = (CartItem) items.next();
				Item item = cartItem.getItem();
				Orders order=new Orders();
				Date date= new Date();
				Orderstatus os= new Orderstatus();
				order.setTotalprice(cart.getSubTotal().toString());
				order.setUserid(new String(signon.getUsername().getBytes("iso-8859-1"),"utf-8"));
				order.setOrderdate(new java.sql.Date(date.getTime()));
				order.setBilladdr1(new String(request.getParameter("billAddress1").getBytes("iso-8859-1"),"utf-8"));
				order.setBilladdr2(new String(request.getParameter("billAddress2").getBytes("iso-8859-1"),"utf-8"));
				order.setBillcity(new String(request.getParameter("billCity").getBytes("iso-8859-1"),"utf-8"));
				order.setBillcountry(new String(request.getParameter("billCountry").getBytes("iso-8859-1"),"utf-8"));
				order.setBillstate(new String(request.getParameter("billState").getBytes("iso-8859-1"),"utf-8"));
				order.setBilltofirstname(new String(request.getParameter("billToFirstName").getBytes("iso-8859-1"),"utf-8"));
				order.setBilltolastname(new String(request.getParameter("billToLastName").getBytes("iso-8859-1"),"utf-8"));
				order.setBillzip(new String(request.getParameter("billZip").getBytes("iso-8859-1"),"utf-8"));
				order.setShipaddr1(new String(request.getParameter("billAddress1").getBytes("iso-8859-1"),"utf-8"));
				order.setShipaddr2(new String(request.getParameter("billAddress2").getBytes("iso-8859-1"),"utf-8"));
				order.setShipcity(new String(request.getParameter("billCity").getBytes("iso-8859-1"),"utf-8"));
				order.setShipcountry(new String(request.getParameter("billCountry").getBytes("iso-8859-1"),"utf-8"));
				order.setShipstate(new String(request.getParameter("billState").getBytes("iso-8859-1"),"utf-8"));
				order.setShiptofirstname(new String(request.getParameter("billToFirstName").getBytes("iso-8859-1"),"utf-8"));
				order.setShiptolastname(new String(request.getParameter("billToLastName").getBytes("iso-8859-1"),"utf-8"));
				order.setShipzip(new String(request.getParameter("billZip").getBytes("iso-8859-1"),"utf-8"));
				order.setItemid(cartItem.getItem().getItemid());
				order.setSellerid(cartItem.getItem().getAccountid());
				order.setQty(cartItem.getQuantity());
				order.setCourier(request.getParameter("courier"));
				String paymethod=request.getParameter("paymethod");
				if(paymethod.equals("card")){
					order.setCardtype(request.getParameter("cardtype"));
					order.setCreditcard(request.getParameter("creditcard"));
				}
				java.text.DateFormat yyyy = new java.text.SimpleDateFormat("yyyy-MM-dd");
				order.setExprdate(new java.sql.Date(date.getTime()+14*24*60*60*1000));
				ordersbiz.add(order);
			    
				
		        int count=ordersbiz.searchById(0, 0).size()+1000000;//从1000001开始的订单
				os.setOrderid(count);
				os.setLinenum(count);
				os.setTimestamp(((Orders) (ordersbiz.searchBydate(1, yyyy.format(date)).get(0))).getOrderdate().toString());
				os.setStatus("NF");
				orderstatusbiz.add(os);		
				
				
				
			}
			
			session.setAttribute("order", fakeorder);
			tourl="/order/ViewOrder.jsp";
		}
		System.out.println(tourl);
		request.getRequestDispatcher(tourl).forward(request, response);
	}
}
