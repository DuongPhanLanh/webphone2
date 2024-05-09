<%@page import="com.entity.user"%>
<%@page import="com.entity.cart"%>
<%@page import="com.DAO.cartDAOImpl"%>
<%@page import="com.entity.product"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.DAO.phoneDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nhập thông tin mua hàng</title>
<%@include file="all_component/allCss.jsp" %>
</head>
<body>
<%@include file="all_component/navbar.jsp" %>
<h2><a href="index.jsp">Quay lại</a></h2>


	<%
		user u =(user)session.getAttribute("userobj");
	%>
	
	
	 <%
			int id = Integer.parseInt(request.getParameter("oid"));
			cartDAOImpl dao = new cartDAOImpl(DBConnect.getConn());
			cart p = dao.getCartById(id);
	%>
	
					<c:if test="${not empty trueP }">
						<p class="text-center text-success">${trueP }</p>
						<c:remove var="trueP " scope="session"/>
					</c:if>
					
					<c:if test="${not empty falseP }">
						<p class="text-center text-danger">${falseP }</p>
						<c:remove var="falseP " scope="session"/>
					</c:if>
	<div class="row">
		<div class="col-md-4 offset-md-4">
			<div class="card">
				<div class="card-body">
				<h4 class="text-center">Nhập số lượng để mua hàng</h4>
				<form action="addOrderServlet" method="post" enctype="multipart/form-data" accept-charset="UTF-8">
				  
				  <input type="hidden" name="id" value="${userobj.id }">	
				  <input type="hidden" name="nameo" value="${userobj.name }">	
				  <input type="hidden" name="gmailo" value="${userobj.gmail }">	
				  <input type="hidden" name="phoneo" value="${userobj.phone }">	
				  
				  <div class="form-group">
				    <label for="exampleFormControlInput1">Tên mặt hàng</label>
				    <input type="text" class="form-control" id="exampleFormControlInput1" name="oproduct" value="<%=p.getProductname() %>">
				  </div>
				  
				   <div class="form-group">
				    <label for="exampleFormControlInput1">Loại mặt hàng</label>
				    <input type="text" class="form-control" id="exampleFormControlInput1" name="ocategory" value="<%=p.getProductcategory() %>">
				  </div>
				  
				   <div class="form-group">
				    <label for="exampleInputPassword1">Gía tiền</label>
				    <input type="number" class="form-control" id="exampleInputPassword1" name="oprice" value="<%=p.getPrice() %>">
			   	  </div>
			   	  
				  <div class="form-group">
				    <label for="exampleInputPassword1">Số lượng</label>
				    <input type="number" class="form-control" id="exampleInputPassword1" name="otock" value="<%=p.getStock() %>">
			  	  </div>
			  	  
			  	  <div class="form-group">
				    <label for="exampleInputPassword1">Tổng tiền</label>
				    <input type="number" class="form-control" id="exampleInputPassword1" name="ototalprice" value="<%=p.getTotalprice() %>">
			  	  </div>
			   
					  
					  <br>
					  <div class="">
					  	<button type="submit" class="btn btn-outline-dark mt-auto">Mua</button> 
					  	<!-- <button type="submit" class="btn btn-danger">DELETE</button>  -->
					  	
					  </div>
					  
				</form>
				
				
					   
				</div>
			</div>
			
			
		</div>
	</div>
<%@include file="all_component/footer.jsp" %>
</body>
</html>