package com.bhg.platform.demo.singleton;

import java.io.Serializable;

/**
 * Created by zmk on 2019/10/28.
 */
public class StaticInterSingleton implements Serializable {
    private static class SingletonHolder {
        private static final StaticInterSingleton INSTANCE = new StaticInterSingleton();
    }
    private StaticInterSingleton (){
        if (SingletonHolder.INSTANCE != null) {
            throw new RuntimeException("实例已存在，请调用getInstance方法获取！");
        }
    }
    public static final StaticInterSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private Object readResolve(){
        return SingletonHolder.INSTANCE;
    }
    public static void main (String args[]){
        for(int i = 0;i < 1000 ;i++){
            new Thread(()->{
                StaticInterSingleton instance = StaticInterSingleton.getInstance();
                System.out.println(instance.hashCode());
            }).start();
        }
    }
}
