package com.example.practice_coursework.m_RSS;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;


import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

public class Downloader extends AsyncTask<Void,Void,Object> {


    Context c;
    String urlString;
    ListView lv;


    ProgressDialog pd;

    public Downloader(Context c, String urlString, ListView lv) {
        this.c = c;
        this.urlString = urlString;
        this.lv = lv;
    }

    @Override
    protected void onPreExecute(){
        super.onPreExecute();
        pd= new ProgressDialog(c);
        pd.setTitle("Fetching Roadworks");
        pd.setMessage("Roadworks Data Loading...");
        pd.show();
    }
    @Override
    protected Object doInBackground(Void... params){
        return this.downloadData();

    }
    @Override
    protected void onPostExecute(Object data){
        super.onPostExecute(data);
        pd.dismiss();

        if(data.toString().startsWith("Error"))
        {
            Toast.makeText(c, data.toString(), Toast.LENGTH_SHORT).show();
        }else{
            //parse
            new RSSParser(c,(InputStream) data,lv).execute();
        }

    }
    private Object downloadData(){

        Object connection = Connector.connect(urlString);
        if(connection.toString().startsWith("Error")){
            return connection.toString();
        }
        try{
            HttpURLConnection con = (HttpURLConnection) connection;
            int responseCode = con.getResponseCode();
            if (responseCode==con.HTTP_OK){
                InputStream is = new BufferedInputStream(con.getInputStream());
                return is;
            }
            return ErrorTracker.RESPONSE_ERROR+con.getResponseMessage();
        } catch(IOException e){
            e.printStackTrace();
            return ErrorTracker.IO_ERROR;

        }
    }



}
