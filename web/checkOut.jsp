<%-- 
    Document   : checkOut
    Created on : Mar 13, 2023, 9:27:18 PM
    Author     : thehu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--<html>
    <head>
        <title>Checkout</title>
    </head>
    <body>
        <h1>Checkout</h1>
        <c:if test="${not empty sessionScope.cartP}">
            <h2>Items in Cart:</h2>
            <table>
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Quantity</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${sessionScope.cartP}">
                        <tr>
                            <td>${item.key.proName}</td>
                            <td>${item.key.price}</td>
                            <td>${item.value}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
        <form method="post" action="MainController">
            <label for="paymentType">Payment Type:</label>
            <select name="paymentType" id="paymentType" onchange="showCardInfo()">
                <option value="Visa">Visa</option>
                <option value="Mastercard">Mastercard</option>
                <option value="COD">COD</option>
            </select>
            <div id="cardInfo" style="display:none">
                <label for="cardNumber">Card Number:</label>
                <input type="tstCardNum" name="cardNumber" id="cardNumber" />
                <br />
                <label for="cardName">Card Name:</label>
                <input type="txtCardName" name="cardName" id="cardName" />
                <br />
                <label for="securityNumber">Security Number:</label>
                <input type="txtSerNum" name="securityNumber" id="securityNumber" />
                <br />
            </div>
            <button type="submit" name="btAction" value="PlaceOrder">Place Order</button>
            <button type="submit" name="btAction" value="CheckPayment">Check Payment</button>
        </form>


        <c:if test="${not empty sessionScope.cartP}">
            <form method="POST" action="InsertOrderController">
                <h2>Customer Information:</h2>
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" required><br>
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required><br>
                <label for="address">Address:</label>
                <textarea id="address" name="address" required></textarea><br>
                <input type="submit" value="Proceed to Checkout">

            </form>
        </c:if>
        <c:if test="${empty sessionScope.cartP}">
            <p>Your cart is empty.</p>
        </c:if>
        <script>
            function showCardInfo() {
                var select = document.getElementById("paymentType");
                var cardInfo = document.getElementById("cardInfo");
                if (select.value === "Visa" || select.value === "Mastercard") {
                    cardInfo.style.display = "block";
                } else {
                    cardInfo.style.display = "none";
                }
            }
        </script>
    </body>
</html>-->
<!DOCTYPE html>
<html>
<head>
     <title>MORZA</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
       <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <link href="css/osahan.css" rel="stylesheet">

        <link href="font/stylesheet.css" rel="stylesheet">

        <link href="vendor/mdi-icons/css/materialdesignicons.min.css" rel="stylesheet">

        <link href="css/custom.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="path/to/materialize.css">
</head>
<body>
<c:set var="name" value="${sessionScope.custName}" />
<c:if test="${empty name}">
                            <div class="container-fluid">
                                <div class="card mt-50 mb-50">
<div class="text-center py-5 my-lg-5">

<p class="lead text-gray-800 mb-5"><a href="signin.jsp">SIGN IN</a></p>
<p class="text-gray-500 mb-0">You need to sign in to place an order..</p>
<a href="index.jsp">&larr; Back to Dashboard</a>
</div>
</div>
                        </c:if>
<c:if test="${not empty name}">
<!--<h2 style="text-align: center" style="font-weight: bold" style="color: g">Checkout</h2>-->
<!--<p>Resize the browser window to see the effect. When the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other.</p>-->
<div class="row">
  <div class="col-75">
    <div class="container">
        
        <c:if test="${not empty sessionScope.cartP}">
      <form method="POST" action="InsertOrderController">
      
        <div class="row">
          <div class="col-50">
            <h3>Billing Address</h3>
           <label for="name"><i class="fa fa-user"></i>Name</label>
            <input type="text" id="name" name="name" required>
           <label for="email"><i class="fa fa-envelope"></i> Email</label>
<input type="email" id="email" name="email" required><br>
            <label for="phone"><i class="fa fa-phone"></i> Phone Number</label>
<input type="tel" id="phone" name="phone" pattern="[0-9]{10}" required><br>
            <label for="address"><i class="fa fa-address-card-o"></i> Address</label>
            <textarea id="address" name="address" required></textarea><br>
            
              
            
           
            
         
              <input type="submit" value="Place Order" class="btn">
             
         </c:if>
             <c:if test="${empty sessionScope.cartP}">
            <p>Your cart is empty.</p>
        </c:if>


          </div>

          <div class="col-50">
            <h3>Payment</h3>
            <label for="fname">Accepted Cards</label>
            <div class="icon-container">
              <i class="fa fa-cc-visa" style="color:navy;"></i>
            
              <i class="fa fa-cc-mastercard" style="color:red;"></i>
             
            </div>
          <form method="post" action="PayingController">
            <label for="paymentType">Payment Type:</label>
            <select name="paymentType" id="paymentType" onchange="showCardInfo()">
                <option value="COD">COD</option>
                <option value="Visa">Visa</option>
                <option value="Mastercard">Mastercard</option>
               
            </select>
            <div id="cardInfo" style="display:none">
                <label for="cardNumber">Card Number:</label>
                <input type="tstCardNum" name="cardNumber" id="cardNumber" />
                <br />
                <label for="cardName">Card Name:</label>
                <input type="txtCardName" name="cardName" id="cardName" />
                <br />
                <label for="securityNumber">Security Number:</label>
                <input type="txtSerNum" name="securityNumber" id="securityNumber" />
                <br><br />
            </div>
<!--            <button type="submit" name="btAction" value="PlaceOrder">Place Order</button>
            <button type="submit" name="btAction" value="CheckPayment">Check Payment</button>-->
        </form>
          </div>
          
        </div>
        
       
      </form>
    </div>
  </div>
    
  <c:if test="${not empty sessionScope.cartP}">
  <div class="col-25">
    <div class="container">
         <h4 style="font-weight:bold" >Your Order </h4>
           <div class="container text-left">
  <div class="row">
    <div class="col" style="font-weight:bold">
      Products
    </div>
    <div class="col" style="font-weight:bold">
      Quantity
    </div>
    <div class="col" style="font-weight:bold">
      Price
    </div>
  </div>
</div>
          <div class="container text-left">
        <c:forEach var="item" items="${sessionScope.cartP}">
           
  <div class="row">
    <div class="col">
      ${item.key.proName}
    </div>
    <div class="col">
      ${item.value}
        <c:set var="quantity" value="${item.value}" />
                                      
    </div>
    <div class="col">
    <i class='fas fa-dollar-sign'></i> ${item.key.price}
     <c:set var="itemTotal" value="${item.key.price * quantity}"/>
                                    <c:set var="orderTotal" value="${orderTotal + item.key.price * quantity}" />
                                    <!--<div color="black">    <i class='fas fa-dollar-sign'></i>   ${itemTotal} </div>-->
    </div>
  </div>

        
       </c:forEach>
</div>
     <div class="row" style="border-top: 1px solid rgba(0,0,0,.1); padding: 2vh 0;">
                        <div class="col-8">TOTAL PRICE</div>
                        <div class="col-4">
                              
                                        
                                    <c:set var="itemTotal" value="${item.key.price * quantity}"/>
                                    <c:set var="orderTotal" value="${orderTotal}" />
                                 <i class='fas fa-dollar-sign'></i> ${orderTotal}
                        </div>
                    </div>
    </div>
      
  </div>
  </c:if>
</div>
</c:if>
</div>
<style>
body {
    padding-top: -50px;
   
  font-family: Arial;
  font-size: 17px;
  padding: 8px;
}

* {
  box-sizing: border-box;
}

.row {
  display: -ms-flexbox; /* IE10 */
  display: flex;
  -ms-flex-wrap: wrap; /* IE10 */
  flex-wrap: wrap;
  margin: 0 -16px;
}

.col-25 {
  -ms-flex: 25%; /* IE10 */
  flex: 25%;
}

.col-50 {
  -ms-flex: 50%; /* IE10 */
  flex: 50%;
}

.col-75 {
  -ms-flex: 75%; /* IE10 */
  flex: 75%;
}

.col-25,
.col-50,
.col-75 {
  padding: 0 16px;
}

.container {
  background-color: #f2f2f2;
  padding: 5px 20px 15px 20px;
  border: 1px solid lightgrey;
  border-radius: 3px;
}

input[type=text] {
  width: 100%;
  margin-bottom: 20px;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 3px;
}

label {
  margin-bottom: 10px;
  display: block;
}

.icon-container {
  margin-bottom: 20px;
  padding: 7px 0;
  font-size: 24px;
}

.btn {
  background-color: #04AA6D;
  color: white;
  padding: 12px;
  margin: 10px 0;
  border: none;
  width: 100%;
  border-radius: 3px;
  cursor: pointer;
  font-size: 17px;
}

.btn:hover {
  background-color: #45a049;
}

a {
  color: #2196F3;
}

hr {
  border: 1px solid lightgrey;
}

span.price {
  float: right;
  color: grey;
}

/* Responsive layout - when the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other (also change the direction - make the "cart" column go on top) */
@media (max-width: 800px) {
  .row {
    flex-direction: column-reverse;
  }
  .col-25 {
    margin-bottom: 20px;
  }
}
</style>

<script>
            function showCardInfo() {
                var select = document.getElementById("paymentType");
                var cardInfo = document.getElementById("cardInfo");
                if (select.value === "Visa" || select.value === "Mastercard") {
                    cardInfo.style.display = "block";
                } else {
                    cardInfo.style.display = "none";
                }
            }
        </script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
          <script data-cfasync="false" src="js/email-decode.min.js"></script><script src="vendor/jquery/jquery.min.js" type="e83057937dd4e85910db8985-text/javascript"></script>
            <script src="vendor/bootstrap/js/bootstrap.bundle.min.js" type="e83057937dd4e85910db8985-text/javascript"></script>

            <script src="vendor/jquery-easing/jquery.easing.min.js" type="e83057937dd4e85910db8985-text/javascript"></script>

            <script src="js/osahan.min.js" type="e83057937dd4e85910db8985-text/javascript"></script>
            <script src="js/rocket-loader.min.js" data-cf-settings="e83057937dd4e85910db8985-|49" defer=""></script><script defer src="https://static.cloudflareinsights.com/beacon.min.js/v652eace1692a40cfa3763df669d7439c1639079717194" integrity="sha512-Gi7xpJR8tSkrpF7aordPZQlW2DLtzUlZcumS8dMQjwDHEnw9I7ZLyiOj/6tZStRBGtGgN6ceN6cMH8z7etPGlw==" data-cf-beacon='{"rayId":"75c6f93a1e227d56","version":"2022.10.3","r":1,"token":"dd471ab1978346bbb991feaa79e6ce5c","si":100}' crossorigin="anonymous"></script>
            <!--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>-->

            <script src="path/to/your/bundle.js"></script>
</body>
</html>