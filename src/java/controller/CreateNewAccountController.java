/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CustomerDAO;
import dto.CustomerDTO;
import error.AccountCreateError;
import java.io.IOException;
import java.sql.SQLException;
import javax.naming.NamingException;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DELL
 */
@WebServlet(name = "CreateNewAccountController", urlPatterns = {"/CreateNewAccountController"})
public class CreateNewAccountController extends HttpServlet {
//    private final String CREATE_NEW_ACCOUNT_PAGE = "createNewAccount.jsp";
    private final String CREATE_NEW_ACCOUNT_ERROR = "signup.jsp";
    private final String LOGIN_PAGE = "signin.jsp";
    
     /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        String confirm = request.getParameter("txtConfirm");
        String custName = request.getParameter("txtFullname");
        String address = request.getParameter("txtAddress");
        String phoneNum = request.getParameter("txtPhoneNum");
        String email = request.getParameter("txtEmail");
        
        String emailPattern = "^[a-zA-Z]([a-zA-Z0-9_.-])+{4,31}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$";
        
        String url = CREATE_NEW_ACCOUNT_ERROR;
        AccountCreateError errors = new AccountCreateError();
        boolean isError = false;
        
        try  {
           if (username.trim().length() < 6 || username.trim().length() > 30) {
                isError = true;
                errors.setUsernameLengthErr("Username requires input from "
                        + "6 to 30 characters!!");
            }
            
            if (password.trim().length() < 6 || password.trim().length() > 20) {
                isError = true;
                errors.setPasswordLengthErr("Password requires input from "
                        + "6 to 20 characters!!");
            } else if (!(password.trim().equals(confirm.trim()))) {
                isError = true;
                errors.setConfirmNotMatchErr("Confirm doesn't match with the "
                        + "entered Password!!!");
            }
            
            if (custName.trim().length() < 2 || custName.trim().length() > 50) {
                isError = true;
                errors.setFullnameLengthErr("Fullname requires input from "
                        + "2 to 50 characters!!");
            }
            
//             if (address.trim().length() < 5) {
//                isError = true;
//                errors.setAddressLengthErr("Adress requires input more than 5 characters");
//            }
             
              if (phoneNum.trim().length() < 10 || phoneNum.trim().length() > 12) {
                isError = true;
                errors.setPhoneNumLengthErr("Phone number requires input from "
                        + "10 to 12 characters!!");
            }
              
               if (!email.matches(emailPattern)) {
                isError = true;
                errors.setEmailSyntaxErr("Email is invalid! Please input again!");
            }
               if (isError) {
                request.setAttribute("CREATE_ERROR", errors);
            } else {
                // Create Account
                // Create Account
                CustomerDAO dao = new CustomerDAO();
                CustomerDTO dto = new CustomerDTO(username, password, phoneNum, address, custName, email);
                boolean result= dao.createAccount(dto);
                
                if (result) {
                    url = LOGIN_PAGE;
                  
                }
            }
               } catch (SQLException ex) {
            String errorMsg = ex.getMessage();
            log("CreateNewAccountServlet SQL: " + errorMsg);
            
            if (errorMsg.contains("duplicate")) {
                errors.setUsernameExisted("The username '" + username + 
                        "' is existed!!!");
            } else {
                errors.setErrorMsg("An error has occured during your sign up..sql. Please contact the web owner for more details!!!");
            }
            request.setAttribute("CREATE_ERROR", errors);
        } catch (NamingException ex) {
            log("CreateNewAccountServlet Naming: " + ex.getMessage());
            errors.setErrorMsg("An error has occured during your sign up (naming)... Please contact the web owner for more details!!!");
            request.setAttribute("CREATE_ERROR", errors);
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
