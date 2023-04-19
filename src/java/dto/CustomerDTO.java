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
public class CustomerDTO implements Serializable{
    
    private String username;
    private String password;
    private String phoneNum;
    private String address;
    private String custName;
    private String email;
    private String cardNumber;
    private String cardName;
    private String sercurityCode;


    public CustomerDTO() {
    }

    public CustomerDTO(String username, String password, String phoneNum, String address, String custName, String email) {
        
        this.username = username;
        this.password = password;
        this.phoneNum = phoneNum;
        this.address = address;
        this.custName = custName;
        this.email = email;
    }

    

   public CustomerDTO(  String cardNumber, String cardName, String sercurityCode) {
        this.cardNumber = cardNumber;
        this.cardName = cardName;
        this.sercurityCode = sercurityCode;
    }


   

    /**
     * @return the custID
     */
  
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

    /**
     * @return the phoneNum
     */
    public String getPhoneNum() {
        return phoneNum;
    }

    /**
     * @param phoneNum the phoneNum to set
     */
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the custName
     */
    public String getCustName() {
        return custName;
    }

    /**
     * @param custName the custName to set
     */
    public void setCustName(String custName) {
        this.custName = custName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the cardNumber
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * @param cardNumber the cardNumber to set
     */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * @return the cardName
     */
    public String getCardName() {
        return cardName;
    }

    /**
     * @param cardName the cardName to set
     */
    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    /**
     * @return the sercurityCode
     */
    public String getSercurityCode() {
        return sercurityCode;
    }

    /**
     * @param sercurityCode the sercurityCode to set
     */
    public void setSercurityCode(String sercurityCode) {
        this.sercurityCode = sercurityCode;
    }
   
    
}
