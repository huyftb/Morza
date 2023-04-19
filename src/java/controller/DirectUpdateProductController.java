/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProductDAO;
import dto.ProductDTO;
import java.io.BufferedReader;
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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author thehu
 */
@MultipartConfig(maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
@WebServlet(name = "DirectUpdateProductController", urlPatterns = {"/DirectUpdateProductController"})
public class DirectUpdateProductController extends HttpServlet {

    private final String UPDATE_PAGE = "test.jsp";
    private final String ADMIN = "admin.jsp";
    private final String ERROR_PAGE = "404.jsp";
    private final String SEARCH_PAGE = "adminSearchProduct.jsp";

    private String getValueFromPart(Part part) throws IOException {
        if (part == null) {
            return null;
        }
        try (InputStream is = part.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
            return reader.lines().collect(Collectors.joining(System.lineSeparator()));
        }
    }

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

//        if (searchValue.trim().length() >0){
//                ProductDAO dao = new ProductDAO();
//                dao.searchProduct(searchValue);
//                List<ProductDTO> result = dao.getItemsList();
//                for (ProductDTO product : result) {
//                        String base64ImageData = Base64.getEncoder().encodeToString(product.getPicData());
//                        product.setBase64ImageData(base64ImageData);
//                    }
//                if (result != null) {
//                    request.setAttribute("PRO_RESULT", result);
//                    url = SEARCH_PRODUCT;
//                    request.getAttribute("PRO_RESULT");
//                } else {
//                    url = ERROR;
//                }
//            }
//        } 
//        String productID = request.getParameter("txtProID");
        String productID = request.getParameter("txtProID");
//        String productID = "p2";
        String url = UPDATE_PAGE;
        try {
            ProductDAO productDAO = new ProductDAO();
            productDAO.showProduct(productID);
            request.setAttribute("productDAO", productDAO);
            ProductDAO dao = new ProductDAO();

            dao.showProduct(productID);
            List<ProductDTO> result = dao.getItemsList();
            if (result != null) {
                request.setAttribute("UP_RESULT", result);
                request.getAttribute("UP_RESULT");

            } else {
                url = UPDATE_PAGE;
            }

            dao.showCate();
            List<ProductDTO> cateResult = dao.getItemsList();
            request.setAttribute("CATE_RESULT", cateResult);
            
            if (cateResult != null) {
                url = UPDATE_PAGE;
            } else {
                url = ERROR_PAGE;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (NamingException ex) {
            ex.printStackTrace();
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
