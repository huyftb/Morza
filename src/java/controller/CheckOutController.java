/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import cart.CartObj;
import dao.CustomerDAO;
import dao.ProductDAO;
import dto.CustomerDTO;
import dto.ProductDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;
import java.util.Map;
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
 * @author thehu
 */
@WebServlet(name = "CheckOutController", urlPatterns = {"/CheckOutController"})
public class CheckOutController extends HttpServlet {

    private final String CHECKOUT_PAGE = "checkout.jsp";

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
        String username = (String) request.getAttribute("username");
        String url = CHECKOUT_PAGE;
        String cardName = request.getParameter("cardName");
        int cardNum = Integer.parseInt(request.getParameter("cardNum"));

        String payment_type = request.getParameter("payment_type");

        String serNum = request.getParameter("serNum");

        try {
            HttpSession session = request.getSession(false);
            CustomerDAO cusdao = new CustomerDAO();
            ProductDAO dao = new ProductDAO();
            cusdao.getAccount(username);
            List<CustomerDTO> profile = cusdao.getItemsList();
            session.setAttribute("PROFILE", profile);
            boolean check = cusdao.checkpayment(payment_type, username);
            if (check = true) {
                cusdao.getPayment(payment_type, username);
                List<CustomerDTO> payment = cusdao.getItemsList();
                session.setAttribute("PAYMENT", payment);
            }

            if (session != null) {
                //2. Cust takes his/her cart
                CartObj cart = (CartObj) session.getAttribute("CART");
                if (cart != null) {
                    //3. Cust check existed items
                    Map<String, Integer> items = cart.getCart();
                    if (items != null) {
                        //4. Customer pay

                        for (String id : items.keySet()) {
                            dao.getProductForCheckOut(id);

                        }
                        List<ProductDTO> list = dao.getItemsList();
                        for (ProductDTO product : list) {
                            String base64ImageData = Base64.getEncoder().encodeToString(product.getPicData());
                            product.setBase64ImageData(base64ImageData);
                        }
                        session.setAttribute("CHECKOUT_RESULT", list);
                    }//end items has been existed
                }//end cart has been existed
            }
        } catch (NamingException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            //            response.sendRedirect(url);
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response); //check láº¡i xem ko gá»­i dc thÃ¬ send redirect

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
