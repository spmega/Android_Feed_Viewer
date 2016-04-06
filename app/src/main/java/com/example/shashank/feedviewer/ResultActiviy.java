package com.example.shashank.feedviewer;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

import java.util.Collection;

/**
 * Created by shashank on 4/6/16.
 */
public class ResultActiviy extends Activity {
    private Context context = null;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity);
        context = getApplicationContext();

        //String urlString = getIntent().getStringExtra("url");
        //HandleXML obj = new HandleXML(urlString, context);
        //obj.fetchXml();
        ItemXmlAdapter adapter = new ItemXmlAdapter();
        ListView listView = (ListView) findViewById(R.id.list_items);
        listView.setAdapter(adapter);
    }

    public void onClickFinish(View view){
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.result_menu_list, menu);
        return true;
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item){
        if(featureId == R.id.finishOption){
            finish();
        }

        return true;
    }
}
