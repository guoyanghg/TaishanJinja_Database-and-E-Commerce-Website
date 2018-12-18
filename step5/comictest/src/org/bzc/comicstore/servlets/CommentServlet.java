package org.bzc.comicstore.servlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bzc.comicstore.beans.Comment;
import org.bzc.comicstore.beans.Orders;
import org.bzc.comicstore.beans.Orderstatus;
import org.bzc.comicstore.beans.Product;
import org.bzc.comicstore.beans.Signon;
import org.bzc.comicstore.biz.CommentBiz;
import org.bzc.comicstore.biz.OrdersBiz;
import org.bzc.comicstore.biz.OrderstatusBiz;

public class CommentServlet extends HttpServlet {
	public void init() throws ServletException {
	}

	public void destroy() {
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
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

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    //�����ȡ�?��Ϣ  Ȼ��д����ݿ�
		    System.out.println(request.getParameter("itemid"));
		    String path = request.getParameter("path");
			HttpSession session = request.getSession();
			CommentBiz commentbiz= new CommentBiz();
			OrdersBiz orderbiz=new OrdersBiz();
			String tourl = "";
			if ("show".equals(path)) {
				String itemid = request.getParameter("itemid");
				if(itemid!=null){
					List<Comment> list;
					try {
						list = commentbiz.searchByitemId(1,itemid);
						int count=this.countzongxiaoliang(itemid);
						double rating=0;
						for(int i=0;i<list.size();i++){
							rating=list.get(i).getRating().doubleValue()+rating;
						}
						rating=rating/list.size()*100;
						Math.round(rating);
						rating=rating/100;
						session.setAttribute("commentList", list);
						session.setAttribute("commentcount", count);
						session.setAttribute("commentrating", rating);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				tourl = "/account/ItemComment.jsp";
			}else if("comment".equals(path)){
				String orderid = request.getParameter("orderid");
				Orders commentOrder=(Orders) orderbiz.searchById(1, Integer.parseInt(orderid)).get(0);
				session.setAttribute("commentOrder", commentOrder);
				tourl = "/account/CommentForm.jsp";			
				
			 }else if("addcomment".equals(path)){
				Comment c= new Comment();
				Signon signon=(Signon) session.getAttribute("user");
				Orders o=(Orders) session.getAttribute("commentOrder");
	            String comment = request.getParameter("comment");
	            String rating = request.getParameter("rating");
	            BigDecimal r = new BigDecimal(rating);
	            comment=new String(comment.getBytes("iso-8859-1"),"utf-8");
	            c.setContent(comment);
	            c.setRating(r);
	            c.setItemid(o.getItemid());
	            c.setUserid(signon.getUsername());
	            c.setOrderid(o.getOrderid());
	            c.setDate(new java.sql.Date(new java.util.Date().getTime()));
	            commentbiz.add(c);
	            tourl = "/account/MyAccount.jsp";				 
			 }
			else {
				//commentbiz = commentbiz.searchByitemId(0, "");
				tourl = "index.html";
				//session.setAttribute("commentList", list);
			}
			request.getRequestDispatcher(tourl).forward(request, response);
	}
}