/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.CustomerDAO;
import dto.CustomerDTO;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author DELL
 */
public class Test {
    public static void main(String[] args) throws SQLException, NamingException {
        CustomerDAO dao = new CustomerDAO();
CustomerDTO dto = dao.getAccount("hihihi");
        System.out.println(dto);
       
       }
        
        
           
        }
    

