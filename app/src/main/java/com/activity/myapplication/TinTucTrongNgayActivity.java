package com.activity.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class TinTucTrongNgayActivity extends AppCompatActivity {

    ListView lvRss ;
    ArrayList<String> titles ;
    ArrayList<String> links ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tin_tuc_trong_ngay);

        lvRss = findViewById(R.id.lv) ;
        titles = new ArrayList<>() ;
        links = new ArrayList<>() ;

        lvRss.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Uri uri = Uri.parse(links.get(position)) ;
                Intent intent = new Intent(Intent.ACTION_VIEW, uri) ;
                startActivity(intent);
            }
        });
        new ProcessInBackgroud().execute() ;
    }
    public InputStream getInputStream(URL url){
        try {
            return url.openConnection().getInputStream() ;
        }
        catch (IOException e){
            return null ;
        }
    }

    public class ProcessInBackgroud extends AsyncTask<Integer, Void, Exception> {
        ProgressDialog progressDialog = new ProgressDialog(TinTucTrongNgayActivity.this) ;
        Exception exception = null ;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog.setMessage("loading...");
            progressDialog.show();

        }

        @Override
        protected Exception doInBackground(Integer... parans) {

            try {
                URL url = new URL("https://24h.com.vn/upload/rss/bongda.rss") ;
                XmlPullParserFactory factory = XmlPullParserFactory.newInstance() ;
                factory.setNamespaceAware(false);
                XmlPullParser xpp = factory.newPullParser() ;
                xpp.setInput(getInputStream(url), "UTF_8");
                boolean insideItem = false ;

                int eventType = xpp.getEventType() ;
                while (eventType != XmlPullParser.END_DOCUMENT){
                    if (eventType == XmlPullParser.START_TAG){
                        if (xpp.getName().equalsIgnoreCase("item")) {
                            insideItem = true ;
                        }else if (xpp.getName().equalsIgnoreCase("title")){
                            if (insideItem){
                                titles.add(xpp.nextText());
                            }
                        }else  if (xpp.getName().equalsIgnoreCase("link")){
                            if (insideItem){
                                links.add(xpp.nextText()) ;
                            }
                        }
                    }else  if (eventType == XmlPullParser.END_TAG && xpp.getName().equalsIgnoreCase("item")){
                        insideItem = false ;
                    }
                    eventType = xpp.next() ;
                }

            }catch (MalformedURLException e){
                exception = e ;
            }catch (XmlPullParserException e ){
                exception = e ;
            }catch (IOException e){
                exception = e ;
            }

            return exception;
        }

        @Override
        protected void onPostExecute(Exception s) {
            super.onPostExecute(s);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(TinTucTrongNgayActivity.this, android.R.layout.simple_list_item_1, titles) ;
            lvRss.setAdapter(adapter);

            progressDialog.dismiss();
        }
    }
    }

