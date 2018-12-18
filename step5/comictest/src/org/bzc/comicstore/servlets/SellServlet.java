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

import org.bzc.comicstore.beans.Inventory;
import org.bzc.comicstore.beans.Item;
import org.bzc.comicstore.beans.Profile;
import org.bzc.comicstore.beans.Signon;
import org.bzc.comicstore.biz.InventoryBiz;
import org.bzc.comicstore.biz.ItemBiz;
import org.bzc.comicstore.biz.ProfileBiz;
import org.bzc.comicstore.utils.ConvertUtil;

public class SellServlet extends HttpServlet {
	public static int id=10000;
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
		    //�����ȡ�?��Ϣ  Ȼ��д����ݿ�
		     response.setContentType("text/html;charset=utf-8");
		    HttpSession session = request.getSession();
		    Signon signon=(Signon)session.getAttribute("user");
		    String catagory=request.getParameter("category");
		    String product=request.getParameter("product");
		    BigDecimal listprice=new BigDecimal(request.getParameter("listprice"));
		    String attr1=request.getParameter("attribute1");
		    String attr2=request.getParameter("attribute2");
		    String attr3=request.getParameter("attribute3");
		    String attr4=request.getParameter("attribute4");
		    String attr5=request.getParameter("attribute5");
		    attr1=new String(attr1.getBytes("iso-8859-1"),"utf-8");
		    attr2=new String(attr2.getBytes("iso-8859-1"),"utf-8");
		    attr3=new String(attr3.getBytes("iso-8859-1"),"utf-8");
		    attr4=new String(attr4.getBytes("iso-8859-1"),"utf-8");
		    attr5=new String(attr5.getBytes("iso-8859-1"),"utf-8");
		    int quantity=Integer.parseInt(request.getParameter("quantity"));
		    String status=request.getParameter("status");
		    String itemid;
		    if(product.charAt(4)=='0'){
		    	
		    	itemid=product.substring(5);	    	
		    	
		    }else{
		    	
		    	itemid=product.substring(4);
		    }
		    itemid=itemid+"-";
		    ItemBiz itembiz= new ItemBiz();
		    int count=itembiz.searchByproductId(product).size();
		    String ct=Integer.toString(count);
		    itemid=itemid+"00"+ct;
		    Item item = new Item();
		    Inventory inventory= new Inventory(); 
		    item.setAccountid(signon.getUsername());
		    item.setAttr1(attr1);
		    item.setAttr2(attr2);
		    item.setAttr3(attr3);
		    item.setAttr4(attr4);
		    item.setAttr5(attr5);
		    item.setListprice(listprice);
		    item.setProductid(product);
		    item.setStatus(status);
		    item.setItemid(itemid);
		    inventory.setItemid(itemid);  //��ǰ��ӹ̶��� itemidҪ��
		    inventory.setQty(quantity);
		    InventoryBiz inventorybiz= new InventoryBiz();
		    itembiz.add(item);
		    inventorybiz.add(inventory);
		    String tourl = "/account/MyAccount.jsp";
		    request.getRequestDispatcher(tourl).forward(request, response);
	}
}
