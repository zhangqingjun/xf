package com.map8.xf.Thread;

import lombok.SneakyThrows;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description: 回环屏障
 * @author:zhangfei
 * @createTime:2020/11/21/021 15:59
 * @version:1.0
 */
public class CycleBarrierTest {
    //创建一个cyclicBarrier实例，添加一个所有子线程全部到达屏障后执行的任务
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Runnable() {
        @Override
        public void run() {
            System.out.println(Thread.currentThread()+"task1 merge result");
        }
    });

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
       /* executorService.submit(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                System.out.println(Thread.currentThread()+"task1-1");
                System.out.println(Thread.currentThread()+"enter in cyclicbarrier");
                cyclicBarrier.await();
                System.out.println(Thread.currentThread()+"enter out cyclicbarrier ");
            }
        });
        executorService.submit(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                System.out.println(Thread.currentThread()+"task1-2");
                System.out.println(Thread.currentThread()+"enter in cyclicbarrier");
                cyclicBarrier.await();
                System.out.println(Thread.currentThread()+"enter out cyclicbarrier ");
            }
        });*/

        executorService.submit(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                System.out.println(Thread.currentThread()+"step1");
                cyclicBarrier.await();
                System.out.println(Thread.currentThread()+"step2");
                cyclicBarrier.await();
                System.out.println(Thread.currentThread()+"step3 ");
            }
        });
        executorService.submit(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                System.out.println(Thread.currentThread()+"step1");
                cyclicBarrier.await();
                System.out.println(Thread.currentThread()+"step2");
                cyclicBarrier.await();
                System.out.println(Thread.currentThread()+"step3 ");
            }
        });

        executorService.shutdown();
    }
}
