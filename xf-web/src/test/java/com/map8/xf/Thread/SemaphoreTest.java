package com.map8.xf.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @description:信号量
 * @author:zhangfei
 * @createTime:2020/11/21/021 16:34
 * @version:1.0
 */
public class SemaphoreTest {
    //非公平锁
   // private static Semaphore semaphore = new Semaphore(0);
    //公平
    private static Semaphore semaphore = new Semaphore(0,true);


    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread()+"over");
                semaphore.release();
            }
        });
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread()+"over");
                semaphore.release();
            }
        });
        semaphore.acquire(2);
        System.out.println("all child thread over");
        executorService.shutdown();
    }
}
