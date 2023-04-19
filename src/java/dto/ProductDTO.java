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
public class ProductDTO implements Serializable{

    private String productID;
    private String proName;
    private String description;
    private int yearPublish;
    private float price;
    private String categoryID;
    private String catgoryName;
    private String picID;
    private String filename;
    private byte[] picData;
    private String base64ImageData;

    public ProductDTO() {
    }
        public ProductDTO(String categoryID, String catgoryName) {
        this.categoryID = categoryID;
        this.catgoryName = catgoryName;

    }

    public ProductDTO(String productID, String proName, String description, int yearPublish, float price, String catgoryName) {
        this.productID = productID;
        this.proName = proName;
        this.description = description;
        this.yearPublish = yearPublish;
        this.price = price;
        this.catgoryName = catgoryName;
    }
    public ProductDTO(String productID, String picID, byte[] picData ) {
        this.productID = productID;
        this.picID = picID;
        this.picData = picData;

    }
    public ProductDTO(String productID, String proName, String description, int yearPublish, float price, String catgoryName, byte[] picData) {
        this.productID = productID;
        this.proName = proName;
        this.description = description;
        this.yearPublish = yearPublish;
        this.price = price;
        this.catgoryName = catgoryName;
        this.picData = picData;
    }
    public ProductDTO(String productID, String proName, String description, int yearPublish, float price, String catgoryName, String picID, String filename) {
        this.productID = productID;
        this.proName = proName;
        this.description = description;
        this.yearPublish = yearPublish;
        this.price = price;
        this.catgoryName = catgoryName;
        this.picID = picID;
        this.filename = filename;
    }
    public ProductDTO(String productID, String proName, String description, int yearPublish, float price, String catgoryName, String picID, byte[] picData) {
        this.productID = productID;
        this.proName = proName;
        this.description = description;
        this.yearPublish = yearPublish;
        this.price = price;
        this.catgoryName = catgoryName;
        this.picID = picID;
        this.picData = picData;
    }

    public ProductDTO(String productID, String proName, String description, int yearPublish, float price, String catgoryName, String picID, byte[] picData, String base64ImageData) {
        this.productID = productID;
        this.proName = proName;
        this.description = description;
        this.yearPublish = yearPublish;
        this.price = price;
        this.catgoryName = catgoryName;
        this.picID = picID;
        this.picData = picData;
        this.base64ImageData = base64ImageData;
    }
    
    public ProductDTO(String productID, String proName, String description, float price, String picID) {
        this.productID = productID;
        this.proName = proName;
        this.description = description;
        this.price = price;
        this.picID = picID;
    }

    
    /**
     * @return the productID
     */
    public String getProductID() {
        return productID;
    }

    /**
     * @param productID the productID to set
     */
    public void setProductID(String productID) {
        this.productID = productID;
    }

    /**
     * @return the proName
     */
    public String getProName() {
        return proName;
    }

    /**
     * @param proName the proName to set
     */
    public void setProName(String proName) {
        this.proName = proName;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the yearPublish
     */
    public int getYearPublish() {
        return yearPublish;
    }

    /**
     * @param yearPublish the yearPublish to set
     */
    public void setYearPublish(int yearPublish) {
        this.yearPublish = yearPublish;
    }

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * @return the catgoryName
     */
    public String getCatgoryName() {
        return catgoryName;
    }

    /**
     * @param catgoryName the catgoryName to set
     */
    public void setCatgoryName(String catgoryName) {
        this.catgoryName = catgoryName;
    }

    /**
     * @return the picID
     */
    public String getPicID() {
        return picID;
    }

    /**
     * @param picID the picID to set
     */
    public void setPicID(String picID) {
        this.picID = picID;
    }



    /**
     * @return the picData
     */
    public byte[] getPicData() {
        return picData;
    }

    /**
     * @param picData the picData to set
     */
    public void setPicData(byte[] picData) {
        this.picData = picData;
    }


    /**
     * @return the base64ImageData
     */
    public String getBase64ImageData() {
        return base64ImageData;
    }

    /**
     * @param base64ImageData the base64ImageData to set
     */
    public void setBase64ImageData(String base64ImageData) {
        this.base64ImageData = base64ImageData;
    }

    /**
     * @return the categoryID
     */
    public String getCategoryID() {
        return categoryID;
    }

    /**
     * @param categoryID the categoryID to set
     */
    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    /**
     * @return the filename
     */
    public String getFilename() {
        return filename;
    }

    /**
     * @param filename the filename to set
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }



    
    

    
}
