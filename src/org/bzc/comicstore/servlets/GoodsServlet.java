package org.bzc.comicstore.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bzc.comicstore.beans.Inventory;
import org.bzc.comicstore.beans.Item;
import org.bzc.comicstore.beans.Product;
import org.bzc.comicstore.beans.Signon;
import org.bzc.comicstore.biz.InventoryBiz;
import org.bzc.comicstore.biz.ItemBiz;
import org.bzc.comicstore.utils.ConvertUtil;


public class GoodsServlet extends HttpServlet {

       

	public void init() throws ServletException {
	}

	public void destroy() {
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		String path = request.getParameter("path");
		HttpSession session = request.getSession();
		ConvertUtil cutils = new ConvertUtil();
		List<Item> listgoods = new ArrayList();
		ItemBiz itembiz = new ItemBiz();
		InventoryBiz iventorybiz= new InventoryBiz();
		List<Inventory> listinventory= new ArrayList();
		Signon signon=(Signon)session.getAttribute("user");
		String tourl = "";
		String error = "";
		if ("show".equals(path)) {
			
				try {
					System.out.println("in");
					listgoods = itembiz.searchBysupplier(signon.getUsername());
					for(int i=0;i<listgoods.size();i++){
						listinventory.add((Inventory) iventorybiz.searchById(1, listgoods.get(i).getItemid()).get(0));	
						System.out.println(listinventory.get(i).getQty());
					}
					session.setAttribute("goodList", listgoods);
					session.setAttribute("inventoryList", listinventory);
				} catch (Exception e) {
					e.printStackTrace();
				}
			
			tourl = "/account/MyGoods.jsp";
		} else {
			
			tourl = "index.html";
		}
		request.getRequestDispatcher(tourl).forward(request, response);
	}

}
