package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.phoneDAOImpl;
import com.DB.DBConnect;

@WebServlet("/delete")
public class deletePhoneServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// thuộc đường dẫn trong csdl mysql
			int id = Integer.parseInt(req.getParameter("id"));
			
			
			phoneDAOImpl dao = new phoneDAOImpl(DBConnect.getConn());
			boolean f=dao.deletePhone(id);
			
			HttpSession session = req.getSession();
			if(f) {
				session.setAttribute("trueU", "Update Success");
				resp.sendRedirect("admin/P_ALL_Phone.jsp");
			}else {
				session.setAttribute("falseU", "Update False");
				resp.sendRedirect("admin/P_ALL_Phone.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
