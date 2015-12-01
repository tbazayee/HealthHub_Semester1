package com.example.cesar.healthhub;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
    }

    public void SubmitUserNamePassword(View v)
    {
        String userName = "";
        String password = "";

        //---Get data from the View as EditText and typecast to string

        EditText un = (EditText)findViewById(R.id.UserNameTextFieldMC3);
        userName = un.getText().toString();

        EditText ps = (EditText)findViewById(R.id.PasswordTextFieldMC3);
        password = ps.getText().toString();

        // for testing
        String x = userName + password;
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.TOP| Gravity.LEFT,0,0);
        toast.makeText(Activity3.this, x,toast.LENGTH_SHORT).show();


        //---------- Check cloud valid user and password-----------


       ParseUser.logInInBackground(userName, password, new LogInCallback() {
            public void done(ParseUser user, ParseException e) {
                if (user != null)
                {
                    //--------- Saved successfully.
                    Toast.makeText(getApplicationContext(), "successful login", Toast.LENGTH_SHORT).show();            //<== show Save message
                    //Intent intent = new Intent(Activity3.this, SendHeartBeat.class);                     //<== close this window and open main window
                    //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);       //<== clear info from this window
                    //startActivity(intent);                                                                  //<== start new window

                }
                else
                {
                    // The save failed.
                    Toast.makeText(getApplicationContext(), "Failed to Save", Toast.LENGTH_SHORT).show();
                    Log.d(getClass().getSimpleName(), "User update error: " + e);
                }
            }
        });


    }



}
