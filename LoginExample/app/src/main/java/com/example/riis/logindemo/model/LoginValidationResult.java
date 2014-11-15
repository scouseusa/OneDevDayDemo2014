package com.example.riis.logindemo.model;

import com.google.inject.Singleton;

/**
 * Created by scouseusa on 11/13/14.
 */
@Singleton
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
