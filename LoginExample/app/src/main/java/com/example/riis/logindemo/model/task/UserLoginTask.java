package com.example.riis.logindemo.model.task;

import android.content.Context;
import android.os.AsyncTask;

import com.example.riis.logindemo.R;
import com.example.riis.logindemo.model.interfaces.LoginActivityListener;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import roboguice.util.RoboAsyncTask;

/**
 * Created by scouseusa on 11/13/14.
 */
public class UserLoginTask extends RoboAsyncTask<Boolean>
{
    LoginActivityListener loginActivityListener;

    /**
     * A dummy authentication store containing known user names and passwords.
     * TODO: remove after connecting to a real authentication system.
     */
    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "foo@example.com:hello", "bar@example.com:world"
    };


    private String mEmail;
    private String mPassword;

    @Inject
    public UserLoginTask(Context context)
    {
        super(context);
    }

    public void setCredentials(String email, String password)
    {
        mEmail = email;
        mPassword = password;
    }

    public void setLoginActivityListener(LoginActivityListener loginActivityListener)
    {
        this.loginActivityListener = loginActivityListener;
    }

    @Override
    public Boolean call() throws InterruptedException
    {
        // TODO: attempt authentication against a network service.
        Thread.sleep(2000);

        for (String credential : DUMMY_CREDENTIALS)
        {
            String[] pieces = credential.split(":");
            if (pieces[0].equals(mEmail))
            {
                // Account exists, return true if the password matches.
                return pieces[1].equals(mPassword);
            }
        }

        // TODO: register the new account here.
        return false;
    }

    @Override
    protected void onSuccess(final Boolean success)
    {
        loginActivityListener.processLoginResult(success);
    }

    @Override
    protected void onException(Exception e)
    {
        loginActivityListener.processLoginResult(false);
    }
}
