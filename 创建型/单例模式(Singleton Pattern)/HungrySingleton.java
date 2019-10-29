package com.bhg.platform.demo.singleton;

import java.io.Serializable;

/**
 * Created by zmk on 2019/10/28.
 */
public class HungrySingleton implements Serializable {
    private static final HungrySingleton INSTANCE = new HungrySingleton();

    private HungrySingleton() {
        if (INSTANCE != null) {
            throw new RuntimeException("实例已存在，请调用getInstance方法获取！");
        }
    }

    public static  HungrySingleton getInstance(){
        return INSTANCE;
    }

    private Object readResolve(){
        return INSTANCE;
    }
    public static void main (String args[]){
        for(int i = 0;i < 1000 ;i++){
            new Thread(()->{
                HungrySingleton instance = HungrySingleton.getInstance();
                System.out.println(instance.hashCode());
            }).start();
        }
    }
}
