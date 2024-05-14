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

@WebServlet("/api/product/update/*")
@MultipartConfig
public class editPhoneAPI extends HttpServlet {
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        
        String path = req.getPathInfo();
        if(path !=null && path.length()>1) {
        	String[] pathParts = path.split("/");
        	try {
    			int id = Integer.parseInt(pathParts[pathParts.length - 1]);
    			String edname = req.getParameter("edname");
    			String edcategory = req.getParameter("edcategory");
    			String eddescription = req.getParameter("eddescription");
    			int edstock = Integer.parseInt(req.getParameter("edstock"));
    			double edprice = Double.parseDouble(req.getParameter("edprice"));
    			double eddiscount = Double.parseDouble(req.getParameter("eddiscount"));
//    			double edtotalprice = Double.parseDouble(req.getParameter("edtotalprice"));
    			
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
    			
//    			double discount = phone.getPrice()*(phone.getDiscount()/100.0);			
//    			phone.setPrice(discount);
    			double price = phone.getPrice();
//    			double discountedPrice = price - (price * (eddiscount / 100.0));
    			double discountedPrice =price - (price * (eddiscount / 100.0));
                phone.setTotalPrice(discountedPrice);
    			// -------------------------------------------
    			
    			phone.setImg(filename);
    			
    			phoneDAOImpl dao = new phoneDAOImpl(DBConnect.getConn());
    			boolean f = dao.updateEditPhone(phone);
    			
 //   			HttpSession session = req.getSession();
    			if(f) {
    				 resp.getWriter().write(id+ " : đã cập nhật");
    			}else {
    				resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    	            resp.getWriter().write("Ko tìm thấy đừng dẫn URL");
    			}
    			
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
        }else {
        	resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("Ko tìm thấy đừng dẫn URL");
        }
		
	}
}
