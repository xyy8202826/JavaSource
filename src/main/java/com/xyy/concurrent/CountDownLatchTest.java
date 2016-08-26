package com.xyy.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * </p>
 * User: xuyuanye Date: 2016/8/26 Project: JavaSource
 */
public class CountDownLatchTest {
    public static void main(String ... args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Runnable action = new Runnable(){
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        System.out.println(time(executorService,10,action));
        executorService.shutdown();
    }

    public static long time(ExecutorService executorService,int count,final Runnable action) throws InterruptedException {
        final CountDownLatch ready = new CountDownLatch(count);
        final CountDownLatch start = new CountDownLatch(1);
        final CountDownLatch done = new CountDownLatch(count);
        for(int i=0;i<count;i++){
            executorService.execute(new Runnable(){
                public void run() {
                    ready.countDown();
                    try {
                        System.out.println("start.wait()");
                        start.await();
                        action.run();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        done.countDown();
                    }
                }
            });
        }
        ready.await();
        long startTime=System.nanoTime();
        start.countDown();
        done.await();
        return  System.nanoTime()-startTime;
    }
}
