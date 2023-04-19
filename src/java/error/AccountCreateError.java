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
public class AccountCreateError implements Serializable{
    private String usernameLengthErr;
    private String passwordLengthErr;
    private String fullnameLengthErr;
    private String confirmNotMatchErr;
    private String usernameExisted;
    private String phoneNumLengthErr;
    private String emailSyntaxErr;
    private String addressLengthErr;
    private String errorMsg;

    /**
     * @return the usernameLengthErr
     */
    public String getUsernameLengthErr() {
        return usernameLengthErr;
    }

    /**
     * @param usernameLengthErr the usernameLengthErr to set
     */
    public void setUsernameLengthErr(String usernameLengthErr) {
        this.usernameLengthErr = usernameLengthErr;
    }

    /**
     * @return the passwordLengthErr
     */
    public String getPasswordLengthErr() {
        return passwordLengthErr;
    }

    /**
     * @param passwordLengthErr the passwordLengthErr to set
     */
    public void setPasswordLengthErr(String passwordLengthErr) {
        this.passwordLengthErr = passwordLengthErr;
    }

    /**
     * @return the fullnameLengthErr
     */
    public String getFullnameLengthErr() {
        return fullnameLengthErr;
    }

    /**
     * @param fullnameLengthErr the fullnameLengthErr to set
     */
    public void setFullnameLengthErr(String fullnameLengthErr) {
        this.fullnameLengthErr = fullnameLengthErr;
    }

    /**
     * @return the confirmNotMatchErr
     */
    public String getConfirmNotMatchErr() {
        return confirmNotMatchErr;
    }

    /**
     * @param confirmNotMatchErr the confirmNotMatchErr to set
     */
    public void setConfirmNotMatchErr(String confirmNotMatchErr) {
        this.confirmNotMatchErr = confirmNotMatchErr;
    }

    /**
     * @return the usernameExisted
     */
    public String getUsernameExisted() {
        return usernameExisted;
    }

    /**
     * @param usernameExisted the usernameExisted to set
     */
    public void setUsernameExisted(String usernameExisted) {
        this.usernameExisted = usernameExisted;
    }

    /**
     * @return the phoneNumLengthErr
     */
    public String getPhoneNumLengthErr() {
        return phoneNumLengthErr;
    }

    /**
     * @param phoneNumLengthErr the phoneNumLengthErr to set
     */
    public void setPhoneNumLengthErr(String phoneNumLengthErr) {
        this.phoneNumLengthErr = phoneNumLengthErr;
    }

    /**
     * @return the emailSyntaxErr
     */
    public String getEmailSyntaxErr() {
        return emailSyntaxErr;
    }

    /**
     * @param emailSyntaxErr the emailSyntaxErr to set
     */
    public void setEmailSyntaxErr(String emailSyntaxErr) {
        this.emailSyntaxErr = emailSyntaxErr;
    }

    /**
     * @return the addressLengthErr
     */
    public String getAddressLengthErr() {
        return addressLengthErr;
    }

    /**
     * @param addressLengthErr the addressLengthErr to set
     */
    public void setAddressLengthErr(String addressLengthErr) {
        this.addressLengthErr = addressLengthErr;
    }

    /**
     * @return the errorMsg
     */
    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * @param errorMsg the errorMsg to set
     */
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
    
    
    
}
