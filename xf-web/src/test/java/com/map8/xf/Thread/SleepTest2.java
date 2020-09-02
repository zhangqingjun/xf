package com.map8.xf.Thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author:zhangfei
 * @createTime:2020/8/9/009 16:04
 * @version:1.0
 */
public class SleepTest2 {

    private static final Lock lock = new ReentrantLock();

    /**
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        //设置一个钩子线程，在jvm退出时输出日志
        Runtime.getRuntime().addShutdownHook(new Thread(()-> System.out.println("The JVM exit success !!!")));
        Thread thread = new Thread(()->{
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("I am running");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        //设置线程为守护线程
        thread.setDaemon(true);
        thread.start();
        TimeUnit.SECONDS.sleep(2);
        System.out.println("The main thread ready to exit ...");
    }

}
