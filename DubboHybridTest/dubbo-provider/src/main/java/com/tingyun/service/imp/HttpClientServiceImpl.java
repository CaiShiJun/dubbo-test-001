package com.tingyun.service.imp;

import com.tingyun.service.httpclient.HttpClientService;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClientServiceImpl implements HttpClientService {

    @Override
    public String httpClientGet(String uri) {
        // 创建默认的httpClient实例
        CloseableHttpClient client = HttpClientBuilder.create().build();

        // 创建 httpget
        HttpGet httpGet = new HttpGet(uri);

        String content = null;
        try {

            //执行请求操作，并拿到结果（同步阻塞）
            CloseableHttpResponse response = client.execute(httpGet);

            //获取结果实体，结果实体为String类型
            content = EntityUtils.toString(response.getEntity());

            //释放链接
            response.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    @Override
    public String httpClientPost(String uri) {
        // 创建默认的httpClient实例
        CloseableHttpClient client = HttpClientBuilder.create().build();

        // 创建 httpPost
        HttpPost httpPost = new HttpPost(uri);

        String content = null;
        try {

            //执行请求操作，并拿到结果（同步阻塞）
            CloseableHttpResponse response = client.execute(httpPost);

            //获取结果实体，结果实体为String类型
            content = EntityUtils.toString(response.getEntity());

            //释放链接
            response.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }



}
