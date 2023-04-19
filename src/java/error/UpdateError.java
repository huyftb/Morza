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
public class UpdateError implements Serializable{
    private String errorMsg;

    public UpdateError() {
    }

    public UpdateError(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
    
    
}

