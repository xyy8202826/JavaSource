package com.xyy.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * </p>
 * User: xuyuanye Date: 2016/9/5 Project: JavaSource
 */
public class InterruptDemo {

    /**
     * 当一个阻塞方法检测到中断并抛出 InterruptedException 时，它会清除中断状态。
     *
     */
    public static void main(String ... args){
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName()+
                            Thread.currentThread().isInterrupted());
                    TimeUnit.SECONDS.sleep(20);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName()+
                            Thread.currentThread().isInterrupted());
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();
    }
}
