package com.admin.servlet.API;

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
import com.entity.user;
import com.google.gson.Gson;

@WebServlet("/api/product/add")
@MultipartConfig
public class addPhoneAPI extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

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
			
			
			// Tạo đối tượng product từ dữ liệu
			product dtl = new product(pname, pstock, pcategory, pdescription, pprice, filename,"admin");

			phoneDAOImpl dao = new phoneDAOImpl(DBConnect.getConn());
			boolean f=dao.addPhone(dtl);
			

			if(f) {
				Gson gson = new Gson();
		        String jsonProduct = gson.toJson(dtl);
		        resp.getWriter().write(jsonProduct);
			}else {
				System.out.println("Báo cáo lỗi");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
