/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package error;

import java.io.Serializable;

/**
 *
 * @author DELL
 */
public class ProductCreateError implements Serializable{
     private String IdSyntaxError;
     private String NameLengthError;
    private String DescripLengthError;
    private String PriceRangeError;
    private String YearRangeError;
    private String IdIsExisted;
    private String errorMsg;

    public ProductCreateError() {
    }

    public ProductCreateError(String IdSyntaxError, String NameLengthError, String DescripLengthError, String PriceRangeError, String YearRangeError, String IdIsExisted, String errorMsg) {
        this.IdSyntaxError = IdSyntaxError;
        this.NameLengthError = NameLengthError;
        this.DescripLengthError = DescripLengthError;
        this.PriceRangeError = PriceRangeError;
        this.YearRangeError = YearRangeError;
        this.IdIsExisted = IdIsExisted;
        this.errorMsg = errorMsg;
    }

    public String getIdSyntaxError() {
        return IdSyntaxError;
    }

    public void setIdSyntaxError(String IdSyntaxError) {
        this.IdSyntaxError = IdSyntaxError;
    }

    public String getNameLengthError() {
        return NameLengthError;
    }

    public void setNameLengthError(String NameLengthError) {
        this.NameLengthError = NameLengthError;
    }

    public String getDescripLengthError() {
        return DescripLengthError;
    }

    public void setDescripLengthError(String DescripLengthError) {
        this.DescripLengthError = DescripLengthError;
    }

    public String getPriceRangeError() {
        return PriceRangeError;
    }

    public void setPriceRangeError(String PriceRangeError) {
        this.PriceRangeError = PriceRangeError;
    }

    public String getYearRangeError() {
        return YearRangeError;
    }

    public void setYearRangeError(String YearRangeError) {
        this.YearRangeError = YearRangeError;
    }

    public String getIdIsExisted() {
        return IdIsExisted;
    }

    public void setIdIsExisted(String IdIsExisted) {
        this.IdIsExisted = IdIsExisted;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    
    
}
