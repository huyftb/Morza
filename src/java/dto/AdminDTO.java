/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;

/**
 *
 * @author DELL
 */
public class AdminDTO implements Serializable{
     private String AdminID;
    private String fullname;
    private String username;
    private String password;

    public AdminDTO() {
    }

    public AdminDTO(String AdminID, String fullname, String username, String password) {
        this.AdminID = AdminID;
        this.fullname = fullname;
        this.username = username;
        this.password = password;
    }

   
    

    /**
     * @return the AdminID
     */
    public String getAdminID() {
        return AdminID;
    }

    /**
     * @param AdminID the AdminID to set
     */
    public void setAdminID(String AdminID) {
        this.AdminID = AdminID;
    }

    /**
     * @return the fullname
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * @param fullname the fullname to set
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
   
    
}
