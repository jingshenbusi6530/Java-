package com.bhg.platform.demo.proxy.cglib;

/**
 * 真实主题
 * Created by zmk on 2019/11/4.
 * jdk1.8
 */
public class RealLogSubject{

    public void printLog(String apiName) {
        System.out.println("输出当前["+apiName+"]日志信息 time="+System.currentTimeMillis());
    }
}
