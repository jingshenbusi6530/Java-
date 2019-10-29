package com.bhg.platform.demo.singleton;

import java.io.Serializable;

/**
 * Created by zmk on 2019/10/28.
 */
public class DoubleCheckSingleton implements Serializable {
    private static volatile DoubleCheckSingleton INSTANCE = null;

    private DoubleCheckSingleton(){
        if (INSTANCE != null) {
            throw new RuntimeException("实例已存在，请调用getInstance方法获取！");
        }
    }
    public static  DoubleCheckSingleton getInstance(){
        if(INSTANCE == null){
            synchronized (DoubleCheckSingleton.class){
                if(INSTANCE == null){
                    INSTANCE = new DoubleCheckSingleton();
                }
            }
        }
        return INSTANCE;
    }

    private Object readResolve(){
        return INSTANCE;
    }
    public static void main (String args[]){
        for(int i = 0;i < 1000 ;i++){
            new Thread(()->{
                DoubleCheckSingleton instance = DoubleCheckSingleton.getInstance();
                System.out.println(instance.hashCode());
            }).start();
        }
    }
}
