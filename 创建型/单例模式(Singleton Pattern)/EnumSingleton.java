package com.bhg.platform.demo.singleton;

import java.io.Serializable;

/**
 * Created by zmk on 2019/10/28.
 */
public enum  EnumSingleton implements Serializable {
    INSTANCE;
    public static void main (String args[]){
        for(int i = 0;i < 1000 ;i++){
            new Thread(()->{
                EnumSingleton instance = EnumSingleton.INSTANCE;
                System.out.println(instance.hashCode());
            }).start();
        }
    }
}
