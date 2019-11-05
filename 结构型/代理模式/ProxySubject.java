package com.bhg.platform.demo.proxy;

/**
 * 代理类
 * Created by zmk on 2019/11/4.
 * jdk1.8
 */
public class ProxySubject implements LogSubject{
    private String apiName;
    private RealLogSubject subject = null;

    //通过构造函数的形式传递对谁进行代理，隐藏真实角色
    public ProxySubject(String apiName){
        try {
            this.apiName = apiName;
            subject = new RealLogSubject(this,apiName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void before(String apiName){
        System.out.println("获取接口["+apiName+"]参数！");
    }
    @Override
    public void printLog() {
        this.before(this.apiName);
        this.subject.printLog();
        this.after(this.apiName);
    }

    public void after(String apiName){
        System.out.println("将["+apiName+"]日志信息存入到es中！");
    }

    public static void main(String[] args){
        LogSubject loginLog = new ProxySubject( "登录接口");
        loginLog.printLog();
    }
}
