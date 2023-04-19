/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CustomerDAO;
import dto.CustomerDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
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
@WebServlet(name = "AccountInfoController", urlPatterns = {"/AccountInfoController"})
public class AccountInfoController extends HttpServlet {
private final String PROFILE_PAGE = "accountInfo.jsp";
    private final String ERROR_PAGE = "404.jsp";
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
        PrintWriter out = response.getWriter();
             String username = request.getParameter("txtUsername");
//            String password = request.getParameter("txtPassword");
//            String phoneNum = request.getParameter("txtPhoneNum");
//            String custName = request.getParameter("txtCustName");
//            String address = request.getParameter("txtAddress");
//            String email = request.getParameter("txtEmail");
         List<CustomerDTO> result;
//         CustomerDTO result;
        String url = PROFILE_PAGE;
        try {
           
            //1. call DAO
            CustomerDAO dao = new CustomerDAO();
//            dao.getAccounts();
             CustomerDTO customer = dao.getAccount("hihihi");
//result = dao.getItemsListByUsername("hihihi");
System.out.println(customer);
//            System.out.println("Result size: " + result.size());
            request.setAttribute("CUSTOMER", customer);
            System.out.println("CUSTOMER attribute set on request: " + request.getAttribute("CUSTOMER"));
            
           
 
        }catch (NamingException ex) {
             log("ShowItemsServlet _ Naming _ " + ex.getMessage());
        } catch (SQLException ex) {
            log("ShowItemsServlet _ SQL _ " + ex.getMessage());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
            out.close();
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
