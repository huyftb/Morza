/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProductDAO;
import dto.ProductDTO;
import error.ProductCreateError;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import java.sql.SQLException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
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
@WebServlet(name = "CreateProductController", urlPatterns = {"/CreateProductController"})
public class CreateProductController extends HttpServlet {

    private final static String CREATE_PAGE_ERROR = "createProduct.jsp";
    private final static String ERROR = "404.jsp";
    private final String ADMIN_PAGE = "adminSearchProduct.jsp";

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
        String url = CREATE_PAGE_ERROR;
        String IDpattern = "p\\d{3}";
        ProductCreateError errors = new ProductCreateError();
        boolean isError = false;
        
        // Get the product information from the request parameters
        String productId = request.getParameter("txtProID");
        String proName = request.getParameter("txtProname");
        String description = request.getParameter("txtProdes");
        int yearPublish = Integer.parseInt(request.getParameter("txtYearPublish"));
        float price = Float.parseFloat(request.getParameter("txtPrice"));
        String categoryId = request.getParameter("txtCategory");
//        String filename = request.getParameter("file");
        // Convert the picture to byte array and get the filename
        Part picture = request.getPart("file");
        InputStream picData = picture.getInputStream();
        String fullPath = picture.getSubmittedFileName();
        String fileName = new File(fullPath).getName();
        String OnlName = fileName.substring(0, fileName.lastIndexOf('.'));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
        while ((bytesRead = picData.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        
        byte[] imageData = outputStream.toByteArray();
        try {
            if (!productId.matches(IDpattern)) {
                isError = true;
                errors.setIdSyntaxError("ID is invalid! Please input again!");
            }
            if (proName.trim().length() < 2 || proName.trim().length() > 50) {
                isError = true;
                errors.setNameLengthError("Product Name requires "
                        + "2 to 50 characters!!");
            }
            if (description.trim().length() < 2 || description.trim().length() > 200) {
                isError = true;
                errors.setDescripLengthError("Description requires "
                        + "2 to 200 characters!!");
            }
             if (yearPublish < 2000 || yearPublish > 2023) {
                isError = true;
                errors.setYearRangeError("yearPublish cannot less than 2000 or larger than 2023");
            }
             if (price < 1) {
                isError = true;
                errors.setPriceRangeError("Price cannot less than $1");
            }
            if(isError) {
                request.setAttribute("CREATE_PRO_ERROR", errors);
            } else {
            ProductDAO dao = new ProductDAO();

//             Get the input stream of the product image from the request
//             Read the input stream and store the image data in a byte array
//            ProductDTO product = new ProductDTO(productId, proName, description, yearPublish, price, categoryId, fileName, imageData);
//             Create a new ProductDTO object with the updated information
            boolean result = true;
//            result = dao.insertProduct(product, OnlName);
            result = dao.insertProduct(productId, proName, description, yearPublish, price, categoryId, fileName, imageData, OnlName);
            if (result == true) {
                url = ADMIN_PAGE;
           
            }
            }
        } catch (SQLException ex) {
            String errorMsg = ex.getMessage();
            log("CreateNewProductServlet SQL: " + errorMsg);
             if (errorMsg.contains("duplicate")) {
                errors.setIdIsExisted("The ID '" + productId + 
                        "' is existed!!!");
            } else {
                errors.setErrorMsg("An error has occured during your sign up... Please contact the web owner for more details!!!");
            }
             request.setAttribute("CREATE_PRO_ERROR", errors);
        } catch (NamingException ex) {
            log("CreateNewProductServlet Naming: " + ex.getMessage());
            errors.setErrorMsg("An error has occured during your sign up ... Please contact the web owner for more details!!!");
            request.setAttribute("CREATE_PRO_ERROR", errors);
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
