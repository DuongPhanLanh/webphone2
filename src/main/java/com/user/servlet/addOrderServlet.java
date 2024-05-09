package com.user.servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.orderDAOImpl;
import com.DB.DBConnect;
import com.entity.orderPhone;

@WebServlet("/addOrderServlet")
@MultipartConfig
public class addOrderServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		try {
			int oid = Integer.parseInt(req.getParameter("id"));
			String nameo = req.getParameter("nameo");
			String gmailo = req.getParameter("gmailo");
			String phoneo = req.getParameter("phoneo");
			
			String oproduct = req.getParameter("oproduct");
			String ocategory = req.getParameter("ocategory");
			double oprice = Double.parseDouble(req.getParameter("oprice"));
			int otock = Integer.parseInt(req.getParameter("otock"));
			
			orderPhone o = new orderPhone();
			Random r = new Random();
			o.setOid("order00"+r.nextInt(1000));
			o.setOname(nameo);
			o.setOgmail(gmailo);
			o.setOphone(phoneo);
			o.setOproductname(oproduct);
			o.setOcategory(ocategory);
			o.setOprice(oprice);
			o.setOstock(otock);
			
			double price = o.getOprice();
			double totalprice = (price*otock);
			o.setOtotalprice(totalprice);
			
			orderDAOImpl dao = new orderDAOImpl(DBConnect.getConn());
			boolean f = dao.addOrder(o);
			
			HttpSession session = req.getSession();
			
					
			
			if(f) {
				session.setAttribute("trueP", "Mua hàng thành công");
				resp.sendRedirect("submit.jsp");
			}else {
				session.setAttribute("falseP", "Mua hàng thất bại");
				resp.sendRedirect("CHECKOUT.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
