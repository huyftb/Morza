/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DELL
 */
    @MultipartConfig
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    private final String LOGIN_PAGE = "signin.jsp";
    private final String ADMIN_PAGE = "admin.jsp";
    private final String LOGIN = "LoginController";
    private final String SEARCH = "SearchAccountController";
    private final String UPDATE = "UpdateAccountController";
    private final String DELETE = "DeleteAcountController";
    private final String CREATE = "CreateNewAccountController";
    private final String PRODUCT_PAGE = "searchProduct.jsp";
    private final String SEARCH_PRODUCT = "SearchProductAController";
    private final String BAN_CONTROLLER = "DeleteAcountController";
    private final String SHOW_PRODUCT_CONTROLLER = "ShowProductController";
    private final String SHOW_IMG_CONTROLLER = "ShowImageController";
    private final String PRODUCT_ADMIN = "ManageProductController";
    private final String DELETE_PROFILE_CUSTOMER = "DeleteProfileCustomerController";
    private final String UPDATE_PRODUCT_CONTROLLER = "UpdatePoductController";
    private final String UPDATE_ADMIN_PAGE = "DirectUpdateProductController";
    private final String CREATE_PRODUCT_PAGE = "DirectCreateProductController";
    private final String CREATE_PRODUCT = "CreateProductController";
    private final String CREATE_ORDER = "InsertOrderController";
    private final String DIABLE_PRODUCT_CONTROLLER = "DisableProductController";
    private final String BAN_ACCOUNT = "BanAccController";
    

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
        String button = request.getParameter("btAction");
        String url = LOGIN_PAGE;
        try {
            if (button == null) {
                url="adminSearchProduct.jsp";
            } else if (button.equals("Login")) {
                url = LOGIN;
            } else if (button.equals("Sign up")) {
                url = CREATE;
            } else if (button.equals("Delete")) {
                url = DELETE;
            } else if (button.equals("Find Account")) {
                url = SEARCH;
            } else if (button.equals("Reset Account")) {
                url = UPDATE;
            } else if (button.equals("Product Page")) {
                url = PRODUCT_PAGE;
            } else if (button.equals("Find Product")) {
                url = SEARCH_PRODUCT;
            } else if (button.equals("Search_product")) {
                url = PRODUCT_PAGE;
            } else if (button.equals("Ban")) {
                url = BAN_CONTROLLER;
            } else if (button.equals("Details")) {
                url = SHOW_PRODUCT_CONTROLLER;
            } else if (button.equals("Show all product")) {
                url = SHOW_IMG_CONTROLLER;
            } else if (button.equals("Find")) {
                url = PRODUCT_ADMIN;
            } else if (button.equals("Delete")) {
                url = DELETE_PROFILE_CUSTOMER;
            } else if (button.equals("Update Product")) {
                url = UPDATE_ADMIN_PAGE;
            } else if (button.equals("Place Order")){
                url = CREATE_ORDER;
            } else if (button.equals("Create")){
                url = CREATE_PRODUCT_PAGE;
            } else if (button.equals("UpdateProduct")){
                url = UPDATE_PRODUCT_CONTROLLER;
            } else if (button.equals("Create Product")){
                url = CREATE_PRODUCT;
             }else if (button.equals("Disable Product")) {
                url = DIABLE_PRODUCT_CONTROLLER;
            }else if (button.equals("Ban Account")) {
                url = BAN_ACCOUNT;
            }
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
