package com.example.practice_coursework.m_RSS;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Connector {

    public static Object connect(String urlString) {

        try {
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            //Set properties
            con.setRequestMethod("GET");
            //con.setConnectTimeout(15000);
            //con.setReadTimeout(15000);
            con.setDoInput(true);

            return con;

        } catch (MalformedURLException e) {
            e.printStackTrace();
            return ErrorTracker.WRONG_URL_FORMAT;
        } catch(IOException e){
            e.printStackTrace();
            return ErrorTracker.CONNECTION_ERROR;
    }

    }
}
