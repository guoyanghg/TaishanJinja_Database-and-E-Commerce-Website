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

import org.bzc.comicstore.beans.Category;
import org.bzc.comicstore.beans.Product;
import org.bzc.comicstore.biz.CategoryBiz;
import org.bzc.comicstore.biz.ProductBiz;

public class IndexServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
			{
		response.setContentType("text/html;charset=utf-8");
		CategoryBiz categorybiz = new CategoryBiz();
		String tourl = "";
        HttpSession session = request.getSession();
		List<Category> list = new ArrayList<Category>();
		try {
			list = categorybiz.searchById(0, "");
			tourl = "/catalog/Main.jsp";
		} catch (Exception e) {
			tourl = "index.html";
			e.printStackTrace();
		}
		session.setAttribute("categroyList", list);

		request.getRequestDispatcher(tourl).forward(request, response);
			}
}
