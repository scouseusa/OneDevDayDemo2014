package com.example.riis.logindemo.model;

/**
 * Created by scouseusa on 11/13/14.
 */
public class LoginValidationResult
{
    String emailError;
    String passwordError;

    public String getEmailError()
    {
        return emailError;
    }

    public void setEmailError(String emailError)
    {
        this.emailError = emailError;
    }

    public String getPasswordError()
    {
        return passwordError;
    }

    public void setPasswordError(String passwordError)
    {
        this.passwordError = passwordError;
    }
}
