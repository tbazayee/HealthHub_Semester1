package com.example.cesar.healthhub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //--------------------------------
        // Enable Local Datastore.
       /* Parse.enableLocalDatastore(this);
        Parse.initialize(this, "zKenbkiY06h6ovylOZPtG4MMgdofawndODFdfrlX", "z2luzaMHXwMVSa0DMKsxhwzzifhJjkQVHcOb0FvE");
        */
        /*ParseObject testObject = new ParseObject("TestObject");
        testObject.put("healthHub", "bar");
        testObject.saveInBackground();*/
        //-------------------------------
    }



    //---------------------------------
    public void OnSingUPButton(View v)
    {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);

    }

    public void onLongINButton(View v)
    {
        Intent intent = new Intent(this,Activity3.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
