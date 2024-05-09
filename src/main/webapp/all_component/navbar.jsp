<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container px-4 px-lg-5">
                <a class="navbar-brand" href="index.jsp">Nhóm 13 (4-1)</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="#!">Home</a></li>
                        <li class="nav-item"><a class="nav-link" href="#!">About</a></li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Shop</a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="index.jsp">All Products</a></li>
                                <li><hr class="dropdown-divider" /></li>
                                <li><a class="dropdown-item" href="All_SALE_Product.jsp">Popular Items</a></li>
                                <li><a class="dropdown-item" href="All_NEW_Product.jsp">New Arrivals</a></li>
                            </ul>
                        </li>
                    </ul>
                    
                   
                    <c:if test="${not empty userobj }">
						<form class="d-flex">
                        <a href="CHECKOUT.jsp" class="btn btn-outline-dark me-2">CART</a> 
                                          	 
                        <a href="O_All_Product.jsp" class="btn btn-outline-dark me-2">${userobj.name }</a>
                        
                        <a href="logOut" class="btn btn-outline-dark me-2">LOGOUT</a>
                        
                    </form>
					
					</c:if>
					
					<c:if test="${empty userobj }">
						<form class="d-flex">
                        <a href="login.jsp" class="btn btn-outline-dark me-2">LOGIN</a>
                        
                    </form>
					
					</c:if>
                    
                    
                    
                    
                    
                </div>
            </div>
        </nav>
        <!-- Header-->
        <header class="bg-dark py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="text-center text-white">
                    <h1 class="display-4 fw-bolder">Phone in my style</h1>
                    <p class="lead fw-normal text-white-50 mb-0">Được thực hiện bởi nhóm 13</p>
                </div>
            </div>
        </header>
        <!-- Section-->
  <section class="py-2">
    <div class="container px-4 px-lg-5 mt-5">
        <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
        </div>
    </div>
</section>
