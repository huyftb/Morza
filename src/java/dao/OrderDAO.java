/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.OrderDTO;
import dto.ProductDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import utils.DBHelper;

/**
 *
 * @author DELL
 */
public class OrderDAO implements Serializable {

    private static Connection con = null;

    private static PreparedStatement stm = null;
    private static ResultSet rs = null;

    public static void insertOrder(String username, double price) {
        try {

            con = DBHelper.makeConnection();

            if (con != null) {

                String sql = "INSERT INTO [dbo].[Orders]\n"
                        + "           ([totalPrice]\n"
                        + "           ,[username]\n"
                        + "           ,[shipID])\n"
                        + "     VALUES\n"
                        + "           (?,?, dbo.GetRandomShipID())";

                stm = con.prepareStatement(sql);

                stm.setString(2, username);
                stm.setDouble(1, price);
                stm.executeUpdate();
            } //end if connection is existed
        } catch (NamingException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void insertTransaction (String username, String email,int phone, String address, int OrderID) {
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "INSERT INTO [dbo].[Transaction] (fullname, address, email, phoneNum, orderID) \n"
                        + " VALUES "
                        + " ( ?, ?, ?, ?, ?)";
                stm = con.prepareStatement(sql);
                stm.setNString(1, username);
                stm.setNString(2, address);
                stm.setString(3, email);
                stm.setInt(4, phone);
                stm.setInt(5, OrderID);
                stm.executeUpdate();
            } //end if connection is existed
        } catch (NamingException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static int getIDByLastOrder() {
        try {

            con = DBHelper.makeConnection();

            if (con != null) {

                String sql = "select top 1 * from Orders order by orderID desc";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                if (rs.next()) {
                    return rs.getInt(1);
                }
            } //end if connection is existed
        } catch (NamingException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static void insertOrderDetail(int orderID, String productID, int quantity) {
        try {

            con = DBHelper.makeConnection();

            if (con != null) {

                String sql = "INSERT INTO [dbo].[OrderDetail]\n"
                        + "           ([orderID]\n"
                        + "           ,[productID]\n"
                        + "           ,[quantity])\n"
                        + "     VALUES\n"
                        + "           (?\n"
                        + "           ,?\n"
                        + "           ,?)";

                stm = con.prepareStatement(sql);

                stm.setInt(1, orderID);
                stm.setString(2, productID);
                stm.setInt(3, quantity);
                stm.executeUpdate();
            } //end if connection is existed
        } catch (NamingException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static List<OrderDTO> getAllOrderByUserName(String username) {
        List<OrderDTO> list = new ArrayList<>();
        try {
            con = DBHelper.makeConnection();

            if (con != null) {

                String sql = "Select * from Orders where username = ?";

                stm = con.prepareStatement(sql);

                stm.setString(1, username);
                rs = stm.executeQuery();
                while (rs.next()) {
                    OrderDTO orderDTO = new OrderDTO(rs.getInt(1), rs.getDouble(4), username);
                    list.add(orderDTO);
                }
            } //end if connection is existed
        } catch (NamingException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static HashMap<ProductDTO, Integer> getProductsByOrderID(int orderID) {
        HashMap<ProductDTO, Integer> list = new HashMap<>();
        try {
            con = DBHelper.makeConnection();

            if (con != null) {

                String sql = "SELECT *\n"
                        + "  FROM [SWP301].[dbo].[OrderDetail] where orderID = ?";

                stm = con.prepareStatement(sql);

                stm.setInt(1, orderID);
                rs = stm.executeQuery();
                ProductDAO pdo = new ProductDAO();
                while (rs.next()) {
                    ProductDTO p = pdo.getProductbyID(rs.getString(2));
                    list.put(p, rs.getInt(3));
                }
            } //end if connection is existed
        } catch (NamingException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public boolean confirmOrder(int orderID) throws SQLException, NamingException {
    Connection con = null;
    PreparedStatement stm = null;
    boolean result = false;
    try {
        //1. Connect to DB
        con = DBHelper.makeConnection();

        if (con != null) {
            //2. Create SQL statement String
            String sql = "UPDATE Orders SET status = 1 WHERE orderID= ?\n";
            //3. Create statement to set SQL
            stm = con.prepareStatement(sql);
            stm.setInt(1, orderID);
            //4. Execute Query
            int effectedRow = stm.executeUpdate();
            //5. Process
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
    
    public String getOrderStatus(int orderID) throws SQLException, NamingException {
    Connection con = null;
    PreparedStatement stm = null;
    ResultSet rs = null;
    String status = null;
    
    try {
        //1. Connect to DB
        con = DBHelper.makeConnection();

        if (con != null) {
            //2. Create SQL statement String
            String sql = "SELECT status FROM Orders WHERE orderID = ?";
            //3. Create statement to set SQL
            stm = con.prepareStatement(sql);
            stm.setInt(1, orderID);
            //4. Execute Query
            rs = stm.executeQuery();
            //5. Process
            if (rs.next()) {
                boolean isDelivered = rs.getBoolean("status");
                status = isDelivered ? "Delivered" : "Process";
            }
        }// end if connection is exist
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
    return status;
}
}
