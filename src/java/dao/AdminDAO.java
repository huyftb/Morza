/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.AdminDTO;
import dto.CustomerDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import utils.DBHelper;

/**
 *
 * @author DELL
 */
public class AdminDAO implements Serializable{
    // check login
    public AdminDTO checkLogin(String username, String password) 
        throws NamingException, SQLException {
        
        Connection con = null;
        
        PreparedStatement stm = null;
        ResultSet rs = null;
        AdminDTO result = null;

        try {
           
            con = DBHelper.makeConnection();

            if (con != null) {

              
                String sql = "Select AdminID, username, fullname "
                        + "From Admin "
                        + "Where username = ? And password = ?";

                stm = con.prepareStatement(sql);
              
                stm.setString(1, username);
                stm.setString(2, password);

                
                rs = stm.executeQuery();

               
                if (rs.next()) {  
//                    String custID = rs.getString("custID");
//                    String phoneNum = rs.getString("phoneNum");
//                    String address = rs.getString("address");
                    String fullname = rs.getString("fullname");
                    String AdminID = rs.getString("AdminID");
//                    String email = rs.getString("email");
//                    result = new CustomerDTO(custID, username, password, phoneNum, address, custName, email);
                    result = new AdminDTO(AdminID, fullname, username, password);
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
}