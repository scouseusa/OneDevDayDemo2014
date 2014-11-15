package com.example.riis.logindemo.model;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;

import com.example.riis.logindemo.LoginActivity;
import com.example.riis.logindemo.R;
import com.example.riis.logindemo.model.task.UserLoginTask;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Created by scouseusa on 11/13/14.
 */
@Singleton
public class LoginModel
{
    @Inject
    LoginValidationResult loginValidationResult;
    @Inject
    UserLoginTask userLoginTask;

    public LoginValidationResult attemptLogin(LoginActivity activity, String email, String password)
    {
        // reset result
        loginValidationResult.setEmailError(null);
        loginValidationResult.setPasswordError(null);
        boolean valid = true;

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password))
        {
            valid = false;
            loginValidationResult.setPasswordError(activity.getString(R.string.error_invalid_password));
        }
        // Check for a valid email address.
        if (TextUtils.isEmpty(email))
        {
            valid = false;
            loginValidationResult.setEmailError(activity.getString(R.string.error_field_required));
        }
        else if (!isEmailValid(email))
        {
            valid = false;
            loginValidationResult.setEmailError(activity.getString(R.string.error_invalid_email));
        }
        if (valid)
        {
            userLoginTask.setCredentials(email, password);
            userLoginTask.setLoginActivityListener(activity);
            userLoginTask.execute();
        }
        return loginValidationResult;
    }

    private boolean isEmailValid(String email)
    {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password)
    {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }


}
