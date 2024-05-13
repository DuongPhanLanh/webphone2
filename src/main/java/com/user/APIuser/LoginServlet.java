package com.user.APIuser;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.userDAOImpl;
import com.DB.DBConnect;
import com.entity.user;

@WebServlet("/")
@MultipartConfig
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		try {
			userDAOImpl dao = new userDAOImpl(DBConnect.getConn());
			HttpSession session = req.getSession();	
			
			String gmail=req.getParameter("gmail");
			String password=req.getParameter("password");
			
			if("admin@gmail.com".equals(gmail) && "admin".equals(password)) {
				user us = new user();
				session.setAttribute("userobj", us);
				resp.sendRedirect("admin/homeAdmin.jsp");
			
			}else {
				user us = dao.login(gmail, password);
				if(us!=null) {
					session.setAttribute("userobj", us);
					//resp.sendRedirect("homePage.jsp");;
					resp.sendRedirect("index.jsp");
				}else {
					session.setAttribute("failedLog", "Đăng nhập ko hợp lệ");
					resp.sendRedirect("login.jsp");
				}
				
				//resp.sendRedirect("home.jsp");
				
			}
			} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
