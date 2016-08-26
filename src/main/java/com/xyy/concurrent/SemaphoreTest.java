package com.xyy.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * </p>
 * User: xuyuanye Date: 2016/8/26 Project: JavaSource
 */
public class SemaphoreTest {
    public static void main(String ... args){
        final Semaphore semaphore = new Semaphore(5);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i=0;i<20;i++){
            final int index=i;
            Runnable thread = new Runnable(){
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println("thread "+index);
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        semaphore.release();
                    }
                }
            };
            executorService.execute(thread);
        }
        executorService.shutdown();
    }
}
