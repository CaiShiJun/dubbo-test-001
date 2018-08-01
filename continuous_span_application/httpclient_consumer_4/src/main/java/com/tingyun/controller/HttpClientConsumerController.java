package com.tingyun.controller;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
@RequestMapping("/httpClientConsumer")
public class HttpClientConsumerController {

    @RequestMapping("/returnServiceLink")
    @ResponseBody
    public String returnServiceLink(){

        String url = "http://localhost:20004/httpClientProvider/returnServiceLink";
        CloseableHttpClient httpCilent = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        String reuslt = null;
       try {
           HttpResponse httpResponse = httpCilent.execute(httpGet);
           reuslt = EntityUtils.toString(httpResponse.getEntity())+"---httpclient_consumer_4";
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                httpCilent.close();//释放资源
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return reuslt;
    }

}
