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

public class AccountServlet extends HttpServlet {
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
		ConvertUtil cutils = new ConvertUtil();
		List listAccount = new ArrayList();
		AccountBiz accountbiz = new AccountBiz();
		String tourl = "";
		String error = "";
		if ("add".equals(path)) {
			tourl = "";
		} else if ("dele".equals(path)) {
			int tmpid = cutils.strToInt(request.getParameter("id"));
			boolean flag = accountbiz.delete(tmpid);
			listAccount = accountbiz.searchById(0, "");
			tourl = "";
			session.setAttribute("listAccount", listAccount);
		} else if ("update".equals(path)) {
			Account account = new Account();
			int tmpid = cutils.strToInt(request.getParameter("id"));
			boolean flag = accountbiz.update(account);
			listAccount = accountbiz.searchById(0, "");
			tourl = "";
			session.setAttribute("listAccount", listAccount);
		} else if ("toupdate".equals(path)) {
			int tmpid = cutils.strToInt(request.getParameter("id"));
			Account account = (Account) accountbiz.searchById(0, "").get(0);
			tourl = "";
			session.setAttribute("account", account);
		} else {
			listAccount = accountbiz.searchById(0, "");
			tourl = "index.html";
			session.setAttribute("listAccount", listAccount);
		}
		request.getRequestDispatcher(tourl).forward(request, response);
	}
}
