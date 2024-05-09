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

@WebServlet("/addphone")
@MultipartConfig
public class addPhoneServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		try {
			String pname=req.getParameter("pname");
			String pcategory=req.getParameter("pcategory");
			String pdescription=req.getParameter("pdescription");
			int pstock = Integer.parseInt(req.getParameter("pstock"));
			double pprice = Double.parseDouble(req.getParameter("pprice"));
			
			Part p =req.getPart("pimg");
			String filename = p.getSubmittedFileName();
//			
//			String path = getServletContext().getRealPath("")+"PHONE";
//			File f = new File(path);
//			p.write(path+File.separator+filename);
			
			
			product dtl = new product(pname, pstock, pcategory, pdescription, pprice, filename,"admin");
//			System.out.println(dtl);
			phoneDAOImpl dao = new phoneDAOImpl(DBConnect.getConn());
			boolean f=dao.addPhone(dtl);
			
			HttpSession session = req.getSession();
			if(f) {
				session.setAttribute("trueP", "AddBook Success");
				resp.sendRedirect("admin/P_ADD_Phone.jsp");
			}else {
				session.setAttribute("falseP", "AddBook False");
				resp.sendRedirect("admin/P_ADD_Phone.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
