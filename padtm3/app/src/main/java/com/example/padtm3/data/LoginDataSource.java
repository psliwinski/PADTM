package com.example.padtm3.data;

import android.widget.Toast;

import com.example.padtm3.FirstFragment;
import com.example.padtm3.data.model.LoggedInUser;
import com.example.padtm3.ui.login.LoginActivity;

import java.io.IOException;
import java.util.logging.Handler;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result<LoggedInUser> login(String username, String password) {

       /* runOnUiThread(new Runnable() {
            public void run()
            {
                Toast.makeText(getApplicationContext(), "Toast teaxt", Toast.LENGTH_SHORT).show();
            }
        });
        */


        try {

            // TODO: handle loggedInUser authentication
            if (username.equals("jannowak") && password.equals("123123")) {
                LoggedInUser fakeUser =
                        new LoggedInUser(
                                java.util.UUID.randomUUID().toString(),
                                "Jan Nowak");
                return new Result.Success<>(fakeUser);
            } else {
                LoggedInUser fakeUser =
                        new LoggedInUser(
                                java.util.UUID.randomUUID().toString(),
                                username.toLowerCase());
                return new Result.Success<>(fakeUser);
            }
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}