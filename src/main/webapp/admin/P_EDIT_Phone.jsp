
<%@page import="com.entity.product"%>
<%@page import="com.DAO.phoneDAOImpl"%>
<%@page import="com.DB.DBConnect"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang ADDMIN</title>
<%@include file="allCss.jsp" %>
</head>
<body>
<%@include file="navbarIndex.jsp" %>

<h3 class="text-center">Thay đổi nội dung</h3>


	<div class="row">
		<div class="col-md-4 offset-md-4">
			<div class="card">
				<div class="card-body">
				
				<%
				
					int id = Integer.parseInt(request.getParameter("id"));
					phoneDAOImpl dao = new phoneDAOImpl(DBConnect.getConn());
					product p = dao.getPhoneById(id);
				
				%>
				
				
				<form action="../editphone" method="post" enctype="multipart/form-data" accept-charset="UTF-8">
				  
				  
				  <input type="hidden" name="idd" value="<%=p.getId() %>">
				  <div class="form-group">
				    <label for="exampleFormControlInput1">Name</label>
				    <input type="text" class="form-control" id="exampleFormControlInput1" name="edname" value="<%=p.getName() %>">
				  </div>
				  
				  <div class="form-group">
				    <label for="exampleFormControlSelect1">Loại mặt hàng</label>
				    <select class="form-control" id="exampleFormControlSelect1" name="edcategory">
				    <!-- 
				      <option value="Mobile">Mobile</option>
				      <option value="IPAD">IPAD</option>
				      <option value="MACBOOK">MACBOOK</option>
				      <option value="APPLE WACTH">APPLE WACTH</option>
				     -->
				     
				     <%
					    	if("NEW".equals(p.getCategory())) {
					    	%>
					    	  <option value="NEW">Hàng Mới</option>
						      <option value="SALE">Hàng sale</option>
						      <option value="Diverse">Hàng khác</option>
					    	<%
					    	}else if("SALE".equals(p.getCategory())) {
					    	%>
					    	  <option value="SALE">Hàng sale</option>
					    	  <option value="NEW">Hàng Mới</option>						      
						      <option value="Diverse">Hàng khác</option>
					    	<%
					    	}else if("Diverse".equals(p.getCategory())) {
					    	%>
					    	  <option value="Diverse">Hàng khác</option>
					    	  <option value="NEW">Hàng Mới</option>
						      <option value="SALE">Hàng sale</option>
						      
					    	<%
					    	}
						    %>
				     
				     
				      
				    </select>
				  </div>
				  
				  <div class="form-group">
				    <label for="exampleFormControlTextarea1">Description</label>
				    <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="eddescription">
				    <%=p.getDescription() %>
				    </textarea>
				  </div>
				  
				  <div class="form-group">
				    <label for="exampleInputPassword1">Số lượng</label>
				    <input type="number" class="form-control" id="exampleInputPassword1" name="edstock" value="<%=p.getStock() %>">
			   </div>
			   
			   <div class="form-group">
				    <label for="exampleInputPassword1">Gía tiền</label>
				    <input type="number" class="form-control" id="exampleInputPassword1" name="edprice" value="<%=p.getPrice() %>">
			   </div>
			   
			    <div class="form-group">
				    <label for="exampleInputPassword1">Giảm giá</label>
				    <input type="number" class="form-control" id="exampleInputPassword1" name="eddiscount" value="<%=p.getDiscount() %>">
			   </div>
			   
			   <div class="form-group">
				    <label for="exampleInputPassword1">Giá tiền giảm giá</label>
				    <input type="number" class="form-control" id="exampleInputPassword1" value="<%=p.getTotalPrice() %>">
			   </div>
				
				
					<div class="form-group">
					    <label for="exampleFormControlFile1">Thêm ảnh</label><br>
					    <input name="edimg" type="file" class="form-control-file" id="exampleFormControlFile1" value="<%=p.getImg() %>">
					    <%--accept=".jpg, .png, .pdf" --%>
					  </div>
				 
				
					  
					  <br>
					  <div class="">
					  	<button type="submit" class="btn btn-outline-dark mt-auto">Cập nhật</button> 
					  	<!-- <button type="submit" class="btn btn-danger">DELETE</button>  -->
					  	
					  </div>
					  
				</form>
				
				
					   
				</div>
			</div>
			
			
		</div>
	</div>

<%@include file="footer.jsp" %>
</body>
</html>