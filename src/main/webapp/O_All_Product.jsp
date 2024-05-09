<%@page import="com.entity.user"%>
<%@page import="com.entity.orderPhone"%>
<%@page import="java.util.List"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.DAO.orderDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Các sản phẩm đã mua</title>
<%@include file="all_component/allCss.jsp" %>
</head>
<body>
<%@include file="all_component/navbar.jsp" %>
<h2><a href="index.jsp">Quay lại</a></h2>

<h3 class="text-center">Các mặt hàng đã mua</h3>
<table class="table table-striped">

  <thead>
    <tr>
      <th scope="col">Mã mặt hàng</th>
      <th scope="col">Tên mặt hàng</th>
      <th scope="col">Loại mặt hàng</th>
      <th scope="col">Giá gốc</th>
      <th scope="col">Số lượng mua</th>
      <th scope="col">Tổng tiền</th>
      
    </tr>
  </thead>
  <tbody>
  
  <%
  	user u = (user)session.getAttribute("userobj");
  	orderDAOImpl dao = new orderDAOImpl(DBConnect.getConn());
  	List<orderPhone> list = dao.getOrderByGmail(u.getGmail());
  	for(orderPhone o : list) 
  	{%>
  		<tr>
	      <td><%=o.getOid() %></td>
	      <td><%=o.getOproductname() %></td>
	      <td><%=o.getOcategory() %></td>
	      <td><%=o.getOprice() %></td>
	      <td><%=o.getOstock() %></td>     
	      <td><%=o.getOtotalprice() %></td>
    	</tr>
  	<%}
  
  %>
    
    
  </tbody>
</table>

<%@include file="all_component/footer.jsp" %>
</body>
</html>