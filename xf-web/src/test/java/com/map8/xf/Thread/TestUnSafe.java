package com.map8.xf.Thread;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @description:
 * @author:zhangfei
 * @createTime:2020/9/2/002 20:37
 * @version:1.0
 */
public class TestUnSafe {
    //获取unsafe的实例
    //static final Unsafe unsafe = Unsafe.getUnsafe();
    static final Unsafe unsafe;
    //记录变量state在类TestUnsafe的偏移量
    static final  long stateOffset;
    private volatile long state = 0;
    static {
        try {
            //stateOffset = unsafe.objectFieldOffset(TestUnSafe.class.getDeclaredField("state"));
            //使用反射解决不能实例化unsafe
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            //设置可存取
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
            stateOffset = unsafe.objectFieldOffset(TestUnSafe.class.getDeclaredField("state"));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }
    }

    public static void main(String[] args) {
        TestUnSafe testUnSafe = new TestUnSafe();
        Boolean sucess = unsafe.compareAndSwapInt(testUnSafe,stateOffset,0,1);
        System.out.println(sucess);
    }
}
