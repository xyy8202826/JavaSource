package com.xyy.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * </p>
 * User: xuyuanye Date: 2016/9/6 Project: JavaSource
 */
public class ArrayBlockingQueueTest {

    public static  void main(String ... args){
        ArrayBlockingQueue<Bread>  queue = new ArrayBlockingQueue<Bread>(10);
        new Thread(new Producer(queue)).start();
        new Thread(new Consumer(queue)).start();
    }

    private static class Producer implements  Runnable{
        private final ArrayBlockingQueue<Bread>  queue;
        Producer(ArrayBlockingQueue<Bread>  queue){
            this.queue=queue;
        }
        public void run() {
            int i=0;
            while(true){
                Bread bread=new Bread(i++);
                try {
                    TimeUnit.SECONDS.sleep(3);
                    /**
                     * put()方法是如果容器满了的话就会把当前线程挂起
                     * offer()方法是容器如果满的话就会返回false，也正是我在前一篇中实现的那种策略。
                     */
                    System.out.println("Producer:"+bread);
                    queue.put(bread);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class Consumer implements  Runnable{
        private final ArrayBlockingQueue<Bread>  queue;

        Consumer(ArrayBlockingQueue<Bread>  queue){
            this.queue=queue;
        }
        public void run() {
            while(true){
                try {
                    /**
                     * take()方法和put()方法是对应的，从中拿一个数据，如果拿不到线程挂起
                     * poll()方法和offer()方法是对应的，从中拿一个数据，如果没有直接返回null
                     */
                    Bread bread = queue.take();
                    System.out.println("Consumer:"+bread);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
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
