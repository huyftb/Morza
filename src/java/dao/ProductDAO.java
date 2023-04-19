/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.ProductDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import utils.DBHelper;

/**
 *
 * @author DELL
 */
public class ProductDAO implements Serializable {

    private List<ProductDTO> itemsList;

    public List<ProductDTO> getItemsList() {
        return itemsList;
    }

    public void searchProduct(String searchValue)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            //1. Get connection
            con = DBHelper.makeConnection();
            if (con != null) {
                //2. Create sql string
                String sql = "SELECT p.productID, p.proName, p.Description, p.yearPublish, c.catgoryName, p.price, i.filename, i.picdata, i.picID   \n"
                        + "FROM Product p inner JOIN Category c ON p.CategoryID = c.CategoryID inner JOIN Picture i ON p.picID = i.picID \n"
                        + "Where p.proName LIKE ? and p.status = 1";
//                String sql = "SELECT p.productID, p.proName, p.Description, p.yearPublish, c.catgoryName, p.price \n"
//                        + "FROM Product p full JOIN Category c ON p.CategoryID = c.CategoryID  \n"
//                        + "Where p.proName like ? ";
                //3. Create statement
                stm = con.prepareStatement(sql);
                stm.setNString(1, "%" + searchValue + "%");
                //4. Execute Query
                rs = stm.executeQuery();
                //5. Process result
                while (rs.next()) {
                    //get field/column
                    String productID = rs.getString("productID");
                    String proName = rs.getString("proName");
                    String description = rs.getString("description");
                    int yearPublish = rs.getInt("yearPublish");
                    float price = rs.getFloat("price");
                    String catgoryName = rs.getString("catgoryName");
                    String filename = rs.getString("filename");
                    byte[] picData = rs.getBytes("picdata");

                    //Create DTO instance
                    ProductDTO dto = new ProductDTO(productID, proName, description, yearPublish, price, catgoryName, picData);
                    //add to bookList
                    if (this.itemsList == null) {
                        this.itemsList = new ArrayList<>();
                    }//end bookList is not existed
                    this.itemsList.add(dto);
                }//end bookList is traversed
            }//end con is available
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public void showProduct(String searchValue)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Get connection
            con = DBHelper.makeConnection();
            if (con != null) {
                //2. Create sql string

                String sql = "SELECT p.productID, p.proName, p.Description, p.yearPublish, c.catgoryName, p.price \n"
                        + "FROM Product p inner JOIN Category c ON p.CategoryID = c.CategoryID  \n"
                        + "Where p.productID like ? and p.status = 1";
                //3. Create statement
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");
                //4. Execute Query
                rs = stm.executeQuery();
                //5. Process result
                while (rs.next()) {
                    //get field/column
                    String productID = rs.getString("productID");
                    String proName = rs.getString("proName");
                    String description = rs.getString("description");
                    int yearPublish = rs.getInt("yearPublish");
                    float price = rs.getFloat("price");
                    String catgoryName = rs.getString("catgoryName");

                    //Create DTO instance
                    ProductDTO dto = new ProductDTO(productID, proName, description, yearPublish, price, catgoryName);
                    //add to bookList
                    if (this.itemsList == null) {
                        this.itemsList = new ArrayList<>();
                    }//end bookList is not existed
                    this.itemsList.add(dto);
                }//end bookList is traversed
            }//end con is available
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public void getProduct()
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Get connection
            con = DBHelper.makeConnection();
            if (con != null) {
                //2. Create sql string

                String sql = "SELECT p.productID, p.proName, p.Description, p.yearPublish, c.catgoryName, p.price \n"
                        + "FROM Product p inner JOIN Category c ON p.CategoryID = c.CategoryID  \n";

                //3. Create statement
                stm = con.prepareStatement(sql);

                //4. Execute Query
                rs = stm.executeQuery();
                //5. Process result
                while (rs.next()) {
                    //get field/column
                    String productID = rs.getString("productID");
                    String proName = rs.getString("proName");
                    String description = rs.getString("description");
                    int yearPublish = rs.getInt("yearPublish");
                    String catgoryName = rs.getString("catgoryName");
                    float price = rs.getFloat("price");

                    //Create DTO instance
                    ProductDTO dto = new ProductDTO(productID, proName, description, yearPublish, price, catgoryName);
                    //add to bookList
                    if (this.itemsList == null) {
                        this.itemsList = new ArrayList<>();
                    }//end bookList is not existed
                    this.itemsList.add(dto);
                }//end bookList is traversed
            }//end con is available
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public void showIMG()
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Get connection
            con = DBHelper.makeConnection();
            if (con != null) {
                //2. Create sql string

                String sql = "SELECT p.productID, p.proName, p.Description, "
                        + "p.yearPublish, c.catgoryName, p.price, i.filename, "
                        + "i.picdata, i.picID   \n"
                        + "FROM Product p inner JOIN  Picture i ON p.picID = i.picID "
                        + "inner Join Category c on p.CategoryID = c.CategoryID  \n"
                         + "where p.status = 1\n";
                //3. Create statement
                stm = con.prepareStatement(sql);

                //4. Execute Query
                rs = stm.executeQuery();
                //5. Process result
                while (rs.next()) {
                    //get field/column
                    String productID = rs.getString("productID");
                    String proName = rs.getString("proName");
                    String description = rs.getString("description");
                    int yearPublish = rs.getInt("yearPublish");
                    float price = rs.getFloat("price");
                    String catgoryName = rs.getString("catgoryName");
//                    String filename = rs.getString("filename");
                    byte[] picData = rs.getBytes("picdata");

                    //Create DTO instance
                    ProductDTO dto = new ProductDTO(productID, proName, description, yearPublish, price, catgoryName, picData);
                    //add to bookList
                    if (this.itemsList == null) {
                        this.itemsList = new ArrayList<>();
                    }//end bookList is not existed
                    this.itemsList.add(dto);
                }//end bookList is traversed
            }//end con is available
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public void importImg(String searchValue, String basePath)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String picName = "myImage";
        String imageFolderPath = "images";
        String filename = "poork10.jpg";
        try {
            //1. Get connection
            con = DBHelper.makeConnection();
            if (con != null) {

                // Get the base path for the project
//                String basePath = request.getServletContext().getRealPath("/");
                // Combine the base path with the image folder path
                String imagePath = basePath + imageFolderPath;
                stmt = con.prepareCall("{ call dbo.usp_ExportImage(?, ?, ?) }");
                stmt.setNString(1, picName);
                stmt.setNString(2, imagePath);
                stmt.setNString(3, filename);
                stmt.execute();
            }//end con is available
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        }

    }

    public boolean updateProduct(String productId, String proName, String description, int yearPublish, float price, String fileName, byte[] imageData, String OnlName) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        PreparedStatement stmt = null;
        boolean result = true;
        String picID = null;
        try {
            //1. Get connection
            con = DBHelper.makeConnection();
            if (con != null) {
                //2. Check if the product has an existing image record
                String checkImageSql = "SELECT picID FROM Picture WHERE picID = ?";
                stmt = con.prepareStatement(checkImageSql);
                stmt.setString(1, OnlName);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    picID = rs.getString("picID");
                }

                //3. Update or insert the image record as necessary
                String imageSql;
                if (picID == null) {
                    // If there is no existing image record, insert a new one
                    imageSql = "INSERT INTO Picture(picID, filename, picData) VALUES(?, ?, ?)";
                    stm = con.prepareStatement(imageSql);
                    stm.setString(1, OnlName);
                    stm.setString(2, fileName);
                    stm.setBytes(3, imageData);
                } else {
                    // If there is an existing image record, update it
                    imageSql = "UPDATE Picture SET picData = ?, filename = ? WHERE picID = ?";
                    stm = con.prepareStatement(imageSql);
                    stm.setBytes(1, imageData);
                    stm.setString(2, fileName);
                    stm.setString(3, OnlName);
                }
                result = stm.executeUpdate() > 0 ? true : false;
                if (result == true) {
                    //4. Update the product record
                    String sql = "UPDATE Product SET proName = ?, Description = ?, yearPublish = ?, price = ?, picID = ? WHERE productID = ?";
                    stm = con.prepareStatement(sql);
                    stm.setString(1, proName);
                    stm.setString(2, description);
                    stm.setInt(3, yearPublish);
                    stm.setFloat(4, price);
                    stm.setString(5, OnlName);
                    stm.setString(6, productId);
                    result = stm.executeUpdate() > 0 ? true : false;
                }

            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

//    public boolean insertProduct(ProductDTO product, String OnlName) throws SQLException, NamingException {
    public boolean insertProduct(String productId, String proName, String description, int yearPublish, float price, String categoryId, String fileName, byte[] imageData, String OnlName) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        PreparedStatement stmt = null;
        boolean result = true;
        String picID = null;

        try {
            //1. Get connection
            con = DBHelper.makeConnection();
            if (con != null) {

                //2. Check if the product has an existing image record
                String checkImageSql = "SELECT picID FROM Picture WHERE picID = ?";
                stmt = con.prepareStatement(checkImageSql);
                stmt.setString(1, OnlName);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    picID = rs.getString("picID");
                }

                //3. Update or insert the image record as necessary
                String imageSql;
                if (picID == null) {
                    // If there is no existing image record, insert a new one
                    imageSql = "INSERT INTO Picture(picID, filename, picData) VALUES(?, ?, ?)";
                    stm = con.prepareStatement(imageSql);
                    stm.setString(1, OnlName);
                    stm.setString(2, fileName);
                    stm.setBytes(3, imageData);
                } else {
                    // If there is an existing image record, update it
                    imageSql = "UPDATE Picture SET picData = ?, filename = ? WHERE picID = ?";
                    stm = con.prepareStatement(imageSql);
                    stm.setBytes(1, imageData);
                    stm.setString(2, fileName);
                    stm.setString(3, OnlName);
                }
                result = stm.executeUpdate() > 0 ? true : false;
                if (result == true) {
                    //4. Update the product record
                    String sql = "INSERT INTO [dbo].[Product]\n"
                            + "           ([productID]\n"
                            + "           ,[proName]\n"
                            + "           ,[description]\n"
                            + "           ,[yearPublish]\n"
                            + "           ,[price]\n"
                            + "           ,[picID]\n"
                            + "           ,[CategoryID]\n"
                            + "           ,[status])\n"
                            + "     VALUES\n"
                            + "           (?\n"
                            + "           ,?\n"
                            + "           ,?\n"
                            + "           ,?\n"
                            + "           ,?\n"
                            + "           ,?\n"
                            + "           ,?\n"
                            + "           ,1)\n";
                    stm = con.prepareStatement(sql);
                    stm.setString(1, productId);
                    stm.setString(2, proName);
                    stm.setString(3, description);
                    stm.setInt(4, yearPublish);
                    stm.setFloat(5, price);
                    stm.setString(6, OnlName);
                    stm.setString(7, categoryId);
                    result = stm.executeUpdate() > 0 ? true : false;
                }

            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

    public boolean deleteProduct(String productID)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            //1. Connect DB
            con = DBHelper.makeConnection();

            if (con != null) {
                //2.tạo SQL statement String
                String sql = "Delete From Product "
                        + "Where productID = ? ";
                //3.Tạo statement dể nạp SQL vào  
                stm = con.prepareStatement(sql);
                stm.setString(1, productID);
                //4. executeQuery
                int effectedRow = stm.executeUpdate();
                //5. process
                if (effectedRow > 0) {
                    result = true;
                }
            }// end if connection is exist
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

    public void showIMG_1()
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Get connection
            con = DBHelper.makeConnection();
            if (con != null) {
                //2. Create sql string

                String sql = "select * \n"
                        + "FROM Product p inner JOIN  Picture i ON p.picID = i.picID  inner JOIN Category c ON p.CategoryID = c.CategoryID\n"
                         + " where p.status = 1 ";
                //3. Create statement
                stm = con.prepareStatement(sql);

                //4. Execute Query
                rs = stm.executeQuery();
                //5. Process result
                while (rs.next()) {
                    //get field/column
                    String productID = rs.getString("productID");
                    String proName = rs.getString("proName");
                    String description = rs.getString("description");
                    int yearPublish = rs.getInt("yearPublish");
                    float price = rs.getFloat("price");
                    String catgoryName = rs.getString("catgoryName");
                    byte[] picData = rs.getBytes("picdata");
                    String picID = rs.getString("picID");

                    //Create DTO instance
                    ProductDTO dto = new ProductDTO(productID, proName, description, yearPublish, price, catgoryName, picID, picData);
                    //add to bookList
                    if (this.itemsList == null) {
                        this.itemsList = new ArrayList<>();
                    }//end bookList is not existed
                    this.itemsList.add(dto);
                }//end bookList is traversed
            }//end con is available
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public void showProductInDrinkCategory()
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Get connection
            con = DBHelper.makeConnection();
            if (con != null) {
                //2. Create sql string

                String sql = "select * \n"
                        + "FROM Product p inner JOIN  Picture i ON p.picID = i.picID  inner JOIN Category c ON p.CategoryID = c.CategoryID\n"
                        + "where p.CategoryID = 01 and p.status=1";
                //3. Create statement
                stm = con.prepareStatement(sql);

                //4. Execute Query
                rs = stm.executeQuery();
                //5. Process result
                while (rs.next()) {
                    //get field/column
                    String productID = rs.getString("productID");
                    String proName = rs.getString("proName");
                    String description = rs.getString("description");
                    int yearPublish = rs.getInt("yearPublish");
                    float price = rs.getFloat("price");
                    String catgoryName = rs.getString("catgoryName");
                    byte[] picData = rs.getBytes("picdata");
                    String picID = rs.getString("picID");

                    //Create DTO instance
                    ProductDTO dto = new ProductDTO(productID, proName, description, yearPublish, price, catgoryName, picID, picData);
                    //add to bookList
                    if (this.itemsList == null) {
                        this.itemsList = new ArrayList<>();
                    }//end bookList is not existed
                    this.itemsList.add(dto);
                }//end bookList is traversed
            }//end con is available
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public ProductDTO getProductbyID(String productID)
            throws SQLException, NamingException {

        ProductDTO result = null;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sqlStr = "select * \n"
                        + "FROM Product p inner JOIN  Picture i ON p.picID = i.picID  inner JOIN Category c ON p.CategoryID = c.CategoryID\n"
                        + "WHERE productID = ? and p.status=1";
                stmt = con.prepareStatement(sqlStr);
                stmt.setString(1, productID);
                rs = stmt.executeQuery();

                while (rs.next()) {
                    //get field/column
//                    String productID = rs.getString("productID");
                    String proName = rs.getString("proName");
                    String description = rs.getString("description");
                    int yearPublish = rs.getInt("yearPublish");
                    float price = rs.getFloat("price");
                    String catgoryName = rs.getString("catgoryName");
                    byte[] picData = rs.getBytes("picdata");
                    String picID = rs.getString("picID");

                    //Create DTO instance
                    result = new ProductDTO(productID, proName, description, yearPublish, price, catgoryName, picID, picData);
                    return result;
                }

            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

    public void showCate()
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Get connection
            con = DBHelper.makeConnection();
            if (con != null) {
                //2. Create sql string

                String sql = "select  CategoryID, catgoryName FROM Category";
                //3. Create statement
                stm = con.prepareStatement(sql);
                //4. Execute Query
                rs = stm.executeQuery();
                //5. Process result
                while (rs.next()) {
                    //get field/column
                    String categoryID = rs.getString("categoryID");
                    String catgoryName = rs.getString("catgoryName");
                    //Create DTO instance
                    ProductDTO dto = new ProductDTO(categoryID, catgoryName);
                    //add to bookList
                    if (this.itemsList == null) {
                        this.itemsList = new ArrayList<>();
                    }//end bookList is not existed
                    this.itemsList.add(dto);
                }//end bookList is traversed
            }//end con is available
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public void getProductForCheckOut(String id)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Get connection
            con = DBHelper.makeConnection();
            if (con != null) {
                //2. Create sql string
                String sql = "Select p.productID, p.proName, p.description, p.price, p.picID, i.filename, i.picdata, i.picID "
                        + "From Product inner JOIN  Picture i ON p.picID = i.picID "
                        + "Where productID = ?";
                //3. Create statement
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                //4. Execute Query
                rs = stm.executeQuery();
                //5. Process result
                while (rs.next()) {
                    String productID = rs.getString("productID");
                    String proName = rs.getString("name");
                    String description = rs.getString("description");
                    float price = rs.getInt("price");
                    String picID = rs.getString("picID");
                    String filename = rs.getString("filename");
                    byte[] picData = rs.getBytes("picdata");
                    //Create DTO instance
                    ProductDTO dto = new ProductDTO(productID, proName, description, price, picID);
                    //add to bookList
                    if (this.itemsList == null) {
                        this.itemsList = new ArrayList<>();
                    }//end bookList is not existed
                    this.itemsList.add(dto);
                }//end bookList is traversed
            }//end con is available
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
public boolean disableProduct(String productID) throws SQLException, NamingException {
    boolean result = false;
    Connection con = null;
    PreparedStatement stmt = null;

    try {
        con = DBHelper.makeConnection();

        if (con != null) {
            String sqlStr = "UPDATE Product SET status = 0 WHERE productID = ?";
            stmt = con.prepareStatement(sqlStr);
            stmt.setString(1, productID);

            int iCount = stmt.executeUpdate();

            if (iCount > 0) {
                result = true;
            }
        }
    } finally {
        if (stmt != null) {
            stmt.close();
        }
        if (con != null) {
            con.close();
        }
    }

    return result;
}
public void showProductInFishCategory()
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Get connection
            con = DBHelper.makeConnection();
            if (con != null) {
                //2. Create sql string

                String sql = "select * \n"
                        + "FROM Product p inner JOIN  Picture i ON p.picID = i.picID  inner JOIN Category c ON p.CategoryID = c.CategoryID\n"
                        + "where p.CategoryID = 06 and p.status=1";
                //3. Create statement
                stm = con.prepareStatement(sql);

                //4. Execute Query
                rs = stm.executeQuery();
                //5. Process result
                while (rs.next()) {
                    //get field/column
                    String productID = rs.getString("productID");
                    String proName = rs.getString("proName");
                    String description = rs.getString("description");
                    int yearPublish = rs.getInt("yearPublish");
                    float price = rs.getFloat("price");
                    String catgoryName = rs.getString("catgoryName");
                    byte[] picData = rs.getBytes("picdata");
                    String picID = rs.getString("picID");

                    //Create DTO instance
                    ProductDTO dto = new ProductDTO(productID, proName, description, yearPublish, price, catgoryName, picID, picData);
                    //add to bookList
                    if (this.itemsList == null) {
                        this.itemsList = new ArrayList<>();
                    }//end bookList is not existed
                    this.itemsList.add(dto);
                }//end bookList is traversed
            }//end con is available
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
 
 
 public void showProductInFruitCategory()
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Get connection
            con = DBHelper.makeConnection();
            if (con != null) {
                //2. Create sql string

                String sql = "select * \n"
                        + "FROM Product p inner JOIN  Picture i ON p.picID = i.picID  inner JOIN Category c ON p.CategoryID = c.CategoryID\n"
                        + "where p.CategoryID = 02 and p.status=1";
                //3. Create statement
                stm = con.prepareStatement(sql);

                //4. Execute Query
                rs = stm.executeQuery();
                //5. Process result
                while (rs.next()) {
                    //get field/column
                    String productID = rs.getString("productID");
                    String proName = rs.getString("proName");
                    String description = rs.getString("description");
                    int yearPublish = rs.getInt("yearPublish");
                    float price = rs.getFloat("price");
                    String catgoryName = rs.getString("catgoryName");
                    byte[] picData = rs.getBytes("picdata");
                    String picID = rs.getString("picID");

                    //Create DTO instance
                    ProductDTO dto = new ProductDTO(productID, proName, description, yearPublish, price, catgoryName, picID, picData);
                    //add to bookList
                    if (this.itemsList == null) {
                        this.itemsList = new ArrayList<>();
                    }//end bookList is not existed
                    this.itemsList.add(dto);
                }//end bookList is traversed
            }//end con is available
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
 
 public void showProductInMeatCategory()
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Get connection
            con = DBHelper.makeConnection();
            if (con != null) {
                //2. Create sql string

                String sql = "select * \n"
                        + "FROM Product p inner JOIN  Picture i ON p.picID = i.picID  inner JOIN Category c ON p.CategoryID = c.CategoryID\n"
                        + "where p.CategoryID = 05 and p.status=1";
                //3. Create statement
                stm = con.prepareStatement(sql);

                //4. Execute Query
                rs = stm.executeQuery();
                //5. Process result
                while (rs.next()) {
                    //get field/column
                    String productID = rs.getString("productID");
                    String proName = rs.getString("proName");
                    String description = rs.getString("description");
                    int yearPublish = rs.getInt("yearPublish");
                    float price = rs.getFloat("price");
                    String catgoryName = rs.getString("catgoryName");
                    byte[] picData = rs.getBytes("picdata");
                    String picID = rs.getString("picID");

                    //Create DTO instance
                    ProductDTO dto = new ProductDTO(productID, proName, description, yearPublish, price, catgoryName, picID, picData);
                    //add to bookList
                    if (this.itemsList == null) {
                        this.itemsList = new ArrayList<>();
                    }//end bookList is not existed
                    this.itemsList.add(dto);
                }//end bookList is traversed
            }//end con is available
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
    public void showProductInVegetCategory()
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Get connection
            con = DBHelper.makeConnection();
            if (con != null) {
                //2. Create sql string

                String sql = "select * \n"
                        + "FROM Product p inner JOIN  Picture i ON p.picID = i.picID  inner JOIN Category c ON p.CategoryID = c.CategoryID\n"
                        + "where p.CategoryID = 03 and p.status=1";
                //3. Create statement
                stm = con.prepareStatement(sql);

                //4. Execute Query
                rs = stm.executeQuery();
                //5. Process result
                while (rs.next()) {
                    //get field/column
                    String productID = rs.getString("productID");
                    String proName = rs.getString("proName");
                    String description = rs.getString("description");
                    int yearPublish = rs.getInt("yearPublish");
                    float price = rs.getFloat("price");
                    String catgoryName = rs.getString("catgoryName");
                    byte[] picData = rs.getBytes("picdata");
                    String picID = rs.getString("picID");

                    //Create DTO instance
                    ProductDTO dto = new ProductDTO(productID, proName, description, yearPublish, price, catgoryName, picID, picData);
                    //add to bookList
                    if (this.itemsList == null) {
                        this.itemsList = new ArrayList<>();
                    }//end bookList is not existed
                    this.itemsList.add(dto);
                }//end bookList is traversed
            }//end con is available
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
    public void showProductInMilkCategory()
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Get connection
            con = DBHelper.makeConnection();
            if (con != null) {
                //2. Create sql string

                String sql = "select * \n"
                        + "FROM Product p inner JOIN  Picture i ON p.picID = i.picID  inner JOIN Category c ON p.CategoryID = c.CategoryID\n"
                        + "where p.CategoryID = 04 and p.status=1";
                //3. Create statement
                stm = con.prepareStatement(sql);

                //4. Execute Query
                rs = stm.executeQuery();
                //5. Process result
                while (rs.next()) {
                    //get field/column
                    String productID = rs.getString("productID");
                    String proName = rs.getString("proName");
                    String description = rs.getString("description");
                    int yearPublish = rs.getInt("yearPublish");
                    float price = rs.getFloat("price");
                    String catgoryName = rs.getString("catgoryName");
                    byte[] picData = rs.getBytes("picdata");
                    String picID = rs.getString("picID");

                    //Create DTO instance
                    ProductDTO dto = new ProductDTO(productID, proName, description, yearPublish, price, catgoryName, picID, picData);
                    //add to bookList
                    if (this.itemsList == null) {
                        this.itemsList = new ArrayList<>();
                    }//end bookList is not existed
                    this.itemsList.add(dto);
                }//end bookList is traversed
            }//end con is available
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    
    public void showProducts()
    throws SQLException, NamingException {
    Connection con = null;
    PreparedStatement stm = null;
    ResultSet rs = null;
    try {
        //1. Get connection
        con = DBHelper.makeConnection();
        if (con != null) {
            //2. Create sql string
            String sql = "SELECT * FROM Product p " +
                    "INNER JOIN Picture i ON p.picID = i.picID " +
                    "INNER JOIN Category c ON p.CategoryID = c.CategoryID " +
                    "WHERE p.status = 1\n" +
                    "ORDER BY p.proName ASC;"; // Add WHERE clause to filter by status

            //3. Create statement
            stm = con.prepareStatement(sql);

            //4. Execute Query
            rs = stm.executeQuery();
            //5. Process result
            while (rs.next()) {
                //get field/column
                String productID = rs.getString("productID");
                String proName = rs.getString("proName");
                String description = rs.getString("description");
                int yearPublish = rs.getInt("yearPublish");
                float price = rs.getFloat("price");
                String catgoryName = rs.getString("catgoryName");
                byte[] picData = rs.getBytes("picdata");
                String picID = rs.getString("picID");

                //Create DTO instance
                ProductDTO dto = new ProductDTO(productID, proName, description, yearPublish, price, catgoryName, picID, picData);
                //add to bookList
                if (this.itemsList == null) {
                    this.itemsList = new ArrayList<>();
                }//end bookList is not existed
                this.itemsList.add(dto);
            }//end bookList is traversed
        }//end con is available
    } finally {
        if (rs != null) {
            rs.close();
        }
        if (stm != null) {
            stm.close();
        }
        if (con != null) {
            con.close();
        }
    }
}
}
