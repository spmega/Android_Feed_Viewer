package com.example.shashank.feedviewer;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;

import org.w3c.dom.Text;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by shashank on 4/5/16.
 */
public class HandleXML {
    private String urlString = null;
    private ArrayList<ItemXml> listItems = null;
    private ItemXml itemXml = new ItemXml();
    private Context context = null;

    public HandleXML(String urlString, Context context){
        this.urlString = urlString;
        this.context = context;
    }

    public ArrayList<ItemXml> getListItems(){
        return listItems;
    }

    public void parseXml(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String startTag = null;
        String text = null;
        int event = xmlPullParser.getEventType();
        while (event != XmlPullParser.END_DOCUMENT){
            switch (event){
                case XmlPullParser.START_TAG:

                    break;
                case XmlPullParser.TEXT:
                    text = xmlPullParser.getText();
                    break;
                case XmlPullParser.END_TAG:
                    if(xmlPullParser.getName().equalsIgnoreCase("link"))
                        itemXml.setLink(text);
                    else if(xmlPullParser.getName().equalsIgnoreCase("title"))
                        itemXml.setName(text);
                    else if(xmlPullParser.getName().equalsIgnoreCase("description"))
                        itemXml.setDescription(text);
                    break;
            }
            event = xmlPullParser.next();
            listItems.add(itemXml);
            itemXml = new ItemXml();
        }
    }

    public void fetchXml(){
        URL url = null;
        HttpURLConnection conn = null;
        XmlPullParserFactory xmlPullParserFactory = null;
        XmlPullParser xmlPullParser = null;

        try {
            xmlPullParserFactory = XmlPullParserFactory.newInstance();
            xmlPullParser = xmlPullParserFactory.newPullParser();

            url = new URL(urlString);
            conn = (HttpURLConnection) url.openConnection();
            conn.connect();

            xmlPullParser.setInput(new BufferedReader(new InputStreamReader(conn.getInputStream())));

            ProgressDialog dialog = ProgressDialog.show(
                    context,
                    "Loading",
                    "Parsing the xml"
            );
            parseXml(xmlPullParser);
            dialog.dismiss();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }

    }
}
