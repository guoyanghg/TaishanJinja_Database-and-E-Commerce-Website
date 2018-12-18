package org.bzc.comicstore.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bzc.comicstore.beans.Inventory;
import org.bzc.comicstore.beans.Item;
import org.bzc.comicstore.beans.Product;
import org.bzc.comicstore.biz.InventoryBiz;
import org.bzc.comicstore.biz.ItemBiz;
import org.bzc.comicstore.biz.ProductBiz;
import org.bzc.comicstore.utils.Cart;
import org.bzc.comicstore.utils.CartItem;
import org.bzc.comicstore.utils.ConvertUtil;

public class ItemServlet extends HttpServlet {
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
		String path = request.getParameter("path");
		HttpSession session = request.getSession();
		ProductBiz productbiz = new ProductBiz();
		ConvertUtil cutils = new ConvertUtil();
		InventoryBiz ib=new InventoryBiz();
		List listItem = new ArrayList();
		ItemBiz itembiz = new ItemBiz();
		String tourl = "";
		String error = "";
		if ("show".equals(path)) {
			String itemid = request.getParameter("itemId");
			try {
				Item item = (Item) itembiz.searchById(1, itemid).get(0);
				System.out.println(item.getListprice()
						+ "((((((((((((((((((((((((");
				String productid=item.getProductid();
				Product product = (Product) productbiz.searchById(1, productid)
						.get(0);
			    Inventory inventory = (Inventory) ib.searchById(1, itemid)
						.get(0);
				session.setAttribute("item", item);
				session.setAttribute("product", product);
				session.setAttribute("inventory", inventory);
			} catch (Exception e) {
				e.printStackTrace();
			}
			tourl = "/catalog/Item.jsp";
		} else if ("addItemToCart".equals(path)) {
			
			String workingItemId = request.getParameter("itemId");
			Cart cart = null;
			CartItem cartitem = null;

			if (session.getAttribute("cartItems") == null) {
				cart = new Cart();
			} else {
				cart = (Cart) session.getAttribute("cart");
			}

			if (cart.containsItemId(workingItemId)) {
				cart.incrementQuantityByItemId(workingItemId);
			} else {
				Item item = (Item) itembiz.searchById(1, workingItemId).get(0);
				cart.addItem(item, true);
			}
			List cartItems = cart.getCartItemList();

			session.setAttribute("cartItems", cartItems);
			session.setAttribute("cart", cart);
			tourl = "/cart/Cart.jsp";
		} else if ("removeItemFromCart".equals(path)) {
			String workingItemId = request.getParameter("workingItemId");
			Cart cart = null;
			CartItem cartitem = null;
			// Ӧ���и�������Ϣҳ��ת
			if (session.getAttribute("cartItems") == null) {
				tourl = "/cart/Cart.jsp";
				request.getRequestDispatcher(tourl).forward(request, response);
			} else {
				cart = (Cart) session.getAttribute("cart");
			}

			if (cart.containsItemId(workingItemId)) {
				cart.removeItemById(workingItemId);

			} else {
				tourl = "/cart/Cart.jsp";
				request.getRequestDispatcher(tourl).forward(request, response);
			}
			List cartItems = cart.getCartItemList();

			session.setAttribute("cartItems", cartItems);
			session.setAttribute("cart", cart);

			tourl = "/cart/Cart.jsp";
		} else if ("updateCartQuantities".equals(path)) {
			Cart cart = null;
			CartItem cartitem = null;

			if (session.getAttribute("cartItems") == null) {
				tourl = "/cart/Cart.jsp";
				request.getRequestDispatcher(tourl).forward(request, response);
			} else {
				cart = (Cart) session.getAttribute("cart");
			}

			List<CartItem> cartItem = cart.getCartItemList();
			// ����һ��map������ҳ���ϴ���������ֵ
			Map<String, String> parameterMap = new HashMap<String, String>();
			for (int i = 0; i < cartItem.size(); i++) {
				String key = cartItem.get(i).getItem().getItemid();
				String value = request.getParameter("quantity" + key);
				System.out.println(value + "**********************");
				parameterMap.put(key, value);
			}
			// �����޸������ķ���
			cart.updateCartQuantities(parameterMap);
			//
			List<CartItem> cartItems = cart.getCartItemList();
			session.setAttribute("cartItems", cartItems);
			session.setAttribute("cart", cart);
			tourl = "/cart/Cart.jsp";
		} else if ("checkout".equals(path)) {
			tourl = "/cart/Checkout.jsp";
		} else if ("viewCart".equals(path)) {
			tourl = "/cart/Cart.jsp";
		} else {
			listItem = itembiz.searchById(0, "");
			tourl = "index.html";
			session.setAttribute("listItem", listItem);
		}
		request.getRequestDispatcher(tourl).forward(request, response);
	}
}
