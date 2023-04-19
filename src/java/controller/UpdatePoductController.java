/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProductDAO;
import dto.ProductDTO;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author thehu
 */
@MultipartConfig
@WebServlet(name = "UpdatePoductController", urlPatterns = {"/UpdatePoductController"})
public class UpdatePoductController extends HttpServlet {

    private final static String UPDATE_PAGE = "test.jsp";
    private final static String MANAGE = "adminSearchProduct.jsp";

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
        String url = MANAGE;
        response.setContentType("text/html;charset=UTF-8");
        String productId = request.getParameter("txtProID");
        String proName = request.getParameter("txtProname");
        float price = Float.parseFloat(request.getParameter("txtPrice"));
        String categoryId = request.getParameter("txtCategory");
        String description = request.getParameter("txtProdes");
        int yearPublish = Integer.parseInt(request.getParameter("txtYearPublish"));
        // Convert the picture to byte array and get the filename
        Part picture = request.getPart("pic");
        InputStream picData = picture.getInputStream();
        String fullPath = picture.getSubmittedFileName();
        String fileName = new File(fullPath).getName();
        String OnlName = fileName.substring(0, fileName.lastIndexOf('.'));
        // Read the input stream and store the image data in a byte array
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
        while ((bytesRead = picData.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        byte[] imageData = outputStream.toByteArray();
//        ProductDTO product = new ProductDTO(productId, proName, description, yearPublish, price, categoryId, filename, imageData);
        // Create a new ProductDTO object with the updated information
        try {
            // Update the product information in the database
            ProductDAO dao = new ProductDAO();
            boolean result = dao.updateProduct(productId, proName, description, yearPublish, price, fileName, imageData, OnlName);

            if (result) {
                url = MANAGE;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (NamingException ex) {
            ex.printStackTrace();
        } finally {
            // Display the result page
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
