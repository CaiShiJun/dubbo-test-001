package com.tingyun.service.imp;

import com.sun.jndi.toolkit.url.UrlUtil;
import com.tingyun.service.httpURLConnection.HttpURLConnectionService;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class HttpURLConnectionServiceImpl implements HttpURLConnectionService {

    @Override
    public Map HttpURLGETConnection(String urlString){

        Map map = new HashMap();

        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.connect();

            int statusCode = connection.getResponseCode();
            map.put("statusCode",statusCode);
            String responseMessage = connection.getResponseMessage();
            map.put("responseMessage",responseMessage);

        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public Map HttpURLPOSTConnection(String urlString){
        Map map = new HashMap();

        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.connect();

            int statusCode = connection.getResponseCode();
            map.put("statusCode",statusCode);
            String responseMessage = connection.getResponseMessage();
            map.put("responseMessage",responseMessage);

        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}
