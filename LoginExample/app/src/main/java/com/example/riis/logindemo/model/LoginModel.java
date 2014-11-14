package com.example.riis.logindemo.model;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;

import com.example.riis.logindemo.LoginActivity;
import com.example.riis.logindemo.R;
import com.example.riis.logindemo.model.task.UserLoginTask;

/**
 * Created by scouseusa on 11/13/14.
 */
public class LoginModel
{

    public LoginValidationResult attemptLogin(LoginActivity activity, String email, String password)
    {
        LoginValidationResult loginValidationResult = new LoginValidationResult();

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password))
        {
            loginValidationResult.setPasswordError(activity.getString(R.string.error_invalid_password));
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email))
        {
            loginValidationResult.setEmailError(activity.getString(R.string.error_field_required));
        }
        else if (!isEmailValid(email))
        {
            loginValidationResult.setEmailError(activity.getString(R.string.error_invalid_email));
        }
        else
        {
            UserLoginTask loginTask = new UserLoginTask(email, password);
            loginTask.setLoginActivityListener(activity);
            loginTask.execute((Void) null);
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
