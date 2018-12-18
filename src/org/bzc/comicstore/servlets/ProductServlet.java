package org.bzc.comicstore.servlets;

import java.io.IOException;
import java.io.PrintWriter;
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

public class ProductServlet extends HttpServlet {
	public void init() throws ServletException {
	}

	public void destroy() {
	}
	
	public int countzongxiaoliang(String itemid){
		int count=0;
		OrdersBiz ordersbiz= new OrdersBiz();
		OrderstatusBiz orderstatusbiz=new OrderstatusBiz();
		List<Orders> olist= new ArrayList();
		olist=ordersbiz.searchByitemId(1, itemid);
		for(int i=0;i<olist.size();i++){
			Orderstatus temp=(Orderstatus) orderstatusbiz.searchById(1, olist.get(i).getOrderid()).get(0);
			if(temp.getStatus().equals("OK")){
				count=count+olist.get(i).getQty();
			}
		}
		return count;				
	}
	public int countyearxiaoliang(String itemid,String year){
		int count=0;
		OrdersBiz ordersbiz= new OrdersBiz();
		OrderstatusBiz orderstatusbiz=new OrderstatusBiz();
		List<Orders> olist= new ArrayList();
		olist=ordersbiz.searchByitemId(1, itemid);
		for(int i=0;i<olist.size();i++){
			Orderstatus temp=(Orderstatus) orderstatusbiz.searchById(1, olist.get(i).getOrderid()).get(0);

			if(temp.getStatus().equals("OK")&&temp.getTimestamp().substring(0, 4).equals(year)){
				count=count+olist.get(i).getQty();
			}
		}
		return count;				
	}
	public int countmonthxiaoliang(String itemid,String year,String month){
		int count=0;
		OrdersBiz ordersbiz= new OrdersBiz();
		OrderstatusBiz orderstatusbiz=new OrderstatusBiz();
		List<Orders> olist= new ArrayList();
		olist=ordersbiz.searchByitemId(1, itemid);
		
		for(int i=0;i<olist.size();i++){
			Orderstatus temp=(Orderstatus) orderstatusbiz.searchById(1, olist.get(i).getOrderid()).get(0);
			
			if(temp.getStatus().equals("OK")&&temp.getTimestamp().substring(5, 7).equals(month)&&temp.getTimestamp().substring(0, 4).equals(year)){
				count=count+olist.get(i).getQty();
			}
		}
		return count;				
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String path = request.getParameter("path");
		HttpSession session = request.getSession();
		List listProduct = new ArrayList();
		ProductBiz productbiz = new ProductBiz();
		ItemBiz itembiz = new ItemBiz();
		String tourl = "";
		if ("show".equals(path)) {
			String productId = request.getParameter("productId");
			try {
				List<Item> itemList = itembiz.searchByproductId(productId);
				Product product = (Product) productbiz.searchById(1, productId)
						.get(0);

		
				session.setAttribute("itemList", itemList);
				session.setAttribute("product", product);
			} catch (Exception e) {
				e.printStackTrace();
			}
			tourl = "/catalog/Product.jsp";
		}else if("search".equals(path)){
			try {
			String keyword=request.getParameter("keyword");
			keyword=new String(keyword.getBytes("iso-8859-1"),"utf-8");
			System.out.println(keyword);
			List<Item> itemList = itembiz.searchByKeyword(keyword);//����ĳɰ��չؼ���ƥ��
			System.out.println(itemList.get(0).getAttr5());
			
			
			session.setAttribute("itemList", itemList);
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			tourl = "/catalog/ProductforSearch.jsp";
		}
		 else if("searchmonth".equals(path)){
			    List<Item> itemList = (List<Item>) session.getAttribute("itemList");//����ĳɰ��չؼ���ƥ��
				String year=(String) session.getAttribute("year");
				if(year==null){
        	    	year="2015";
        	    }
				String month=request.getParameter("month");
				int count[]= new int[itemList.size()];
				for(int i=0;i<count.length;i++){
					count[i]=this.countmonthxiaoliang(itemList.get(i).getItemid(),year,month);
				}
				
				for(int i=0;i<count.length-1;i++){
					                          for(int j=i+1;j<count.length;j++){
					                                  if (count[i]<count[j]){
					                                         int temp=count[i];
					                                         count[i]=count[j];
					                                         count[j]=temp;
					                                         Item temp2=itemList.get(i);
					                                         itemList.set(i, itemList.get(j));
					                                         itemList.set(j, temp2);
					                                 }
					                          }
					                }
																		
				session.setAttribute("itemList", itemList);
				tourl = "/catalog/ProductforSearch.jsp";
		}
         else if("searchyear".equals(path)){
        	    List<Item> itemList = (List<Item>) session.getAttribute("itemList");//����ĳɰ��չؼ���ƥ��
				String year = request.getParameter("year");
				session.setAttribute("year", year);
				int count[]= new int[itemList.size()];
				for(int i=0;i<count.length;i++){
					count[i]=this.countyearxiaoliang(itemList.get(i).getItemid(),year);
				}
				
				for(int i=0;i<count.length-1;i++){
					                          for(int j=i+1;j<count.length;j++){
					                                  if (count[i]<count[j]){
					                                         int temp=count[i];
					                                         count[i]=count[j];
					                                         count[j]=temp;
					                                         Item temp2=itemList.get(i);
					                                         itemList.set(i, itemList.get(j));
					                                         itemList.set(j, temp2);
					                                 }
					                          }
					                }
																		
				session.setAttribute("itemList", itemList);
				tourl = "/catalog/ProductforSearch.jsp";
			
		}
         else if("year".equals(path)){
        	    List<Item> itemList = (List<Item>) session.getAttribute("itemList");//����ĳɰ��չؼ���ƥ��
        	    String year = request.getParameter("year");
				session.setAttribute("year", year);
				int count[]= new int[itemList.size()];
				for(int i=0;i<count.length;i++){
					count[i]=this.countyearxiaoliang(itemList.get(i).getItemid(),year);
				}
				
				for(int i=0;i<count.length-1;i++){
					                          for(int j=i+1;j<count.length;j++){
					                                  if (count[i]<count[j]){
					                                         int temp=count[i];
					                                         count[i]=count[j];
					                                         count[j]=temp;
					                                         Item temp2=itemList.get(i);
					                                         itemList.set(i, itemList.get(j));
					                                         itemList.set(j, temp2);
					                                 }
					                          }
					                }
																		
				session.setAttribute("itemList", itemList);
				tourl = "/catalog/Product.jsp";
        }
         else if("month".equals(path)){
        	    List<Item> itemList = (List<Item>) session.getAttribute("itemList");//����ĳɰ��չؼ���ƥ��
        	    String year=(String) session.getAttribute("year");
        	    if(year==null){
        	    	year="2015";
        	    }
				String month=request.getParameter("month");
				int count[]= new int[itemList.size()];
				for(int i=0;i<count.length;i++){
					count[i]=this.countmonthxiaoliang(itemList.get(i).getItemid(),year,month);
				}
				
				for(int i=0;i<count.length-1;i++){
					                          for(int j=i+1;j<count.length;j++){
					                                  if (count[i]<count[j]){
					                                         int temp=count[i];
					                                         count[i]=count[j];
					                                         count[j]=temp;
					                                         Item temp2=itemList.get(i);
					                                         itemList.set(i, itemList.get(j));
					                                         itemList.set(j, temp2);
					                                 }
					                          }
					                }
																		
				session.setAttribute("itemList", itemList);
				tourl = "/catalog/Product.jsp";
	
        } else if("zong".equals(path)){
    	    List<Item> itemList = (List<Item>) session.getAttribute("itemList");//����ĳɰ��չؼ���ƥ��
			
			int count[]= new int[itemList.size()];
			for(int i=0;i<count.length;i++){
				count[i]=this.countzongxiaoliang(itemList.get(i).getItemid());
			}
			
			for(int i=0;i<count.length-1;i++){
				                          for(int j=i+1;j<count.length;j++){
				                                  if (count[i]<count[j]){
				                                         int temp=count[i];
				                                         count[i]=count[j];
				                                         count[j]=temp;
				                                         Item temp2=itemList.get(i);
				                                         itemList.set(i, itemList.get(j));
				                                         itemList.set(j, temp2);
				                                 }
				                          }
				                }
																	
			session.setAttribute("itemList", itemList);
			tourl = "/catalog/Product.jsp";

       } else if("searchzong".equals(path)){
   	    List<Item> itemList = (List<Item>) session.getAttribute("itemList");//����ĳɰ��չؼ���ƥ��
		
			int count[]= new int[itemList.size()];
			for(int i=0;i<count.length;i++){
				count[i]=this.countzongxiaoliang(itemList.get(i).getItemid());
			}
			
			for(int i=0;i<count.length-1;i++){
				                          for(int j=i+1;j<count.length;j++){
				                                  if (count[i]<count[j]){
				                                         int temp=count[i];
				                                         count[i]=count[j];
				                                         count[j]=temp;
				                                         Item temp2=itemList.get(i);
				                                         itemList.set(i, itemList.get(j));
				                                         itemList.set(j, temp2);
				                                 }
				                          }
				                }
																	
			session.setAttribute("itemList", itemList);
			tourl = "/catalog/ProductforSearch.jsp";

    }
		else{
			listProduct = productbiz.searchById(0, "");
			tourl = "index.html";
			session.setAttribute("listProduct", listProduct);
		}
		request.getRequestDispatcher(tourl).forward(request, response);
	}
}
