package com.xyy.concurrent;

/**
 * <p>
 * </p>
 * User: xuyuanye Date: 2016/8/30 Project: JavaSource
 */
public class ThreadLocalDemo extends  ThreadLocal<Integer> {

    @Override
    protected Integer initialValue() {
        return 0;
    }
}
