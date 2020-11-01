package com.map8.xf.currenqueue;

import lombok.Data;

import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @description:
 * @author:zhangfei
 * @createTime:2020/11/1/001 15:39
 * @version:1.0
 */
public class TestPriorityBlockingQueue {
    @Data
    static class Task implements Comparable<Task>{
        private int priority = 0;
        private String taskName;

        @Override
        public int compareTo(Task o) {
            if(this.priority >= o.getPriority()){
                return 1;
            }
            return -1;
        }
        public void doSomeThing(){
            System.out.println(taskName+":"+priority);
        }
    }

    public static void main(String[] args) {
        PriorityBlockingQueue<Task> priorityBlockingQueue = new PriorityBlockingQueue<>();
        Random random = new Random();
        for (int i = 0; i < 10; ++i) {
            Task task = new Task();
            task.setPriority(random.nextInt(10));
            task.setTaskName("taskName" + i);
            priorityBlockingQueue.offer(task);
        }
        while (!priorityBlockingQueue.isEmpty()) {
            Task task = priorityBlockingQueue.poll();
            if (null != task) {
                task.doSomeThing();
            }
        }
    }
}
