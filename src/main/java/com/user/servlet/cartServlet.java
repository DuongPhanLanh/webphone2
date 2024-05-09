package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.cartDAOImpl;
import com.DAO.phoneDAOImpl;
import com.DB.DBConnect;
import com.entity.cart;
import com.entity.product;


@WebServlet("/cart")
public class cartServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		try {
			int pid = Integer.parseInt(req.getParameter("pid"));
			int uid = Integer.parseInt(req.getParameter("uid"));
			
			phoneDAOImpl dao = new phoneDAOImpl(DBConnect.getConn());
			product dtl = dao.getPhoneById(pid);
			
			cart c=new cart();
			
			c.setPid(pid);
			c.setUid(uid);
			c.setProductname(dtl.getName());
			c.setProductcategory(dtl.getCategory());
			c.setPrice(dtl.getTotalPrice());
			c.setTotalprice(dtl.getTotalPrice());
			
			cartDAOImpl dao1=new cartDAOImpl(DBConnect.getConn());
			boolean f= dao1.addCart(c);
			
			HttpSession session = req.getSession();
			// TOAST giống như một hộp cảnh báo chỉ hiển thị trong vài giây khi có điều gì đó xảy ra (tức là khi người dùng nhấp vào nút, gửi biểu mẫu, v.v.).
			
			if(f) {
				session.setAttribute("trueU", "Update Success");
				resp.sendRedirect("CHECKOUT.jsp");
			}else {
				session.setAttribute("falseU", "Update False");
				resp.sendRedirect("CHECKOUT.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
