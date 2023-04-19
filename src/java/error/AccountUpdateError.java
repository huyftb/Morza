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
public class AccountUpdateError implements Serializable{
        private String usernameLengthErr;
    private String passwordLengthErr;
    private String fullnameLengthErr;
    private String phoneNumLengthErr;
    private String emailSyntaxErr;
    private String addressLengthErr;
    private String errorMsg;

    public AccountUpdateError() {
    }

    public AccountUpdateError(String usernameLengthErr, String passwordLengthErr, String fullnameLengthErr, String phoneNumLengthErr, String emailSyntaxErr, String addressLengthErr, String errorMsg) {
        this.usernameLengthErr = usernameLengthErr;
        this.passwordLengthErr = passwordLengthErr;
        this.fullnameLengthErr = fullnameLengthErr;
        this.phoneNumLengthErr = phoneNumLengthErr;
        this.emailSyntaxErr = emailSyntaxErr;
        this.addressLengthErr = addressLengthErr;
        this.errorMsg = errorMsg;
    }

    public String getUsernameLengthErr() {
        return usernameLengthErr;
    }

    public void setUsernameLengthErr(String usernameLengthErr) {
        this.usernameLengthErr = usernameLengthErr;
    }

    public String getPasswordLengthErr() {
        return passwordLengthErr;
    }

    public void setPasswordLengthErr(String passwordLengthErr) {
        this.passwordLengthErr = passwordLengthErr;
    }

    public String getFullnameLengthErr() {
        return fullnameLengthErr;
    }

    public void setFullnameLengthErr(String fullnameLengthErr) {
        this.fullnameLengthErr = fullnameLengthErr;
    }

    public String getPhoneNumLengthErr() {
        return phoneNumLengthErr;
    }

    public void setPhoneNumLengthErr(String phoneNumLengthErr) {
        this.phoneNumLengthErr = phoneNumLengthErr;
    }

    public String getEmailSyntaxErr() {
        return emailSyntaxErr;
    }

    public void setEmailSyntaxErr(String emailSyntaxErr) {
        this.emailSyntaxErr = emailSyntaxErr;
    }

    public String getAddressLengthErr() {
        return addressLengthErr;
    }

    public void setAddressLengthErr(String addressLengthErr) {
        this.addressLengthErr = addressLengthErr;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

}