package org.github.service.impl;

import org.github.api.DubboDefaultTestService;
import org.github.api.DubboThriftTestService;

import java.util.Random;
import java.util.UUID;

public class DubboDefaultTestServiceImpl implements DubboDefaultTestService,DubboThriftTestService.Iface {
    @Override
    public int getInt() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new Random().nextInt();
    }

    @Override
    public String getString() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return UUID.randomUUID().toString();
    }

    @Override
    public void setString(String key, String value) {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(key+"||||||"+value);
    }

    @Override
    public String getString(String key) {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return key;
    }

}
