
<%@page import="com.entity.product"%>
<%@page import="com.DAO.phoneDAOImpl"%>
<%@page import="java.util.List"%>
<%@page import="com.DB.DBConnect"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách Phone ADDMIN</title>
<%@include file="allCss.jsp" %>
</head>
<body>
<%@include file="navbarIndex.jsp" %>

<!-- sử dụng trueU/falseU cho mục phoneEdit.java và phoneDelete.java -->
					<c:if test="${not empty trueU }">
						<h5 class="text-center text-success">${trueU }</h5>
						<c:remove var="trueU " scope="session"/>
					</c:if>
					
					<c:if test="${not empty falseU }">
						<h5 class="text-center text-danger">${falseU }</h5>
						<c:remove var="falseU " scope="session"/>
					</c:if>

<div class="container ">
	<div class="card card-sh">
		<div class="card-body">
			<table class="table table-bordered">
		  <thead>
		    <tr>
		      <th scope="col">ID</th>
		      <th scope="col">Tên mặt hàng</th>
		      <th scope="col">IMG</th>
		      <th scope="col">Loại</th>
		      <th scope="col">Mô tả</th>
		      <th scope="col">Giá tiền</th>
		      <th scope="col">Số lượng</th>
		      <th scope="col">Giảm giá</th>
		      <th scope="col">Giá tiền giảm giá</th>
		      <th scope="col">Hoạt động chương trình</th>
		    </tr>
		  </thead>
		  <tbody>
		  
		  <%
		  
		  phoneDAOImpl dao = new phoneDAOImpl(DBConnect.getConn());
		  List<product> list = dao.AllPhone();
		  
		  for(product dtl : list) 
		  {%>
			<tr>
		      <td><%=dtl.getId() %></td>
		      <td><%=dtl.getName() %></td>
		      <td><img src="../img/<%=dtl.getImg()%>" 
	      style="width: 50px; height: 50px"></td>
	      	  <td><%=dtl.getCategory() %></td>
	      	  <td><%=dtl.getDescription() %></td>
	      	  <td><%=dtl.getPrice() %></td>
	      	  <td><%=dtl.getStock() %></td>
	      	  <td><%=dtl.getDiscount() %>%</td>
	      	  <td><%=dtl.getTotalPrice() %></td>
		      <td>
		       	<a href="P_EDIT_Phone.jsp?id=<%=dtl.getId() %>" class="btn btn-warning"> Chỉnh sửa</a>
				<a href="../delete?id=<%=dtl.getId()%>" class="btn btn-danger"> Xóa</a>
	      	</td>	    
		    </tr>
		  <%}
	
		  %>
		    
		  </tbody>
		</table>
		</div>
	</div>
</div>

		


<%@include file="footer.jsp" %>
</body>
</html>