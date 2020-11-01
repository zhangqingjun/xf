package com.map8.xf.currenqueue;

import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author:zhangfei
 * @createTime:2020/11/1/001 16:01
 * @version:1.0
 */
public class TestDelay {
    static class DelayedELe implements Delayed{
        /**
         * 延迟时间
         */
        private final long delayTime;
        /**
         * 到期时间
         */
        private final long expire;
        /**
         * 任务名称
         */
        private String taskName;
        public DelayedELe(long delay, String taskName){
            delayTime = delay;
            this.taskName = taskName;
            this.expire = System.currentTimeMillis()+delay;
        }

        /** 剩余时间 = 到期时间-当前时间
         * @param unit
         * @return
         */
        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(this.expire - System.currentTimeMillis(),TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            return (int)(this.getDelay(TimeUnit.MILLISECONDS)-o.getDelay(TimeUnit.MILLISECONDS));
        }

        @Override
        public String toString() {
            final  StringBuilder sb = new StringBuilder("DelayedEle{");
            sb.append("delay = ").append(delayTime);
            sb.append(",expire = ").append(expire);
            sb.append(",taskName ='").append(taskName).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        DelayQueue<DelayedELe> delayedELes = new DelayQueue<>();
        Random random = new Random();
        for(int i=0;i<10;++i){
            DelayedELe eLe = new DelayedELe(random.nextInt(500),"task:"+i);
            delayedELes.offer(eLe);
        }
        DelayedELe eLe = null;
        try {
            for(;;){
                while ((eLe =delayedELes.take())!=null){
                    System.out.println(eLe.toString());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
