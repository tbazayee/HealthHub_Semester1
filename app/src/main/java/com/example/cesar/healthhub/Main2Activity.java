package com.example.cesar.healthhub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "zKenbkiY06h6ovylOZPtG4MMgdofawndODFdfrlX", "z2luzaMHXwMVSa0DMKsxhwzzifhJjkQVHcOb0FvE");

        setContentView(R.layout.activity_main2);
    }

    public void onSubmitButton (View v)
    {
        String userName = "";
        String name = "";
        String password = "";
        String email = "";
        String DrName= "";


        /***************************************************
        Get data from the View as EditText and typecast to string
         ***************************************************/
        EditText n = (EditText )findViewById(R.id.NameTextFiled);
        name = n.getText().toString();

        EditText pw = (EditText)findViewById(R.id.PasswordTextFiled);
        password = pw.getText().toString();

        EditText em = (EditText)findViewById(R.id.EmailTextField);
        email = em.getText().toString();
        EditText un = (EditText)findViewById(R.id.UserNameTextFieldMC3);
        userName = un.getText().toString();


        EditText dr = (EditText)findViewById(R.id.DrNameTextField);
        DrName = dr.getText().toString();

        String x = userName + name + password + email + DrName;

        // for testing
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.TOP| Gravity.LEFT,0,0);
        toast.makeText(Main2Activity.this, x,toast.LENGTH_SHORT).show();


        //================= Add user to the database =======
        ParseUser user = new ParseUser();
        user.setUsername(userName);
        user.setPassword(password);
        user.setEmail(email);
        user.put("Name", name);
        user.put("DrName",DrName);

        //---------- Call the Parse signup method
        user.signUpInBackground(new SignUpCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    //--------- Saved successfully.

                    Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_SHORT).show();            //<== show Save message
                    Intent intent = new Intent(Main2Activity.this, MainActivity.class);                     //<== close this window and open main window
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);       //<== clear info from this window
                    startActivity(intent);                                                                  //<== start new window
                } else {
                    // The save failed.
                    Toast.makeText(getApplicationContext(), "Failed to Save", Toast.LENGTH_SHORT).show();
                    Log.d(getClass().getSimpleName(), "User update error: " + e);
                }
            }
        });


    }
}
