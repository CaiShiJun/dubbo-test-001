package com.tingyun.controller;

import com.tingyun.thrift.client.ThriftClientDemo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/httpClientProvider")
public class HttpClientProviderServiceController {

    @RequestMapping("/returnServiceLink")
    @ResponseBody
    public String returnServiceLink(){
        return ThriftClientDemo.thriftClientRun().msg;
    }

}
