package com.example.shashank.feedviewer;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private Button fetchButton = null;
    private EditText rssField = null;
    private Context context = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        context = getApplicationContext();

        //the mail button has been commented
        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        fetchButton = (Button) findViewById(R.id.fetchButton);
        rssField = (EditText) findViewById(R.id.rssField);
    }

    public void onClickFetchButton(){
        Editable data = rssField.getText();
        String urlString = data.toString();
        URL url = null;
        HttpURLConnection conn = null;
        XmlPullParserFactory xmlPullParserFactory = null;
        XmlPullParser xmlPullParser = null;


        if(!checkIfConnected()){
            finish();
        }

        try {
            xmlPullParserFactory = XmlPullParserFactory.newInstance();
            xmlPullParser = xmlPullParserFactory.newPullParser();

            url = new URL(urlString);
            conn = (HttpURLConnection) url.openConnection();
            conn.connect();

            xmlPullParser.setInput(new BufferedReader(new InputStreamReader(conn.getInputStream())));

            Toast.makeText(context, "set up the xmlPullParser", Toast.LENGTH_SHORT);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }

    }

    public boolean checkIfConnected(){
        ConnectivityManager check = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo info = check.getActiveNetworkInfo();
        if(info.getState() == NetworkInfo.State.CONNECTED){
            Toast.makeText(context, "The internet is connected", Toast.LENGTH_SHORT);
            return true;
        }

        Toast.makeText(context, "The internet is not connected", Toast.LENGTH_SHORT);
        return false;
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
