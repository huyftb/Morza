<%-- 
    Document   : showImg
    Created on : Feb 24, 2023, 10:05:29 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--<%@ page import="java.util.Base64.*" %>
<%@ page import="java.util.List" %>
<%@ page import="dto.ProductDTO" %>--%>
<!DOCTYPE html>
<html lang="en">

<!-- Mirrored from askbootstrap.com/preview/osahan-eat/theme-sidebar/listing.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 19 Oct 2022 05:04:58 GMT -->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" type="image/png" href="img/logo.png">
<title>MORZA</title>

<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

<link href="css/osahan.css" rel="stylesheet">

<link href="font/stylesheet.css" rel="stylesheet">

<link href="vendor/mdi-icons/css/materialdesignicons.min.css" rel="stylesheet">

<link href="css/custom.css" rel="stylesheet">
</head>
<body id="page-top">

<div id="wrapper">

<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

<a class="sidebar-brand d-flex align-items-center" href="index.jsp">
<div class="sidebar-brand-icon">
<img src="img/logo.png" class="img-fluid">
</div>
</a>

<li class="nav-item">
<a class="nav-link" href="index.jsp">
<i class="mdi mdi-home-variant-outline"></i>
<span>Home</span></a>
</li>




<li class="nav-item">
<a class="nav-link" href="HistoryOrderController?username=${sessionScope.username}">
<i class="mdi mdi-book-open"></i>
<span>History Orders</span></a>
</li>



<li class="nav-item">
<a class="nav-link" href="settings.jsp">
<i class="mdi mdi-cog"></i>
<span>Settings</span></a>
</li>

<li class="nav-item">
<a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
<i class="fas fa-fw fa-cog"></i>
<span>Extra Pages</span>
</a>
<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
<div class="bg-white py-2 collapse-inner rounded">
<h6 class="collapse-header">Pages:</h6>
<a class="collapse-item" href="detail.jsp">Details</a>
<a class="collapse-item" href="listing.jsp">Listing</a>
<a class="collapse-item" href="messages.jsp">Messages</a>
<a class="collapse-item" href="search.jsp">Search</a>
<a class="collapse-item" href="buttons.jsp">Components</a>
<a class="collapse-item" href="404.jsp">Page Not Found</a>
<h6 class="collapse-header">Account:</h6>
<a class="collapse-item" href="signin.jsp">Signin</a>
<a class="collapse-item" href="signup.jsp">Signup</a>
<a class="collapse-item" href="forgot.jsp">Forgot Password</a>
</div>
</div>
</li>

<div class="bg-white m-3 p-3 sidebar-alert rounded text-center alert fade show d-none d-md-inline" role="alert">
<button type="button" class="close" data-dismiss="alert" aria-label="Close">
<span aria-hidden="true">&times;</span>
</button>
<i class="mdi mdi-food mb-3"></i>
<p class="text-black mb-1">Free delivery on<br>all orders over <span class="text-primary">$25</span></p>
<p class="small">It is a limited time offer that will expire soon.</p>
<a href="explore.jsp" class="btn btn-primary btn-block btn-sm">Order now <i class="pl-3 fas fa-long-arrow-alt-right"></i></a>
</div>

<!--<div class="d-none d-md-block">
<div class="user d-flex align-items-center p-3">
<div class="pr-3"><i class="mdi mdi-account-circle-outline text-white h3 mb-0"></i></div>
<div>
<p class="mb-0 text-white">Mark Clarke</p>
<p class="mb-0 text-white-50 small"><a href="https://askbootstrap.com/cdn-cgi/l/email-protection" class="__cf_email__" data-cfemail="b4d1ccd5d9c4d8d1f4d3d9d5ddd89ad7dbd9">[email&#160;protected]</a></p>
</div>
</div>
</div>-->

<hr class="sidebar-divider d-none d-md-block">

<div class="text-center d-none d-md-inline">
<button class="rounded-circle border-0" id="sidebarToggle"></button>
</div>
</ul>


<div id="content-wrapper" class="d-flex flex-column">

<div id="content">

<nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow-sm osahan-nav-top">

<button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
<i class="fa fa-bars"></i>
</button>

    <style>
        .dropdown-menu a {
            font-size: 15px;
            
        }
        .caret {
            font-size: 15px;
           
        }
    </style>
    <c:set var="name" value="${sessionScope.custName}" />
        <c:if test="${not empty name}">
           <li class="dropdown">
                                                <a href="#" data-toggle="dropdown" class="dropdown-toggle user-action"><svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
  <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
  <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
</svg>  <b class="caret"> ${sessionScope.custName} </b></a>
                                                <ul class="dropdown-menu">
                                                    <li><a href="#"><i class="fa fa-user-o"></i><svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-person" viewBox="0 0 16 16">
  <path d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6Zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0Zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4Zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10Z"/>
</svg> Profile</a></li>
<!--                                                    <li><a href="#"><i class="fa fa-calendar-o"></i> Calendar</a></li>-->
                                                    <li><a href="settings.jsp"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-sliders" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M11.5 2a1.5 1.5 0 1 0 0 3 1.5 1.5 0 0 0 0-3zM9.05 3a2.5 2.5 0 0 1 4.9 0H16v1h-2.05a2.5 2.5 0 0 1-4.9 0H0V3h9.05zM4.5 7a1.5 1.5 0 1 0 0 3 1.5 1.5 0 0 0 0-3zM2.05 8a2.5 2.5 0 0 1 4.9 0H16v1H6.95a2.5 2.5 0 0 1-4.9 0H0V8h2.05zm9.45 4a1.5 1.5 0 1 0 0 3 1.5 1.5 0 0 0 0-3zm-2.45 1a2.5 2.5 0 0 1 4.9 0H16v1h-2.05a2.5 2.5 0 0 1-4.9 0H0v-1h9.05z"/>
</svg>  Settings</a></li>
                                                    <li class="divider"></li>
                                                    <li><a href="LogOutController"><i class="material-icons">&#xE8AC;</i> Logout</a></li>
                                                </ul>
                                            </li>  
        </c:if>
                             
    
    
<ul class="navbar-nav">

<li class="nav-item dropdown no-arrow d-sm-none">
<a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
<i class="fas fa-search fa-fw"></i>
</a>

<div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in" aria-labelledby="searchDropdown">
<form class="form-inline mr-auto w-100 navbar-search">
<div class="input-group">
<input type="text" class="form-control bg-light" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
<div class="input-group-append">
<button class="btn btn-primary" type="button">
<i class="mdi mdi-magnify"></i>
</button>
</div>
</div>
</form>
</div>
</li>

<!--<li class="nav-item dropdown no-arrow mx-2 osahan-t-loc">
<a class="nav-link dropdown-toggle text-dark" href="#" data-toggle="modal" data-target="#addressModal">
<span class="mdi mdi-crosshairs-gps"></span><span class="ml-2">San Frnciso, california</span>
</a>
</li>-->

 <c:if test="${ empty name}">              
                                            <li class="nav-item dropdown no-arrow mx-2 osahan-t-loc">
<a class="nav-link dropdown-toggle text-dark" href="signin.jsp" >
<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-box-arrow-in-right" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M6 3.5a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v9a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-2a.5.5 0 0 0-1 0v2A1.5 1.5 0 0 0 6.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-8A1.5 1.5 0 0 0 5 3.5v2a.5.5 0 0 0 1 0v-2z"/>
  <path fill-rule="evenodd" d="M11.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H1.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z"/>
</svg><span class="ml-2">Sign in</span>
</a>
</li>

<li class="nav-item dropdown no-arrow mx-2 osahan-t-loc">
<a class="nav-link dropdown-toggle text-dark" href="signup.jsp" >
<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-box-arrow-in-up" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M3.5 10a.5.5 0 0 1-.5-.5v-8a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 .5.5v8a.5.5 0 0 1-.5.5h-2a.5.5 0 0 0 0 1h2A1.5 1.5 0 0 0 14 9.5v-8A1.5 1.5 0 0 0 12.5 0h-9A1.5 1.5 0 0 0 2 1.5v8A1.5 1.5 0 0 0 3.5 11h2a.5.5 0 0 0 0-1h-2z"/>
  <path fill-rule="evenodd" d="M7.646 4.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1-.708.708L8.5 5.707V14.5a.5.5 0 0 1-1 0V5.707L5.354 7.854a.5.5 0 1 1-.708-.708l3-3z"/>
</svg><span class="ml-2">Sign up</span>
</a>
</li>
</c:if>

<li class="nav-item dropdown no-arrow mx-2 osahan-t-pu">
<a class="nav-link dropdown-toggle text-dark" href="orders.jsp">
<i class="mdi mdi-shopping text-danger"></i><span class="ml-2">Pick up</span>
</a>
</li>

<li class="nav-item dropdown no-arrow mx-2 osahan-t-bd">
<a class="nav-link dropdown-toggle text-dark" data-toggle="modal" data-target="#mycoupansModal" href="#">
<i class="mdi mdi-sack-percent text-warning"></i><span class="ml-2">Best Deals</span>
</a>
</li>
</ul>

<div class="ml-auto">
<form class="d-none d-sm-inline-block form-inline mx-2 my-2 my-md-0 mw-100 navbar-search" action="MainController">
<div class="input-group">
<input type="text" class="form-control bg-light text-dark font-weight-bold" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2" name="txtSearchValue" value="">
<div class="input-group-append">
<input class="btn btn-primary" type="submit" value="Find Product" name="btAction" >
<!--<input type="submit" value="Find Product" name="btAction" />-->
<!--<i class="mdi mdi-magnify"></i>-->
<!--</button>-->
</div>
</div>
</form>
<a href="#" class="btn btn-primary " data-toggle="modal" data-target="#filtersModal"><i class="mdi mdi-filter-variant"></i></a>
<a href="#" class="btn btn-danger" data-toggle="modal" data-target="#cartModal"><i class="mdi mdi-shopping-outline"></i></a>
</div>
</nav>


<div class="container-fluid">

<div class="d-flex align-items-center justify-content-between mb-3 mt-2">
<h5 class="mb-0">Fast Delivery</h5>
</div>

<div class="row">

     <c:set var="context" value="${pageContext.request.contextPath}" />
    <c:if test="${not empty requestScope.PRO_RESULT}">
<c:set var="pa" value="${requestScope.PRO_RESULT}"/>
                <c:forEach var="result" items="${requestScope.PRO_RESULT}" varStatus="counter">
                    <!--<form action="MainController">-->
<a href="#" class="text-decoration-none text-dark col-lg-3 col-md-6 mb-4" data-toggle="modal" data-target="#myitemsModal">
    <img src="data:image/jpg;base64,${result.base64ImageData}"  width="200px" height="200px"/>
    
<div class="d-flex align-items-center mt-3 mb-2">
<p class="text-black h6 m-0">${result.proName}</p>
<!--<input class="text-black h6 m-0" type="text" name="txtProname" value="${result.proName}" />-->
<span class="badge badge-light ml-auto"><i class='fas fa-dollar-sign'></i> ${result.price}</span>
</div>
<p class="small mb-2"><i class="mdi mdi-star text-warning"></i> <span class="font-weight-bold text-dark ml-1">4.8</span>(1,873) <i class="mdi mdi-silverware-fork-knife ml-2 mr-1"></i> ${result.catgoryName} <i class="mdi mdi-motorbike ml-2 mr-2"></i>Freeship</p>
</a>
    <!--</form>-->
</c:forEach>
</c:if>
    
        <c:set var="context" value="${pageContext.request.contextPath}" />
        <h1>Hello World!</h1>
        <div>
            <form action="MainController" method="POST">
                Search Keyword: <input type="text" name="txtSearchValue" value="" /> 
                <input type="submit" value="Find Product" name="btAction" />
                <input type="submit" value="SHOWIMG" name="btAction" />
                    

            </form>
        </div>

        
        
    <c:if test="${not empty requestScope.IMG_RESULT}" >
        <table border="1">
            <c:forEach var="img" items="${requestScope.IMG_RESULT}">
                <form action="MainController">
                    <tr>
                        <td><img src="data:image/jpg    ;base64,${img.base64ImageData}" /> </td>
                    </tr>
                    
                </form>
                    
            
                
            </c:forEach>
            <h1>ALO</h1>
        </table>
        
    </c:if>
    <c:if test="${ empty requestScope.IMG_RESULT}">
        <h1>FFF</h1>
    </c:if>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
