package org.bzc.comicstore.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bzc.comicstore.beans.Account;
import org.bzc.comicstore.beans.Signon;
import org.bzc.comicstore.biz.AccountBiz;
import org.bzc.comicstore.biz.SignonBiz;
import org.bzc.comicstore.db.ControlDB;
import org.bzc.comicstore.utils.ConvertUtil;

public class SignonServlet extends HttpServlet {
	
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
        request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String path = request.getParameter("path");
		HttpSession session = request.getSession();
		ConvertUtil cutils = new ConvertUtil();
		List listSignon = new ArrayList();
		SignonBiz signonbiz = new SignonBiz();
		String tourl = "";
		String error = "";
		if ("add".equals(path)) {
			Signon signon = new Signon();
			signon.setUsername(request.getParameter("username"));
			signon.setPassword(request.getParameter("newpassword"));

			Account account = new Account();
			account.setStatus("OK");//�������status
			account.setUserid(request.getParameter("username"));
			account.setAddr1(request.getParameter("address1"));
			account.setAddr2(request.getParameter("address2"));
			account.setCity(request.getParameter("city"));
			account.setCountry(request.getParameter("country"));
			account.setEmail(request.getParameter("email"));
			account.setFirstname(request.getParameter("firstname"));
			account.setLastname(request.getParameter("lastname"));
			account.setPhone(request.getParameter("phone"));
			account.setState(request.getParameter("state"));
			account.setZip(request.getParameter("zip"));
			account.setBalance(new BigDecimal(0));

	
			AccountBiz accountbiz = new AccountBiz();
			accountbiz.add(account);
			signonbiz.add(signon);
			System.out.println(signon.getUsername() + "+++++++++"
					+ account.getUserid());
			session.setAttribute("user", signon);
			session.setAttribute("tourl", "index.html");
			tourl = "/index.jsp";
		} else if ("off".equals(path)) {
			if (null != session.getAttribute("user")) {
				path = "success";
				session.removeAttribute("user");
				
			}
			tourl = "/index.jsp";
		} else if ("checkSignon".equals(path)) {
			session.setAttribute("tourl", "index.html");

			if (null != session.getAttribute("user")) {
				tourl = "/index.jsp";
			} else {
				tourl = "/account/SignonForm.jsp";
			}

		}else if ("account".equals(path)) {
			AccountBiz ab= new AccountBiz();
			if (null != session.getAttribute("user")) {
			 Signon signon=(Signon) session.getAttribute("user");
			 Account a=(Account) ab.searchById(1, signon.getUsername()).get(0);
			 session.setAttribute("account", a);
			 tourl = "/account/MyAccount.jsp";
			}else {
				tourl = "/account/SignonForm.jsp";
			}

		} else if ("signon".equals(path)) {
			AccountBiz ab= new AccountBiz();
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			List userList = signonbiz.searchById(0, 0);
			System.out.println(userList.size());
			if (null != username && null != password) {
				if (userList.isEmpty()) {
					tourl = "/account/SignonForm.jsp";
				} else {
					Iterator it = userList.iterator();
					boolean ok = false;
					while (it.hasNext()) {
						Signon cust = (Signon) it.next();
						if (password.equals(cust.getPassword())) {
							ok = true;
							Account a=(Account) ab.searchById(1, cust.getUsername()).get(0);
							session.setAttribute("user", cust);
							session.setAttribute("account", a);
						}
					}
					if (ok) {

						tourl = "/index.jsp";
					} else {
						tourl = "/account/SignonForm.jsp";
					}
				}
			} else {
				tourl = "/account/SignonForm.jsp";
			}
		} else {
			listSignon = signonbiz.searchById(0, 0);
			tourl = "";
			session.setAttribute("listSignon", listSignon);
		}
		request.getRequestDispatcher(tourl).forward(request, response);
	}
}
