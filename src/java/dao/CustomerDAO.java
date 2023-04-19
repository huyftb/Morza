/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.CustomerDTO;
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
 * 
 */
public class CustomerDAO implements Serializable{
    
    private List<CustomerDTO> itemsList;
    public  List<CustomerDTO> getItemsList() {
        return itemsList;
    }
    
    // check login
    public CustomerDTO checkLogin(String username, String password) 
        throws NamingException, SQLException {
        
         Connection con = null;
        
        PreparedStatement stm = null;
        ResultSet rs = null;
        CustomerDTO result = null;

        try {
           
            con = DBHelper.makeConnection();

            if (con != null) {

              
                String sql = "Select * "
                        + "From Customer "
                        + "Where username = ? And password = ? and status = 1";

                stm = con.prepareStatement(sql);
              
                stm.setString(1, username);
                stm.setString(2, password);

                
                rs = stm.executeQuery();

               
                if (rs.next()) { 
                    String phoneNum = rs.getString("phoneNum");
                    String address = rs.getString("address");
                    String custName = rs.getString("custName");
                    String email = rs.getString("email");
//                    result = new CustomerDTO(custID, username, password, phoneNum, address, custName, email);
                    result = new CustomerDTO(username,password, phoneNum, address, custName, email);
                }

            } //end if connection is existed
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
        return result;
    }
    
   public boolean createAccount (CustomerDTO dto) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;

        try {
            //1. Connect DB
            con = DBHelper.makeConnection();

            if (con != null) {

                //2. Create SQL statement String
                String sql = "Insert into Customer("
                        + "username, password, phoneNum, address, custName, email, status"
                        + ") "
                        + "values(?, ?, ?, ?, ?, ?, 1"
                        + ")";

                //3. Create statement to set SQL
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getUsername());
                stm.setString(2, dto.getPassword());
                stm.setString(3, dto.getPhoneNum());
                stm.setString(4, dto.getAddress());
                stm.setString(5, dto.getCustName());
                stm.setString(6, dto.getEmail());

                //4.Execute Query
                int effectedRow = stm.executeUpdate();
                //5. Process 
                // trả về nhiều dòng dùng while/ một dòng dùng if
                if (effectedRow > 0) {
                    result = true;
                }

            } //end if connection is existed
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
    public void searchAccount(String searchValue)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Get connection
            con = DBHelper.makeConnection();
            if (con != null) {
                //2. Create sql string
                String sql = "Select username, password, phoneNum, custName, address, email\n"
                        + "From Customer\n"
                        + "Where username Like ? and status =1"
                        + "OR custName Like ? and status =1"
                        + "OR email Like ? and status =1";
                //3. Create statement
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");
                stm.setString(2, "%" + searchValue + "%");
                stm.setString(3, "%" + searchValue + "%");
                //4. Execute Query
                rs = stm.executeQuery();
                //5. Process result
                while (rs.next()) {
                    //get field/column
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String phoneNum = rs.getString("phoneNum");
                    String custName = rs.getString("custName");
                    String address = rs.getString("address");
                    String email = rs.getString("email");
                    //Create DTO instance
                    CustomerDTO dto = new CustomerDTO(username, password, phoneNum, address, custName, email);
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
//    public boolean updateAccount(CustomerDTO dto) throws SQLException {
//        Connection con = null;
//        PreparedStatement stm = null;
//        boolean checkUpdate = true;
//        try {
//            //1. Connect DB
//            con = DBHelper.makeConnection();
//            //2. Create SQL String
////            if (con != null) {
//                //3. Create statement
//                if (con != null) {
//                                    String sql = "Update Customer "
//                        + "SET password = ?, phoneNum = ?,  custName = ?, address = ?, email = ? \n"
//                        + "Where username = ?";
//                stm = con.prepareStatement(sql);
//                stm.setString(1, dto.getPassword());
//                stm.setString(2, dto.getPhoneNum());
//                stm.setString(3, dto.getCustName());
//                stm.setString(4, dto.getAddress());
//                stm.setString(5, dto.getEmail());
//                stm.setString(6, dto.getUsername());
//                checkUpdate = stm.executeUpdate()> 0 ? true : false;
//                }
//                //4. Execute query
////                int effectedRows = stm.executeUpdate();
//                //5. Process result
////                if (effectedRows > 0) {
////                    checkUpdate = true;
////                }
////            }
//
//        } catch (SQLException | NamingException e) {
//            e.printStackTrace();
//        } finally {
//            if (stm != null) {
//                stm.close();
//            }
//            if (con != null) {
//                con.close();
//            }
//        }
//        return checkUpdate;
//    }
    public void showAcc()
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Get connection
            con = DBHelper.makeConnection();
            if (con != null) {
                //2. Create sql string
                String sql = "Select username, password, phoneNum, custName, address, email\n"
                        + "From Customer ";
                //3. Create statement
                stm = con.prepareStatement(sql);
                //4. Execute Query
                rs = stm.executeQuery();
                //5. Process result
                while (rs.next()) {
                    //get field/column
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String phoneNum = rs.getString("phoneNum");
                    String custName = rs.getString("custName");
                    String address = rs.getString("address");
                    String email = rs.getString("email");
                    //Create DTO instance
                    CustomerDTO dto = new CustomerDTO(username, password, phoneNum, address, custName, email);
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
    
    
       public String getCustName(String username) 
            throws NamingException, SQLException {
        
        String custName = null;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            if (username == null || username.trim().isEmpty()) {
//              result = false;
            } else {
                con = DBHelper.makeConnection();
                if (con != null) {
                    String sqlStr = "SELECT custName "
                            + "FROM Customer "
                            + "WHERE username = ?";
                    stmt = con.prepareStatement(sqlStr);
                    stmt.setString(1, username);
                    rs = stmt.executeQuery();
                    if (rs.next()) {
                        custName = rs.getString("custName");
                    }
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
        return custName;
        
    }
       public boolean deleteAccount(String username)
            throws SQLException,  NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            //1. Connect DB
        con = DBHelper.makeConnection();

            if (con != null) {
                //2.tạo SQL statement String
                String sql = "Delete From Customer "
                        + "Where username = ? ";
                //3.Tạo statement dể nạp SQL vào  
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
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
       
       
//       public CustomerDTO getAccountByUsername(String username)
//            throws SQLException, NamingException  {
//        Connection con = null;
//        PreparedStatement stm = null;
//        ResultSet rs = null;
//        CustomerDTO account = null;
//        try {
//            //1. Get connection
//            con = DBHelper.makeConnection();
//            if (con != null) {
//                //2. Create sql string
//                String sql = "Select * "
//                        + "From Customer "
//                        + "where username = ? ";
//           
//                stm = con.prepareStatement(sql);
//                stm.setString(1, username);
//                rs = stm.executeQuery();
//             
//                while (rs.next()) {
//                   String password = rs.getString("password");
//                   String phoneNum = rs.getString("phoneNum");
//                   String address = rs.getString("address");
//                   String fullName = rs.getString("custName");
//                   String email = rs.getString("email");
//                   account = new CustomerDTO(username, password, phoneNum, address, fullName, email);
//                   
//                }
//            }
//        } finally {
//            if (rs != null) {
//                rs.close();
//            }
//            if (stm != null) {
//                stm.close();
//            }
//            if (con != null) {
//                con.close();
//            }
//        }
//        return account;
//    }
      
   public List<CustomerDTO> getItemsListByUsername(String username) throws SQLException, NamingException {
    Connection con = null;
    PreparedStatement stm = null;
    ResultSet rs = null;
    List<CustomerDTO> list = new ArrayList<>();

    try {
        con = DBHelper.makeConnection();
        if (con != null) {
            String sql = "SELECT * FROM Customer WHERE username=?";
            stm = con.prepareStatement(sql);
            stm.setString(1, username);
            rs = stm.executeQuery();
            while (rs.next()) {
                String password = rs.getString("password");
                String custName = rs.getString("custName");
                String phoneNum = rs.getString("phoneNum");
                String email = rs.getString("email");
                String address = rs.getString("address");
                CustomerDTO dto = new CustomerDTO(username, password, phoneNum, address, custName, email);
                list.add(dto);
            }
        }
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

    return list;
}
       
       
       public String getPassword(String username) 
            throws NamingException, SQLException {
        
        String password = null;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            if (username == null || username.trim().isEmpty()) {
//              result = false;
            } else {
                con = DBHelper.makeConnection();
                if (con != null) {
                    String sqlStr = "SELECT password "
                            + "FROM Customer "
                            + "WHERE username = ?";
                    stmt = con.prepareStatement(sqlStr);
                    stmt.setString(1, username);
                    rs = stmt.executeQuery();
                    if (rs.next()) {
                        password = rs.getString("password");
                    }
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
        return password;
        
    }
       
       public String getPhoneNum(String username) 
            throws NamingException, SQLException {
        
        String phoneNum = null;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            if (username == null || username.trim().isEmpty()) {
//              result = false;
            } else {
                con = DBHelper.makeConnection();
                if (con != null) {
                    String sqlStr = "SELECT phoneNum "
                            + "FROM Customer "
                            + "WHERE username = ?";
                    stmt = con.prepareStatement(sqlStr);
                    stmt.setString(1, username);
                    rs = stmt.executeQuery();
                    if (rs.next()) {
                        phoneNum = rs.getString("phoneNum");
                    }
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
        return phoneNum;
        
    }
       public String getEmail(String username) 
            throws NamingException, SQLException {
        
        String email = null;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            if (username == null || username.trim().isEmpty()) {
//              result = false;
            } else {
                con = DBHelper.makeConnection();
                if (con != null) {
                    String sqlStr = "SELECT email "
                            + "FROM Customer "
                            + "WHERE username = ?";
                    stmt = con.prepareStatement(sqlStr);
                    stmt.setString(1, username);
                    rs = stmt.executeQuery();
                    if (rs.next()) {
                        email = rs.getString("email");
                    }
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
        return email;
        
    }
       public String getAddress(String username) 
            throws NamingException, SQLException {
        
        String address = null;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            if (username == null || username.trim().isEmpty()) {
//              result = false;
            } else {
                con = DBHelper.makeConnection();
                if (con != null) {
                    String sqlStr = "SELECT address "
                            + "FROM Customer "
                            + "WHERE username = ?";
                    stmt = con.prepareStatement(sqlStr);
                    stmt.setString(1, username);
                    rs = stmt.executeQuery();
                    if (rs.next()) {
                        address = rs.getString("address");
                    }
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
        return address;
        
    }
    
        public void getAccounts() 
        throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sqlStr = "SELECT * "
                        + "FROM Customer";
                stmt = con.prepareStatement(sqlStr);
                rs = stmt.executeQuery();
                
                while (rs.next()) {
                    CustomerDTO dto = new CustomerDTO(
                                            rs.getString("username"),  
                                            rs.getString("password"),
                                            rs.getString("phoneNum"),
                                            rs.getString("address"), 
                                            rs.getString("custName"),
                                            rs.getString("email"));
                    if (this.itemsList == null) {
                        this.itemsList = new ArrayList<>();
                    }
                    this.itemsList.add(dto);
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
    }
        
        public CustomerDTO getAccount(String username) 
            throws SQLException, NamingException {
        
        CustomerDTO result = null;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sqlStr = "SELECT * "
                        + "FROM Customer "
                        + "WHERE username like ?";
                stmt = con.prepareStatement(sqlStr);
                stmt.setString(1, username);
                rs = stmt.executeQuery();
                
                while (rs.next()) {
                    result = new CustomerDTO(
                                    rs.getString("username"),  
                                            rs.getString("password"),
                                            rs.getString("phoneNum"),
                                            rs.getString("address"), 
                                            rs.getString("custName"),
                                            rs.getString("email"));
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
        return null;
    }
        
        
        public void updateAccount (String username, 
            String password, String phoneNum, String address, String custName, String email) 
        throws SQLException, NamingException {
        
     
        
        Connection con = null;
        PreparedStatement stmt = null;
        
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sqlStr = "UPDATE Customer "
                        + "SET password = ?, phoneNum = ?, address = ?, custName = ?, email = ? "
                        + "WHERE username = ?";
                stmt = con.prepareStatement(sqlStr);
                stmt.setString(1, password);
                stmt.setString(2, phoneNum);
                stmt.setString(3, address);
                stmt.setString(3, custName);
                stmt.setString(4, email);
                
               stmt.executeUpdate();
                
            }
        }
        finally {
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        }
        
       
    }
        
        public boolean checkpayment(String payment_type, String username)
            throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        boolean result = false;

        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "Select payment_type, username From Payment Where cardnumber = ? AND payment_type = ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, "payment_type");
                stm.setString(2, "username");
                rs = stm.executeQuery();
                if (rs.next()) {
                    result = true;
                }
            }
        } finally {
            // close resources
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
        return result;
    }
public void getPayment(String payment_type, String username)
            throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Get connection
            con = DBHelper.makeConnection();
            if (con != null) {
                //2. Create sql string
                String sql = "Select * From Payment Where username = ? AND payment_type = ? ";
                //3. Create statement
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, payment_type);
                //4. Execute Query
                rs = stm.executeQuery();
                //5. Process result
                while (rs.next()) {

                    String cardname = rs.getString("cardname");
                    int cardnumber = rs.getInt("cardnumber");
                    String serNum = rs.getString("serNum");
                }
                //Create DTO instance
                CustomerDTO dto = new CustomerDTO(username, username, username);
                //add to bookList
                if (this.itemsList == null) {
                    this.itemsList = new ArrayList<>();
                }//end bookList is not existed
                this.itemsList.add(dto);
            }//end bookList is traversed
        } finally {

        }

    }
public boolean disableAccount(String username) throws SQLException, NamingException {
    Connection con = null;
    PreparedStatement stm = null;
    boolean result = false;
    try {
        //1. Connect to DB
        con = DBHelper.makeConnection();

        if (con != null) {
            //2. Create SQL statement String
            String sql = "UPDATE Customer SET status = 0 WHERE username = ?";
            //3. Create statement to set SQL
            stm = con.prepareStatement(sql);
            stm.setString(1, username);
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
public boolean updateAccount_1(String username, String password, String phoneNum, String address, String custName, String email) 
        throws SQLException, NamingException {
        
    Connection con = null;
    PreparedStatement stmt = null;
    
    try {
        con = DBHelper.makeConnection();
        if (con != null) {
            String sqlStr = "UPDATE Customer "
                    + "SET password = ?, phoneNum = ?,custName = ?,  email = ?, address = ? "
                    + "WHERE username = ?";
            stmt = con.prepareStatement(sqlStr);
            stmt.setString(1, password);
            stmt.setString(2, phoneNum);
            stmt.setString(3, custName);
            stmt.setString(4, email);
            stmt.setString(5, address);
            stmt.setString(6, username);
            
            int rowsAffected = stmt.executeUpdate();
            
            return rowsAffected > 0;
        }
    } finally {
        if (stmt != null) {
            stmt.close();
        }
        if (con != null) {
            con.close();
        }
    }
    
    return false;
}
}
