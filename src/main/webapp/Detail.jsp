<%@page import="com.entity.user"%>
<%@page import="java.util.List"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.entity.product"%>
<%@page import="com.DAO.phoneDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thông tin mặt hàng</title>
<%@include file="all_component/allCss.jsp" %>
</head>
<body>
<%@include file="all_component/navbar.jsp" %>
	<%
		user u =(user)session.getAttribute("userobj");
	
		int id = Integer.parseInt(request.getParameter("pid"));
		phoneDAOImpl dao = new phoneDAOImpl(DBConnect.getConn());
		product p = dao.getPhoneById(id);
	%>
<!-- Navigation-->
        <!-- Product section-->
        <section class="py-5">
            <div class="container px-4 px-lg-5 my-5">
            
                <div class="row gx-4 gx-lg-5 align-items-center">
                    <div class="col-md-6"><img class="card-img-top mb-5 mb-md-0" src="img/<%=p.getImg() %>" alt="..." /></div>
                    <div class="col-md-6">
                        <div class="small mb-1"><%=p.getId() %></div>
                        <h1 class="display-5 fw-bolder"><%=p.getName() %></h1>
                        <div class="fs-5 mb-5">
                            <span class="text-decoration-line-through"><%=p.getPrice() %></span>
                            <span><%=p.getTotalPrice() %></span>
                        </div>
                        <p class="lead"><%=p.getDescription() %></p>
                        <div class="medium mb-4">Hàng còn: <%=p.getStock() %></div>
                        <div class="d-flex">
                        	<%
                        	if(u==null) 
                        	{%>
                        		<a class="btn btn-outline-dark mt-auto" href="login.jsp"> Add to cart</a>
                        		
                        	<%}
                        	else 
                        	{%>
                        		<a class="btn btn-outline-dark mt-auto" href="cart?pid=<%=p.getId()%>&&uid=<%=u.getId()%>"> Add to cart</a>
                        	<%}
                        	
                        	%>
                            
                      
                        </div>                       
                    </div>
                </div>
            </div>
        </section>
        
        <!-- Vùng xuất giá trị tìm kiếm tương đương -->
        <section class="py-5 bg-light">
            <div class="container px-4 px-lg-5 mt-5">
                <h2 class="fw-bolder mb-4">Các mặt hàng có liên quan đến: <%=p.getName() %></h2>
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                
                <%
                phoneDAOImpl dao1 = new phoneDAOImpl(DBConnect.getConn());
                List<product> list1 = dao1.ListPhone();
                
                for(product p1 : list1) 
                {%>
                	 <div class="col mb-5">
                        <div class="card h-100">
                         <!-- Sale badge-->
                            <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem"><%=p1.getCategory() %></div>
                            <!-- Product image-->
                            <img class="card-img-top" src="img/<%=p1.getImg() %>" alt="..." />
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder"><%=p1.getName() %></h5>                                 
                                </div>
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="Detail.jsp?pid=<%=p1.getId()%>">Thêm sản phẩm</a></div>
                            </div>
                        </div>
                    </div>
                <%}
                %>
                
                
                   
                </div>
            </div>
        </section>
        
        
        <!-- hiển thị mặt hàng khác -->
        
        
        
<%@include file="all_component/footer.jsp" %>
</body>
</html>