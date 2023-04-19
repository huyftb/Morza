<%-- 
    Document   : signup
    Created on : Feb 17, 2023, 6:08:12 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<!-- Mirrored from askbootstrap.com/preview/osahan-eat/theme-sidebar/signup.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 19 Oct 2022 05:04:58 GMT -->
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
<div class="row osahan-login m-0">
<div class="col-md-6 osahan-login-left px-0">
</div>
<div class="col-md-6 d-flex justify-content-center flex-column px-0">
<div class="col-lg-6 mx-auto">
     
<h3 class="mb-1">Create an account</h3>
<p class="mb-5">Please create an account to continue using our service</p>
 <form action="MainController" method="post">
     <c:set var="errors" value="${requestScope.CREATE_ERROR}"/>
<div class="d-flex align-items-center mb-4">
<div class="mr-3 bg-light rounded p-2 osahan-icon"><i class="mdi mdi-account-outline"></i></div>
<div class="w-100">
<p class="mb-0 small font-weight-bold text-dark">Username (6-30 chars)</p>
<input type="text" class="form-control form-control-sm p-0 border-input border-0 rounded-0" placeholder="Enter Your Username" name="txtUsername">
</div>
</div>
 <c:if test="${not empty errors.usernameLengthErr}">
                <font color='red'>
                    ${errors.usernameLengthErr}
                </font><br/>
            </c:if>
<div class="d-flex align-items-center mb-4">
<div class="mr-3 bg-light rounded p-2 osahan-icon"><i class="mdi mdi-form-textbox-password"></i></div>
<div class="w-100">
<p class="mb-0 small font-weight-bold text-dark">Password* (6-20 chars)</p>
<input type="password" class="form-control form-control-sm p-0 border-input border-0 rounded-0" placeholder="Enter Your Password" name="txtPassword">
</div>
</div>
                 <c:if test="${not empty errors.passwordLengthErr}">
                <font color='red'>
                    ${errors.passwordLengthErr}
                </font><br/>
            </c:if>
<div class="d-flex align-items-center mb-4">
<div class="mr-3 bg-light rounded p-2 osahan-icon"><i class="mdi mdi-form-textbox-password"></i></div>
<div class="w-100">
<p class="mb-0 small font-weight-bold text-dark">Confirm password*</p>
<input type="password" name="txtConfirm" class="form-control form-control-sm p-0 border-input border-0 rounded-0" placeholder="Confirm Your Password">
</div>
</div>
    <c:if test="${not empty errors.confirmNotMatchErr}">
                <font color='red'>
                    ${errors.confirmNotMatchErr}
                </font><br/>
            </c:if>  

     
     <div class="d-flex align-items-center mb-4">
<div class="mr-3 bg-light rounded p-2 osahan-icon"><i class="mdi mdi-form-textbox"></i></div>
<div class="w-100">
<p class="mb-0 small font-weight-bold text-dark">Fullname (2-50 chars)</p>
<input type="text" name="txtFullname" class="form-control form-control-sm p-0 border-input border-0 rounded-0" placeholder="Enter Your Fullname">
</div>
</div>
     <c:if test="${not empty errors.fullnameLengthErr}">
                <font color='red'>
                    ${errors.fullnameLengthErr}
                </font><br/>
            </c:if>
     <div class="d-flex align-items-center mb-4">
<div class="mr-3 bg-light rounded p-2 osahan-icon"><i class="mdi mdi-map-marker-outline"></i></div>
<div class="w-100">
<p class="mb-0 small font-weight-bold text-dark">Address</p>
<input type="text" name="txtAddress" class="form-control form-control-sm p-0 border-input border-0 rounded-0" placeholder="Enter Your Address">
</div>
</div>
     
          <div class="d-flex align-items-center mb-4">
<div class="mr-3 bg-light rounded p-2 osahan-icon"><i class="mdi mdi-phone-dial"></i></div>
<div class="w-100">
<p class="mb-0 small font-weight-bold text-dark">Phone number</p>
<input type="text" name="txtPhoneNum" class="form-control form-control-sm p-0 border-input border-0 rounded-0" placeholder="Enter Your Phone Number">
</div>
</div>
      <c:if test="${not empty errors.phoneNumLengthErr}">
                <font color='red'>
                    ${errors.phoneNumLengthErr}
                </font><br/>
            </c:if>
     <div class="d-flex align-items-center mb-4">
<div class="mr-3 bg-light rounded p-2 osahan-icon"><i class="mdi mdi-email-outline"></i></i></div>
<div class="w-100">
<p class="mb-0 small font-weight-bold text-dark">Email</p>
<input type="text" name="txtEmail" class="form-control form-control-sm p-0 border-input border-0 rounded-0" placeholder="Enter Your Email">
</div>
</div>
                 <c:if test="${not empty errors.emailSyntaxErr}">
                <font color='red'>
                    ${errors.emailSyntaxErr}
                </font><br/>
            </c:if>
      <!--<button type="submit" class="btn btn-primary" name="btAction">Sign up</button>-->
      <input type="submit" class="btn btn-primary" name="btAction" value="Sign up"/>
<div class="mb-3">
<!--<a href="index.jsp" class="btn btn-primary btn-block mb-3">Create an account</a>-->
<p class="text-center">Already have an account? <a href="signin.jsp" class="text-danger text-decoration-none">Sign in</a></p>
<p class="text-center">Return <a href="index.jsp" class="text-danger text-decoration-none">Home Page</a>
</div>
        <c:if test="${not empty errors.usernameExisted}">
                <font color='red'>
                    ${errors.usernameExisted}
                </font><br/>
            </c:if>
            <c:if test="${not empty errors.errorMsg}">
                <font color='red'>
                    ${errors.errorMsg}
                </font><br/>
            </c:if>
</form>
</div>
</div>
</div>

<script src="vendor/jquery/jquery.min.js" type="105ae87169facef54e7f3cf4-text/javascript"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js" type="105ae87169facef54e7f3cf4-text/javascript"></script>

<script src="vendor/jquery-easing/jquery.easing.min.js" type="105ae87169facef54e7f3cf4-text/javascript"></script>

<script src="js/osahan.min.js" type="105ae87169facef54e7f3cf4-text/javascript"></script>
<script src="js/rocket-loader.min.js" data-cf-settings="105ae87169facef54e7f3cf4-|49" defer=""></script><script defer src="https://static.cloudflareinsights.com/beacon.min.js/v652eace1692a40cfa3763df669d7439c1639079717194" integrity="sha512-Gi7xpJR8tSkrpF7aordPZQlW2DLtzUlZcumS8dMQjwDHEnw9I7ZLyiOj/6tZStRBGtGgN6ceN6cMH8z7etPGlw==" data-cf-beacon='{"rayId":"75c6f94d7bbf7eba","version":"2022.10.3","r":1,"token":"dd471ab1978346bbb991feaa79e6ce5c","si":100}' crossorigin="anonymous"></script>
</body>

<!-- Mirrored from askbootstrap.com/preview/osahan-eat/theme-sidebar/signup.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 19 Oct 2022 05:04:58 GMT -->
</html>