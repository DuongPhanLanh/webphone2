package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.cartDAOImpl;
import com.DB.DBConnect;

@WebServlet("/removeCartServlet")
public class removeCartServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pid = Integer.parseInt(req.getParameter("pid"));
		int uid = Integer.parseInt(req.getParameter("uid"));
		
		cartDAOImpl dao = new cartDAOImpl(DBConnect.getConn());
		boolean f = dao.deletePhone(uid, pid);
		
		HttpSession session = req.getSession();
		
		if(f) {
			session.setAttribute("trueU", "Delete success");
			resp.sendRedirect("CHECKOUT.jsp");
		}else {
			session.setAttribute("falseU", "Delete failse");
			resp.sendRedirect("CHECKOUT.jsp");
		}
;	}
}
