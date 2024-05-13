package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.DAO.phoneDAOImpl;
import com.DB.DBConnect;
import com.entity.product;

@WebServlet("/editphone")
@MultipartConfig
public class editPhoneServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		try {
			int id = Integer.parseInt(req.getParameter("idd"));
			String edname = req.getParameter("edname");
			String edcategory = req.getParameter("edcategory");
			String eddescription = req.getParameter("eddescription");
			int edstock = Integer.parseInt(req.getParameter("edstock"));
			double edprice = Double.parseDouble(req.getParameter("edprice"));
			double eddiscount = Double.parseDouble(req.getParameter("eddiscount"));
//			double edtotalprice = Double.parseDouble(req.getParameter("edtotalprice"));
			
			Part p =req.getPart("edimg");
			String filename = p.getSubmittedFileName();
			
			product phone = new product();
			phone.setId(id);
			phone.setName(edname);
			phone.setCategory(edcategory);
			phone.setDescription(eddescription);
			phone.setStock(edstock);
			phone.setPrice(edprice);
			phone.setDiscount(eddiscount);
			
			// phone.setTotalPrice(edtotalprice);
			// ---- Tính toán giá trị khi đc giảm giá ----
			
//			double discount = phone.getPrice()*(phone.getDiscount()/100.0);			
//			phone.setPrice(discount);
			double price = phone.getPrice();
//			double discountedPrice = price - (price * (eddiscount / 100.0));
			double discountedPrice =price - (price * (eddiscount / 100.0));
            phone.setTotalPrice(discountedPrice);
			// -------------------------------------------
			
			phone.setImg(filename);
			
			phoneDAOImpl dao = new phoneDAOImpl(DBConnect.getConn());
			boolean f = dao.updateEditPhone(phone);
			
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
