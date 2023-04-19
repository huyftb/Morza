<%-- 
    Document   : testUpdate
    Created on : Feb 21, 2023, 5:50:09 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
    </head>
    <body>
       
        <h1>Search Page</h1>

        <c:set var="customer" value="${requestScope.CUSTOMER}"/>
        <c:if test="${empty customer}">
            <p>Not match</p>
        </c:if>
        
        <c:if test="${not empty customer}">
       
                <table border="1">
                    <thead>
                        <tr>
                            <th>1.</th>
                            <th>2</th>
                            <th>3</th>
                            <th>4 </th>
                            <th>5</th>
                            <th>6</th>
                            <th>7</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="cust" items="${customer}" varStatus="iCount">
                        <form action="UpdateAccountController">
                            <tr>
                            <td>
                               ${customer.username}
                            .</td>
                            <td>
                                ${customer.username}
                                <input type="hidden" name="txtUsername" 
                                       value="${customer.username}" />
                            </td>
                            <td>
                                <input type="text" name="txtPassword" 
                                       value="${customer.password}" />
                            </td>
                            <td>
                               <%-- ${dto.lastname}--%>
                                <input type="text" name="txtCustName" value="${customer.custName}" />
                            </td>
                            <td>
                                  <input type="text" name="txtPhoneNum" value="${customer.phoneNum}" />
                            </td>
                              <td>
                                  <input type="text" name="txtAddress" value="${customer.address}" />
                            </td>
                            
                         
                            <td>
                                <input type="submit" value="Update" name="btAction_Up" />
                             
                        </td>
                        </tr>
                        
                        </form>

                        </c:forEach>
                    </tbody>
                </table>

            </c:if>
           
    </body>
</html>
