package com.xyy.concurrent;

/**
 * <p>
 * </p>
 * User: xuyuanye Date: 2016/8/30 Project: JavaSource
 */
public class ThreadLocalTest {

    public static  void main(String ... args){
       final  ThreadLocalDemo localInteger = new  ThreadLocalDemo();
        for(int i=0;i<3;i++){
            final int index = i;
            new Thread(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread()+"before:"+localInteger.get());
                    localInteger.set(index);
                    System.out.println(Thread.currentThread()+"after:"+localInteger.get());
                }
            }).start();
        }

    }
}
