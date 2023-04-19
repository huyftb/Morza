/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.HashMap;

/**
 *
 * @author kienb
 */
public class OrderDTO {
    private int id;
    private double price;
    private String username;
    private HashMap<ProductDTO,Integer> map;
    private int phone;
    private String address;
    private String email;
    public OrderDTO() {
    }

    public OrderDTO(int id, double price, String username) {
        this.id = id;
        this.price = price;
        this.username = username;
    }
    public OrderDTO( String username, String email,int phone, String address, int id) {
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.id = id;
        
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public HashMap<ProductDTO, Integer> getMap() {
        return map;
    }

    public void setMap(HashMap<ProductDTO, Integer> map) {
        this.map = map;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
