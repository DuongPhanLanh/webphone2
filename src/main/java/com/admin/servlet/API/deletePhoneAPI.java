package com.admin.servlet.API;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.phoneDAOImpl;
import com.DB.DBConnect;

@WebServlet("/api/product/delete")
public class deletePhoneAPI extends HttpServlet {
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
		try {
			// thuộc đường dẫn trong csdl mysql
			int id = Integer.parseInt(req.getParameter("id"));
			
			
			phoneDAOImpl dao = new phoneDAOImpl(DBConnect.getConn());
			boolean f=dao.deletePhone(id);
			
//			HttpSession session = req.getSession();
			if(f) {
				resp.getWriter().write("Account deleted successfully");
				
			}else {
				resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	            resp.getWriter().write("ID ko tồn tại");
	            return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
