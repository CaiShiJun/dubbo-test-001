package com.tingyun.dubbo.service.impl;

import com.tingyun.dubbo.service.DubboProviderService;

public class DubboProviderServiceImpl implements DubboProviderService {
    @Override
    public String dubboProviderReturnStrMethod(String str) {
        return "dubbop_provider_0---"+str;
    }
}
