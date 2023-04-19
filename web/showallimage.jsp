<%-- 
    Document   : indexe828
    Created on : Feb 17, 2023, 6:21:27 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<!-- Mirrored from askbootstrap.com/preview/osahan-eat/theme-sidebar/index.html?fbclid=IwAR0nwIFNYzgqHa21f49Nzv1kLbeDTnnIQIEIfRudCclQdwQMDTmsCY1Ovq4 by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 19 Oct 2022 05:04:30 GMT -->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" type="image/png" href="img/logo.png">
<title>ADMIN DASHBOARD</title>

<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

<link href="css/osahan.css" rel="stylesheet">

<link href="font/stylesheet.css" rel="stylesheet">

<link href="vendor/mdi-icons/css/materialdesignicons.min.css" rel="stylesheet">

<link href="css/custom.css" rel="stylesheet">
</head>
<body id="page-top">

<div id="wrapper">

<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

<a class="sidebar-brand d-flex align-items-center" href="admin.jsp">
<div class="sidebar-brand-icon">
<img src="img/logo.png" class="img-fluid">
</div>
</a>

<li class="nav-item active">
<a class="nav-link" href="admin.jsp">
<i class="mdi mdi-home-variant-outline"></i>
<span>Home</span></a>
</li>




<!--<li class="nav-item">
<a class="nav-link" href="HistoryOrderController?username=${sessionScope.username}">
<i class="mdi mdi-book-open"></i>
<span>History Orders</span></a>
</li>



<li class="nav-item">
<a class="nav-link" href="settings.jsp">
<i class="mdi mdi-cog"></i>
<span>Settings</span></a>
</li>-->



<div class="bg-white m-3 p-3 sidebar-alert rounded text-center alert fade show d-none d-md-inline" role="alert">
<button type="button" class="close" data-dismiss="alert" aria-label="Close">
<span aria-hidden="true">&times;</span>
</button>
<i class="mdi mdi-food mb-3"></i>
<p class="text-black mb-1">Free delivery on<br>all orders over <span class="text-primary">$25</span></p>
<p class="small">It is a limited time offer that will expire soon.</p>
<a href="listProduct" class="btn btn-primary btn-block btn-sm">Order now <i class="pl-3 fas fa-long-arrow-alt-right"></i></a>
</div>

<!--<div class="d-none d-md-block">
<div class="user d-flex align-items-center p-3">
<div class="pr-3"><i class="mdi mdi-account-circle-outline text-white h3 mb-0"></i></div>
<div>
<p class="mb-0 text-white">Mark Clarke</p>
<p class="mb-0 text-white-50 small"><a href="https://askbootstrap.com/cdn-cgi/l/email-protection" class="__cf_email__" data-cfemail="afcad7cec2dfc3caefc8c2cec6c381ccc0c2">[email&#160;protected]</a></p>
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

    <li class="dropdown">
                                                <a href="#" data-toggle="dropdown" class="dropdown-toggle user-action"><svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
  <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
  <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
  </svg>  <b class="caret"> Admin </b></a>
                                                <ul class="dropdown-menu">
                                                    <li><a href="#"><i class="fa fa-user-o"></i><svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-person" viewBox="0 0 16 16">
  <path d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6Zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0Zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4Zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10Z"/>
</svg> Profile</a></li>
<!--                                                    <li><a href="#"><i class="fa fa-calendar-o"></i> Calendar</a></li>-->
                                                    <li><a href="#"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-sliders" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M11.5 2a1.5 1.5 0 1 0 0 3 1.5 1.5 0 0 0 0-3zM9.05 3a2.5 2.5 0 0 1 4.9 0H16v1h-2.05a2.5 2.5 0 0 1-4.9 0H0V3h9.05zM4.5 7a1.5 1.5 0 1 0 0 3 1.5 1.5 0 0 0 0-3zM2.05 8a2.5 2.5 0 0 1 4.9 0H16v1H6.95a2.5 2.5 0 0 1-4.9 0H0V8h2.05zm9.45 4a1.5 1.5 0 1 0 0 3 1.5 1.5 0 0 0 0-3zm-2.45 1a2.5 2.5 0 0 1 4.9 0H16v1h-2.05a2.5 2.5 0 0 1-4.9 0H0v-1h9.05z"/>
</svg>  Settings</a></li>
                                                    <li class="divider"></li>
                                                    <li><a href="LogOutController"><i class="material-icons">&#xE8AC;</i> Logout</a></li>
                                                </ul>
                                            </li>   
    
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

<li class="nav-item dropdown no-arrow mx-2 osahan-t-pu">
<a class="nav-link dropdown-toggle text-dark" href="listProduct">
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
    
    
    <style>
 .table-responsive {
        margin: -50px 0;
    }
	.table-wrapper {
        min-width: 1000px;
        background: #fff;
        padding: 20px 25px;
		border-radius: 3px;
                width: 1440px;
        box-shadow: 0 1px 1px rgba(0,0,0,.05);
    }
	.table-title {
		    padding-bottom: 15px;
    background: #c60021;
    color: white;
    padding: 16px 30px;
    margin: -10px -30px 20px;
    width: 1440px;
    border-radius: 3px 3px 0 0
    }
    .table-title h2 {
		margin: 5px 0 0;
		font-size: 24px;
	}
	.table-title .btn {
		color: #566787;
		float: right;
		font-size: 13px;
		background: #fff;
		border: none;
		min-width: 50px;
		border-radius: 2px;
		border: none;
		outline: none !important;
		margin-left: 10px;
	}
	.table-title .btn:hover, .table-title .btn:focus {
        color: #566787;
       
	}
	.table-title .btn i {
		float: left;
		font-size: 21px;
		margin-right: 5px;
	}
	.table-title .btn span {
		float: left;
		margin-top: 2px;
	}
    table.table tr th, table.table tr td {
        border-color: #e9e9e9;
		padding: 12px 15px;
		vertical-align: middle;
    }
	table.table tr th:first-child {
		width: 60px;
	}
	table.table tr th:last-child {
		width: 100px;
	}
    table.table-striped tbody tr:nth-of-type(odd) {
    	/*background-color: ;*/
	}
	table.table-striped.table-hover tbody tr:hover {
		
	}
    table.table th i {
        font-size: 13px;
        margin: 0 5px;
        cursor: pointer;
    }	
    table.table td:last-child i {
		opacity: 0.9;
		font-size: 22px;
        margin: 0 5px;
    }
	table.table td a {
		font-weight: bold;
		color: #566787;
		display: inline-block;
		text-decoration: none;
	}
	table.table td a:hover {
		color: #2196F3;
	}
	table.table td a.settings {
        color: #2196F3;
    }
    table.table td a.delete {
        color: #F44336;
    }
    table.table td i {
        font-size: 19px;
    }
	table.table .avatar {
		border-radius: 50%;
		vertical-align: middle;
		margin-right: 10px;
	}
	.status {
		font-size: 30px;
		margin: 2px 2px 0 0;
		display: inline-block;
		vertical-align: middle;
		line-height: 10px;
	}
        h2 {
            color: white;
        }
        h3 {
            color:#c60021
        }
</style>
<c:set var="context" value="${pageContext.request.contextPath}" />
<div class="container"> <br></br>
    <div class="table-responsive">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-xs-5">
                        <h2>Product <b>Management</b></h2>
                    </div>
                    <div class="col-xs-7">
                        <a href="admin.jsp" class="btn btn-primary"><span>Manage Account</span></a>
                        <!--<a href="#" class="btn btn-primary"> <span>Export to Excel</span></a>-->						
                    </div>
                    <a href="DirectCreateProductController" class="btn btn-primary"><span>Create </span></a>
                </div>
            </div>
            <div>
            <form action="MainController" method="POST">
                Search Keyword: <input type="text" name="txtSearchValue" value="" /> 
                <input type="submit" value="Find" name="btAction" />
                 <input type="submit" value="Show all product" name="btAction" />


            </form>
           
        </div><br/>
        <c:if test="${not empty requestScope.IMG_RESULT}" >
            
            <table class="table table-striped table-hover">
                <thead>
                     <tr class="row">
                         <th class="col-1">No.</th>
                         <th class="col-1">Image</th>                 
                        <th class="col-1">Product Name</th>
                        <th class="col-1">description</th>
                        <th class="col-1">Year Publish</th>
                        <th class="col-1">Price</th>
                        <th class="col-1">Category</th> 
                        <th class="col-1">Update</th>                     
                        <th class="col-1">Delete</th>                     
                        <!--<th>Details</th>-->                     
                    </tr>
                </thead>
                <c:set var="pro" value="${requestScope.PRO}"/>
                 <c:set var="pa" value="${requestScope.PRO_RESULT}"/>
                <c:forEach var="img" items="${requestScope.IMG_RESULT}" varStatus="counter">
                     <form action="MainController">
                <tbody >
                <style>
                    img {
                        width: 60px;
                        height: 60px;
                    }
                </style>
                    <tr class="row">
                        <td class="col-1">
                                ${counter.count}
                                .</td>
                        <td class="col-1"><img src="data:image/jpg    ;base64,${img.base64ImageData}" /> </td>

                        <td class="col-1"> <input type="hidden" name="txtProname" 
                                       value="${img.proName}" />
                        ${img.proName}</td>
                        <td class="col-1"> 
                            <input type="hidden" name="txtProdes" 
                                       value="${img.description}" />${img.description}</td>                        
                        <td class="col-1">
                             <input type="hidden" name="txtYearPublish" 
                                       value="${img.yearPublish}" />${img.yearPublish}</td>
                        <td class="col-1"><input type="hidden" name="txtPrice" 
                                       value="${img.price}" />${img.price}</td>
                        <td class="col-1">
                             <input type="hidden" name="txtCateName" 
                                       value="${img.catgoryName}" />${img.catgoryName}
                        </td>
                      <td class="col-1">
                                <input type="hidden" name="txtProID" 
                                       value="${img.productID}" />
                                <input type="submit" value="Update Product" name="btAction" />
                            </td>
<!--                             <td>
                                <input type="hidden" name="txtProID" 
                                       value="${img.productID}" />
                                <input type="submit" value="Delete Product" name="btAction" />
                            </td>-->
                             <td>
                                <input type="hidden" name="txtProID" 
                                       value="${img.productID}" />
                                <input type="submit" value="Disable Product" name="btAction" />
                            </td>
<!--                             <td>
                                <input type="hidden" name="txtProID" 
                                       value="${img.productID}" />
                                <input type="submit" value="up Product" name="btAction" />
                            </td>-->
<!--                              <td>
                                <input type="hidden" name="txtProID" 
                                       value="${img.productID}" />
                                <input type="submit" value="Details" name="btAction" />

                            </td>-->

                    </tr>

                    </form>
                 </c:forEach>
                 
            </tbody>
        </table>

    </c:if>



        </div>
       
    </div>      
      <c:if test="${ empty requestScope.IMG_RESULT}">
        <h3>
            Can't find the match product!!!
        </h3>

       
    </c:if>
</div>    

<script data-cfasync="false" src="js/email-decode.min.js"></script><script src="vendor/jquery/jquery.min.js" type="4673c51028ea841130b80adc-text/javascript"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js" type="4673c51028ea841130b80adc-text/javascript"></script>

<script src="vendor/jquery-easing/jquery.easing.min.js" type="4673c51028ea841130b80adc-text/javascript"></script>

<script src="js/osahan.min.js" type="4673c51028ea841130b80adc-text/javascript"></script>
<script src="js/rocket-loader.min.js" data-cf-settings="4673c51028ea841130b80adc-|49" defer=""></script><script defer src="https://static.cloudflareinsights.com/beacon.min.js/v652eace1692a40cfa3763df669d7439c1639079717194" integrity="sha512-Gi7xpJR8tSkrpF7aordPZQlW2DLtzUlZcumS8dMQjwDHEnw9I7ZLyiOj/6tZStRBGtGgN6ceN6cMH8z7etPGlw==" data-cf-beacon='{"rayId":"75c6f9299e967d56","version":"2022.10.3","r":1,"token":"dd471ab1978346bbb991feaa79e6ce5c","si":100}' crossorigin="anonymous"></script>



</body>

 <!--Mirrored from askbootstrap.com/preview/osahan-eat/theme-sidebar/index.html?fbclid=IwAR0nwIFNYzgqHa21f49Nzv1kLbeDTnnIQIEIfRudCclQdwQMDTmsCY1Ovq4 by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 19 Oct 2022 05:04:46 GMT--> 
</html>