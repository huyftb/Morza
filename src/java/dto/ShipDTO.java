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
public class ShipDTO implements Serializable{
    private String shipID;
    private int shipPhone;
    private String shipName;
    private String username;
    private String password;

    public ShipDTO() {
    }

    public ShipDTO(String shipID, int shipPhone, String shipName, String username, String password) {
        this.shipID = shipID;
        this.shipPhone = shipPhone;
        this.shipName = shipName;
        this.username = username;
        this.password = password;
    }

    public String getShipID() {
        return shipID;
    }

    public void setShipID(String shipID) {
        this.shipID = shipID;
    }

    public int getShipPhone() {
        return shipPhone;
    }

    public void setShipPhone(int shipPhone) {
        this.shipPhone = shipPhone;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
