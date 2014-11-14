package com.example.riis.logindemo.model.task;

import android.os.AsyncTask;

import com.example.riis.logindemo.R;
import com.example.riis.logindemo.model.interfaces.LoginActivityListener;

/**
 * Created by scouseusa on 11/13/14.
 */
public class UserLoginTask extends AsyncTask<Void, Void, Boolean>
{
    LoginActivityListener loginActivityListener;

    /**
     * A dummy authentication store containing known user names and passwords.
     * TODO: remove after connecting to a real authentication system.
     */
    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "foo@example.com:hello", "bar@example.com:world"
    };


    private final String mEmail;
    private final String mPassword;

    public UserLoginTask(String email, String password)
    {
        mEmail = email;
        mPassword = password;
    }

    public void setLoginActivityListener(LoginActivityListener loginActivityListener)
    {
        this.loginActivityListener = loginActivityListener;
    }

    @Override
    protected Boolean doInBackground(Void... params)
    {
        // TODO: attempt authentication against a network service.

        try
        {
            // Simulate network access.
            Thread.sleep(2000);
        } catch (InterruptedException e)
        {
            return false;
        }

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
    protected void onPostExecute(final Boolean success)
    {
        loginActivityListener.processLoginResult(success);
    }

    @Override
    protected void onCancelled()
    {
        loginActivityListener.processLoginResult(false);
    }
}
