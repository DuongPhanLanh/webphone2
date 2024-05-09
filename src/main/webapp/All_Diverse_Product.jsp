<%@page import="com.entity.product"%>
<%@page import="java.util.List"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.DAO.phoneDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Các mặt hàng khác</title>
<%@include file="all_component/allCss.jsp" %>
</head>
<body>
<%@include file="all_component/navbar.jsp" %>
<div class="container">
	<div class="row">
		<div class="col-md-2">
			<div class="card">
			<h4 class="text-center">Các mặt hàng của bạn</h4>
					<div class="card-body"></div>
						<table class="table table-bordered">
					  <tbody>
						   <tr>					    
						      <th scope="col"><a href="index.jsp">Tất cả mặt hàng</a></th>
						    </tr>
						     <tr>					    
						      <th scope="col"><a href="All_NEW_Product.jsp">NEW</a></th>
						    </tr>
						    <tr>
						      <th scope="col"><a href="All_SALE_Product.jsp">SALE-Popular</a></th>
						    </tr>
						    <tr>
						      <th scope="col"><a href="All_Diverse_Product.jsp" class="text-danger">Các mặt hàng khác</a></th>
						    </tr>
					  </tbody>
					</table>
					
				</div>	
			</div>
			
			<!--  -->
			<div class="col-md-10">
			<div class="card">
				<div class="card-body">
				<h4 class="text-center">Thông tin về tất cả các sản phẩm</h4>
      <div class="container px-4 px-lg-5 mt-5">
        <!--  -->
        <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
          <%
    	
	    phoneDAOImpl dao = new phoneDAOImpl(DBConnect.getConn());
	    List<product> list = dao.getAllDiverse();
	    
	    for(product p : list) 
	    {%>
        	<div class="col mb-5">
                        <div class="card h-100">
                         <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem"><%=p.getCategory() %></div>
                            <!-- Product image-->
                            <img class="card-img-top" src="img/<%=p.getImg() %>" alt="..." />
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder"><%=p.getName() %></h5>
                                    
                                    <!-- Product price-->
                                    <h5 class="">Giá hiện tại: <span style="text-decoration: line-through;"><%=p.getPrice() %></span>
                                    </h5>
                                    <h5 class="">Giảm: <%=p.getDiscount() %>%</h5>
                                    <h5 class="fw-bolder">Còn: <%=p.getTotalPrice() %></h5>
                                    
                                </div>
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center">
                                <a class="btn btn-outline-dark mt-auto" href="Detail.jsp?pid=<%=p.getId()%>">View options</a>
                                
                                </div>
                               
                            </div>
                        </div>
                </div>	
	    <%}
	    
	    %>
  </div>      
    </div> 
    </div>
      <div class="swiper-pagination position-absolute text-center"></div>
   
					
				</div>
			</div>
			</div>
			<!--  -->
			
		
		</div>		
	</div>	
			
<br>	
<%@include file="all_component/footer.jsp" %>
</body>
</html>