<%-- 
    Document   : index.jsp
    Created on : Feb 17, 2023, 6:00:01 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<!-- Mirrored from askbootstrap.com/preview/osahan-eat/theme-sidebar/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 19 Oct 2022 05:04:56 GMT -->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<c:set var="name" value="${sessionScope.custName}" />
<c:if test="${not empty name}">
<link rel="icon" type="image/png" href="loginHomePage.jsp">
</c:if>
<title>MORZA</title>


<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

<link href="css/osahan.css" rel="stylesheet">

<link href="font/stylesheet.css" rel="stylesheet">

<link href="vendor/mdi-icons/css/materialdesignicons.min.css" rel="stylesheet">

<link href="css/custom.css" rel="stylesheet">


 <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="path/to/materialize.css">
</head>
<body id="page-top">

<div id="wrapper">

<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

<a class="sidebar-brand d-flex align-items-center" href="index.jsp">
<div class="sidebar-brand-icon">
<img src="img/logo.png" class="img-fluid">
</div>
</a>

<li class="nav-item active">
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



<div class="bg-white m-3 p-3 sidebar-alert rounded text-center alert fade show d-none d-md-inline" role="alert">
<button type="button" class="close" data-dismiss="alert" aria-label="Close">
<span aria-hidden="true">&times;</span>
</button>
<i class="mdi mdi-food mb-3"></i>
<p class="text-black mb-1">Free delivery on<br>all orders over <span class="text-primary">$25</span></p>
<p class="small">It is a limited time offer that will expire soon.</p>
<a href="listProduct" class="btn btn-primary btn-block btn-sm">Order now <i class="pl-3 fas fa-long-arrow-alt-right"></i></a>
</div>



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

</div>
</div>
</form>
<a href="#" class="btn btn-primary " ><i class="mdi mdi-filter-variant"></i></a>
<a href="viewCart.jsp" class="btn btn-danger" ><i class="mdi mdi-shopping-outline"></i></a>
</div>
</nav>


<div class="container-fluid">


<div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img class="d-block w-100" src="img/banner/banner.png" alt="First slide" height="450px">
    </div>
    <div class="carousel-item">
      <img class="d-block w-100" src="img/banner/fresh-fruit.-colorful.jpg" alt="Second slide" height="450px">
    </div>
    <div class="carousel-item">
      <img class="d-block w-100" src="img/banner/shipban.png" alt="Third slide"height="450px">
    </div>
  </div>
  <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>


<br></br>

<div class="d-flex align-items-center justify-content-between mb-3 mt-2">
<h5 class="mb-0">CATEGORY</h5>

</div>

<div class="row">

<a href="ShowProductInDrinkCategory" class="text-dark text-decoration-none col-xl-4 col-lg-12 col-md-12">
<div class="bg-white shadow-sm rounded d-flex align-items-center p-1 mb-2 osahan-list">
<!--<div class="bg-light p-0 rounded">-->
    <img src="img/drink/drink.jpg" class="img-fluid" width="100px" height="100px">
<!--</div>-->
<div class="mx-3 py-2 w-100">
<p class="mb-2 text-black">DRINK</p>
<p class="small mb-2">
<i class="mdi mdi-star text-warning mr-1"></i> <span class="font-weight-bold text-dark">0.8</span> (873)
<!--<i class="mdi mdi-silverware-fork-knife ml-3 mr-1"></i> Burger-->
<!--<i class="mdi mdi-currency-inr ml-3"></i> 340/--->
</p>
<p class="mb-0 text-muted d-flex align-items-center"><span class="badge badge-light"><i class="mdi mdi-truck-fast-outline"></i> Free delivery</span>
 <!--<span class="small ml-auto"><i class="mdi mdi-map-marker"></i> 0.3 km</span>-->
</p>
</div>
</div>
</a>
    
    
    
<a href="ShowProductInFishCategory" class="text-dark text-decoration-none col-xl-4 col-lg-12 col-md-12">
<div class="bg-white shadow-sm rounded d-flex align-items-center p-1 mb-2 osahan-list">
<!--<div class="bg-light p-0 rounded">-->
    <img src="img/banner/fishsuper.jpg" class="img-fluid" width="100px" height="100px">
<!--</div>-->
<div class="mx-3 py-2 w-100">
<p class="mb-2 text-black">SEA FOOD</p>
<p class="small mb-2">
<i class="mdi mdi-star text-warning mr-1"></i> <span class="font-weight-bold text-dark">0.8</span> (873)
<!--<i class="mdi mdi-silverware-fork-knife ml-3 mr-1"></i> Burger-->
<!--<i class="mdi mdi-currency-inr ml-3"></i> 340/--->
</p>
<p class="mb-0 text-muted d-flex align-items-center"><span class="badge badge-light"><i class="mdi mdi-truck-fast-outline"></i> Free delivery</span>
 <!--<span class="small ml-auto"><i class="mdi mdi-map-marker"></i> 0.3 km</span>-->
</p>
</div>
</div>
</a>
    
    
    
    <a href="ShowProductInFruitCategory" class="text-dark text-decoration-none col-xl-4 col-lg-12 col-md-12">
<div class="bg-white shadow-sm rounded d-flex align-items-center p-1 mb-2 osahan-list">
<!--<div class="bg-light p-0 rounded">-->
    <img src="img/banner/fruit.jpg" class="img-fluid" width="100px" height="100px">
<!--</div>-->
<div class="mx-3 py-2 w-100">
<p class="mb-2 text-black">FRUIT</p>
<p class="small mb-2">
<i class="mdi mdi-star text-warning mr-1"></i> <span class="font-weight-bold text-dark">0.8</span> (873)
<!--<i class="mdi mdi-silverware-fork-knife ml-3 mr-1"></i> Burger-->
<!--<i class="mdi mdi-currency-inr ml-3"></i> 340/--->
</p>
<p class="mb-0 text-muted d-flex align-items-center"><span class="badge badge-light"><i class="mdi mdi-truck-fast-outline"></i> Free delivery</span>
 <!--<span class="small ml-auto"><i class="mdi mdi-map-marker"></i> 0.3 km</span>-->
</p>
</div>
</div>
</a>
    
    
    
    <a href="ShowProductInMeatCategory" class="text-dark text-decoration-none col-xl-4 col-lg-12 col-md-12">
<div class="bg-white shadow-sm rounded d-flex align-items-center p-1 mb-2 osahan-list">
<!--<div class="bg-light p-0 rounded">-->
    <img src="img/banner/meat.jpg" class="img-fluid" width="100px" height="100px">
<!--</div>-->
<div class="mx-3 py-2 w-100">
<p class="mb-2 text-black">MEAT</p>
<p class="small mb-2">
<i class="mdi mdi-star text-warning mr-1"></i> <span class="font-weight-bold text-dark">0.8</span> (873)
<!--<i class="mdi mdi-silverware-fork-knife ml-3 mr-1"></i> Burger-->
<!--<i class="mdi mdi-currency-inr ml-3"></i> 340/--->
</p>
<p class="mb-0 text-muted d-flex align-items-center"><span class="badge badge-light"><i class="mdi mdi-truck-fast-outline"></i> Free delivery</span>
 <!--<span class="small ml-auto"><i class="mdi mdi-map-marker"></i> 0.3 km</span>-->
</p>
</div>
</div>
</a>
    
    
    
    <a href="ShowProductInMilkCategory" class="text-dark text-decoration-none col-xl-4 col-lg-12 col-md-12">
<div class="bg-white shadow-sm rounded d-flex align-items-center p-1 mb-2 osahan-list">
<!--<div class="bg-light p-0 rounded">-->
    <img src="img/milk/milkSuper.jpg" class="img-fluid" width="100px" height="100px">
<!--</div>-->
<div class="mx-3 py-2 w-100">
<p class="mb-2 text-black">MILK</p>
<p class="small mb-2">
<i class="mdi mdi-star text-warning mr-1"></i> <span class="font-weight-bold text-dark">0.8</span> (873)
<!--<i class="mdi mdi-silverware-fork-knife ml-3 mr-1"></i> Burger-->
<!--<i class="mdi mdi-currency-inr ml-3"></i> 340/--->
</p>
<p class="mb-0 text-muted d-flex align-items-center"><span class="badge badge-light"><i class="mdi mdi-truck-fast-outline"></i> Free delivery</span>
 <!--<span class="small ml-auto"><i class="mdi mdi-map-marker"></i> 0.3 km</span>-->
</p>
</div>
</div>
</a>
    
    
    
    <a href="ShowProductInVegetableCategory" class="text-dark text-decoration-none col-xl-4 col-lg-12 col-md-12">
<div class="bg-white shadow-sm rounded d-flex align-items-center p-1 mb-2 osahan-list">
<!--<div class="bg-light p-0 rounded">-->
<img src="img/vegetable/vegeSuper.jpg" class="img-fluid" width="100px" height="100px">
<!--</div>-->
<div class="mx-3 py-2 w-100">
<p class="mb-2 text-black">VEGETABLE</p>
<p class="small mb-2">
<i class="mdi mdi-star text-warning mr-1"></i> <span class="font-weight-bold text-dark">0.8</span> (873)
<!--<i class="mdi mdi-silverware-fork-knife ml-3 mr-1"></i> Burger-->
<!--<i class="mdi mdi-currency-inr ml-3"></i> 340/--->
</p>
<p class="mb-0 text-muted d-flex align-items-center"><span class="badge badge-light"><i class="mdi mdi-truck-fast-outline"></i> Free delivery</span>
 <!--<span class="small ml-auto"><i class="mdi mdi-map-marker"></i> 0.3 km</span>-->
</p>
</div>
</div>
</a>
</div>
      <div class="container-fluid">

                        <div class="d-flex align-items-center justify-content-between mb-3 mt-2">
                            <h5 class="mb-0">Our product</h5>
                            <a href="listProduct" class="small font-weight-bold text-dark">See all <i class="mdi mdi-chevron-right mr-2"></i></a>
                        </div>
<div class="row">


<div class="text-decoration-none col-xl-3 col-md-4 mb-4">
 
<div class="card" style="width: 18rem;">
  <img class="card-img-top" src="img/banner/vege.jpg" alt="Card image cap">
  <div class="card-body">
    <p class="card-text">We pride ourselves on providing only the highest quality vegetables, grown using sustainable farming.Taste the difference with our premium vegetable selection today!.</p>
  </div>
</div>
    </div>
<div class="text-decoration-none col-xl-3 col-md-4 mb-4">
<div class="card" style="width: 18rem;">
  <img class="card-img-top" src="img/banner/dairy.jpg" alt="Card image cap">
  <div class="card-body">
    <p class="card-text"> Our delicious and nutritious dairy products are made with the highest quality ingredients and packed with wholesome goodness.So why settle for anything less? Try our dairy products today and taste the difference for yourself!</p>
  </div>
</div>
    </div>
<div class="text-decoration-none col-xl-3 col-md-4 mb-4">
<div class="card" style="width: 18rem;">
  <img class="card-img-top" src="img/banner/meat.jpg" alt="Card image cap">
  <div class="card-body">
    <p class="card-text">Our meat is sourced from local farms and suppliers, ensuring that it is always fresh and free of any added hormones or antibiotics. Come taste the difference for yourself and experience the best in fresh meat and fish!</p>
  </div>
</div>
    </div>
<div class="text-decoration-none col-xl-3 col-md-4 mb-4">
<div class="card" style="width: 18rem;">
  <img class="card-img-top" src="img/banner/bakedgoods.jpg" alt="Card image cap">
  <div class="card-body">
    <p class="card-text">All of our sweets are made fresh daily, ensuring maximum flavor and quality. So why not treat yourself or a loved one to a box of our sweets today? Trust us, your taste buds will thank you!</p>
  </div>
</div>
    </div>

</div>

</div>

</div>


<footer class="sticky-footer bg-white">
<div class="container my-auto">
<div class="copyright text-center my-auto">
<span>Copyright &copy; Your Website 2020</span>
</div>
</div>
</footer>

</div>

</div>



<script data-cfasync="false" src="js/email-decode.min.js"></script><script src="vendor/jquery/jquery.min.js" type="e83057937dd4e85910db8985-text/javascript"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js" type="e83057937dd4e85910db8985-text/javascript"></script>

<script src="vendor/jquery-easing/jquery.easing.min.js" type="e83057937dd4e85910db8985-text/javascript"></script>

<script src="js/osahan.min.js" type="e83057937dd4e85910db8985-text/javascript"></script>
<script src="js/rocket-loader.min.js" data-cf-settings="e83057937dd4e85910db8985-|49" defer=""></script><script defer src="https://static.cloudflareinsights.com/beacon.min.js/v652eace1692a40cfa3763df669d7439c1639079717194" integrity="sha512-Gi7xpJR8tSkrpF7aordPZQlW2DLtzUlZcumS8dMQjwDHEnw9I7ZLyiOj/6tZStRBGtGgN6ceN6cMH8z7etPGlw==" data-cf-beacon='{"rayId":"75c6f93a1e227d56","version":"2022.10.3","r":1,"token":"dd471ab1978346bbb991feaa79e6ce5c","si":100}' crossorigin="anonymous"></script>


 <script src="path/to/your/bundle.js"></script>

</body>

<!-- Mirrored from askbootstrap.com/preview/osahan-eat/theme-sidebar/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 19 Oct 2022 05:04:56 GMT -->
</html>
