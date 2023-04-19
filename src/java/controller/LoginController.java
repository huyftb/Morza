/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AdminDAO;
import dao.CustomerDAO;
import dao.ShipDAO;
import dto.AdminDTO;
import dto.CustomerDTO;
import dto.ShipDTO;
import error.LoginError;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
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
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    private final String LOGIN_PAGE = "signin.jsp";
    private final String LOGIN_HOMEPAGE = "index.jsp";
    private final String ADMIN_PAGE = "admin.jsp";
    private final String LOGIN_SHIP ="shipPage.jsp";
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

        String url = LOGIN_PAGE;
        String button = request.getParameter("btAction");

        LoginError errors = new LoginError();
        boolean isError = false;

        try {
            if (button != null) {
                String username = request.getParameter("txtUsername");
                String password = request.getParameter("txtPassword");
                

                CustomerDAO dao = new CustomerDAO();
                CustomerDTO result = dao.checkLogin(username, password);
                AdminDAO daoAd = new AdminDAO();
                AdminDTO resultAd = daoAd.checkLogin(username, password);
                ShipDAO daoS = new ShipDAO();
                ShipDTO resultS = daoS.checkLogin(username, password);

                if (resultAd != null) {
                    dao.showAcc();
                    List<CustomerDTO> resultacc = dao.getItemsList();
                    request.setAttribute("ACC_RESULT", resultacc);
                    url = ADMIN_PAGE;

                } else if (result != null) {
                    url = LOGIN_HOMEPAGE;
                  
                    HttpSession session = request.getSession();
                    session.setAttribute("username", username);
                    session.setAttribute("custName", dao.getCustName(username));
//                    session.setAttribute("password", dao.getPassword(username));
//                    session.setAttribute("phoneNum", dao.getPhoneNum(username));
//                    session.setAttribute("email", dao.getEmail(username));
//                    session.setAttribute("address", dao.getAddress(username));
//                    
                } else if(resultS !=null) {
                    url = LOGIN_SHIP;
           
              
                } else {
                    errors.setErrorMsg("Wrong username or password! Please check again...");
                    isError = true;

                }
            }
        } catch (SQLException ex) {
            log("LoginServlet SQL: " + ex.getCause());
            errors.setErrorMsg("An error has occured during your login... Please contact the web owner for more details!!!");
            isError = true;
        } catch (NamingException ex) {
            log("LoginServlet Naming: " + ex.getCause());
            errors.setErrorMsg("An error has occured during your login... Please contact the web owner for more details!!!");
            isError = true;
        } finally {
            if (isError) {
                request.setAttribute("LOGIN_ERROR", errors);
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);
            } else {
                response.sendRedirect(url);
            }

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
