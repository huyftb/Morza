/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import dto.ShipDTO;
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
public class ShipDAO implements Serializable{
    
       public ShipDTO checkLogin(String username, String password) 
        throws NamingException, SQLException {
        
         Connection con = null;
        
        PreparedStatement stm = null;
        ResultSet rs = null;
        ShipDTO result = null;

        try {
           
            con = DBHelper.makeConnection();

            if (con != null) {

              
                String sql = "Select * "
                        + "From Shipper "
                        + "Where username = ? And password = ?";

                stm = con.prepareStatement(sql);
              
                stm.setString(1, username);
                stm.setString(2, password);

                
                rs = stm.executeQuery();

               
                if (rs.next()) { 
                    String shipID = rs.getString("shipID");
                    int shipPhone = rs.getInt("shipPhone");
                    String shipName = rs.getString("shipName");
                  
                 result = new ShipDTO(shipID, shipPhone, shipName, username, password);
                    
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
