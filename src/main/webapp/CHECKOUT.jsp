<%@page import="com.entity.user"%>
<%@page import="com.entity.cart"%>
<%@page import="java.util.List"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.DAO.cartDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang đặt hàng của bạn</title>
<%@include file="all_component/allCss.jsp" %>
</head>
<body>
<%@include file="all_component/navbar.jsp" %>
<h2><a href="index.jsp">Quay lại</a></h2>
	
	<c:if test="${not empty trueU }">
		<div class="alert alert-success" role="alert">${trueU }</div>
		<c:remove var="trueU " scope="session"/>
	</c:if>
					
	<c:if test="${not empty falseU }">
		<div class="alert alert-success" role="alert">${falseU }</div>
		<c:remove var="falseU " scope="session"/>
	</c:if>


	<%
		user u =(user)session.getAttribute("userobj");
	%>
<div class="container">
	<div class="row">
		<div class="col-md-10">
			<div class="card">
			<h4 class="text-center">Các mặt hàng của bạn</h4>
					<div class="card-body"></div>
						<table class="table table-bordered">
					  <thead>
					    <tr>
					      <th scope="col">Tên mặt hàng</th>
					      <th scope="col">Hãng sản xuất</th>
					      <th scope="col">Giá tiền</th>
	
					      <th scope="col">Action</th>
					    </tr>
					  </thead>
					  <tbody>
					  
					  <%
					  
					  cartDAOImpl dao = new cartDAOImpl(DBConnect.getConn());
					  List<cart> cart = dao.getPhoneByUser(u.getId());
					  
					  Double totalPrice=0.00;
					  for(cart c: cart) 					  
					  {
					  totalPrice=c.getTotalprice();
					  %>
						<tr>
					      <td><%=c.getProductname() %></td>
					      <td><%=c.getProductcategory()%></td>
					      <td><%=c.getPrice() %></td>
					     
					      
					      <td>
					      	<a href="O_ADD_Product.jsp?oid=<%=c.getCid() %>" class="btn btn-sm btn-success">Mua luôn</a>
					      	<a href="removeCartServlet?pid=<%=c.getPid()%>&&uid=<%=c.getUid() %> " class="btn btn-sm btn-danger">Remove</a>
					      	
					      </td>
					    </tr>
					  <%
					  }
					  %>
					  <tr>
					      <td>Tổng tiền</td>
					      <td colspan="3">
					      	<%=totalPrice %>
					      </td>
					    </tr>
					    
					  </tbody>
					</table>
					
				</div>		
			</div>			
		</div>
		
		
		</div>
<%@include file="all_component/footer.jsp" %>
</body>
</html>