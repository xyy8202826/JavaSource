package com.xyy.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 * </p>
 * User: xuyuanye Date: 2016/9/7 Project: JavaSource
 */
public class ReentrantLockTest {

    public static void main(String[] args){
        final ReentrantLock lock = new ReentrantLock();
        final Condition notFull = lock.newCondition();
        final Condition notEmpty = lock.newCondition();
        final List<Bread> basket = new ArrayList(10);

        for(int k=0;k<5;k++){
            new Thread(new Runnable() {
                public void run() {
                    int i=0;
                    while(true){
                        lock.lock();
                        try {
                            while(basket.size()==10){
                                notFull.await();
                            }
                            Bread bread = new Bread(i++);
                            basket.add(bread);
                            System.out.println(Thread.currentThread().getName()+"add:"+bread);
                            notEmpty.signalAll();
                        }catch (InterruptedException e) {
                            e.printStackTrace();
                        }finally {
                            lock.unlock();
                        }
                   try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    }
                }
            }).start();
        }

        for(int k=0;k<5;k++){
            new Thread(new Runnable() {
                public void run() {
                    while(true){
                        lock.lock();
                        try {
                            while(basket.size()==0){
                                notEmpty.await();
                            }
                            Bread bread = basket.remove(0);
                            System.out.println(Thread.currentThread().getName()+"remove:"+bread);
                            notFull.signalAll();
                        }catch (InterruptedException e) {
                            e.printStackTrace();
                        }finally {
                            lock.unlock();
                        }
                    }
                }
            }).start();
        }
    }



    private  static class Bread {
        private int id ;
        public Bread(int id) {
            this.id=id;
        }
        @Override
        public String toString() {
            return "Bread{" +
                    "id=" + id +
                    '}';
        }
    }
}
