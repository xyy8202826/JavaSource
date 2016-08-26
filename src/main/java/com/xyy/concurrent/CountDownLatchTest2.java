package com.xyy.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * <p>
 * </p>
 * User: xuyuanye Date: 2016/8/26 Project: JavaSource
 */
public class CountDownLatchTest2 {
    public static void main(String[] args) {
        int count=3;
        final CountDownLatch latch = new CountDownLatch(count);
        for(int i=0;i<count;i++){
            new Thread(){
                public void run() {
                    try {
                        System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                        Thread.sleep(3000);
                        System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
                        latch.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                };
            }.start();
        }
        try {
            System.out.println("等待"+count+"个子线程执行完毕...");
            latch.await();
            System.out.println(count+"个子线程已经执行完毕");
            System.out.println("继续执行主线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
