package com.admin.servlet.API;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.DAO.phoneDAOImpl;
import com.DB.DBConnect;
import com.entity.product;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/api/product")
public class allPhoneAPI extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        phoneDAOImpl dao = new phoneDAOImpl(DBConnect.getConn());
        
        List<product> p = dao.AllPhone();
        
     // Chuyển danh sách các tài khoản thành JSON và gửi về client
        ObjectMapper mapper = new ObjectMapper();
        String jsonAccounts = mapper.writeValueAsString(p);

        resp.getWriter().write(jsonAccounts);
	}
}
