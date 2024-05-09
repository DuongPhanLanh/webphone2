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
<h3 class="text-center">Thêm sản phẩm</h3>

<!-- sử dụng trueP/falseP cho mục phoneEdit.java và phoneDelete.java -->
				
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
				
				<form action="../addphone" method="post" enctype="multipart/form-data" accept-charset="UTF-8">
				  <div class="form-group">
				    <label for="exampleFormControlInput1">Name</label>
				    <input type="text" class="form-control" id="exampleFormControlInput1" name="pname">
				  </div>
				  
				  <div class="form-group">
				    <label for="exampleFormControlSelect1">Loại mặt hàng</label>
				    <select class="form-control" id="exampleFormControlSelect1" name="pcategory">
				      <option value="NEW">Hàng Mới</option>
				      <option value="SALE">Hàng sale</option>
				      <option value="Diverse">Hàng khác</option>
				     
				    </select>
				  </div>
				  
				  <div class="form-group">
				    <label for="exampleFormControlTextarea1">Description</label>
				    <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="pdescription"></textarea>
				  </div>
				  
				  <div class="form-group">
				    <label for="exampleInputPassword1">Số lượng</label>
				    <input type="number" class="form-control" id="exampleInputPassword1" name="pstock">
			   </div>
			   
			   <div class="form-group">
				    <label for="exampleInputPassword1">Gía tiền</label>
				    <input type="number" class="form-control" id="exampleInputPassword1" name="pprice">
			   </div>
			   
				
				<div class="form-group">
					    <label for="exampleFormControlFile1">Thêm ảnh</label><br>
					    <input name="pimg" type="file" class="form-control-file" id="exampleFormControlFile1">
					    <%--accept=".jpg, .png, .pdf" --%>
					  </div>
					  
					  <br>
					  <div class="">
					  	<button type="submit" class="btn btn-outline-dark mt-auto">Thêm sản phẩm</button> 
					  	<!-- <button type="submit" class="btn btn-danger">DELETE</button>  -->
					  	
					  </div>
					  
				</form>
				
				
					   
				</div>
			</div>
			
			
		</div>
	</div>


<br>
<%@include file="footer.jsp" %>
</body>
</html>