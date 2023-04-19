/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import cart.CartObj;
import dao.ProductDAO;
import dto.ProductDTO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
import java.util.HashMap;


/**
 *
 * @author DELL
 */
@WebServlet(name = "AddToCartController", urlPatterns = {"/AddToCartController"})
public class AddToCartController extends HttpServlet {
//    private final String DETAIL_CONTROLLER = "ProductDetailController";

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
            throws ServletException, IOException, SQLException, NamingException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String productID = request.getParameter("proID");
        int strQuantity = Integer.parseInt(request.getParameter("quantity"));

        String url = "viewCart.jsp";
        try {
//            if (productID != null && strQuantity != null) {

//                int quantity = Integer.parseInt(strQuantity);
            HttpSession session = request.getSession();
            HashMap<ProductDTO,Integer> cartP = new HashMap<>();
            CartObj cart = (CartObj) session.getAttribute("CART");
            if (cart == null) {
                cart = new CartObj();
            }
            cart.addProductToCart(productID, strQuantity);
            session.setAttribute("CART", cart);
            ProductDAO dao = new ProductDAO();
            ProductDTO result = dao.getProductbyID(productID);
            for(String i : cart.getCart().keySet()){
                ProductDTO p = dao.getProductbyID(i);
                cartP.put(p, cart.getCart().get(i));
            }
            session.setAttribute("cartP",cartP);
            String base64ImageData = Base64.getEncoder().encodeToString(result.getPicData());
            result.setBase64ImageData(base64ImageData);
            request.setAttribute("IMG", result);
//                url = DETAIL_CONTROLLER + "?proID=" + productID + "&quantity="+strQuantity;
        } catch (NumberFormatException ex) {
            ex.printStackTrace();

        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
//            response.sendRedirect(url);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AddToCartController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(AddToCartController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AddToCartController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(AddToCartController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
