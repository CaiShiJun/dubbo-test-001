package org.github.callback;

/**
 * Created by tingyun on 2017/12/15.
 */
public interface CallbackService {
    void addListener(String key, CallbackListener listener);
}
