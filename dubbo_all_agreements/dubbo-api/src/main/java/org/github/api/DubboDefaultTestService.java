package org.github.api;

public interface DubboDefaultTestService {

    int getInt();
    String getString();
    void setString(String key,String value);
    String getString(String key);

}
