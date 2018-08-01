package com.tingyun.service.httpURLConnection;


import java.util.Map;

public interface HttpURLConnectionService {

    public static final String GET = "GET";
    public static final String POST = "POST";

    public Map HttpURLGETConnection(String urlString);
    public Map HttpURLPOSTConnection(String urlString);

}
