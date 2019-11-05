package com.bhg.platform.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by zmk on 2019/11/4.
 * jdk1.8
 */
public class JdkDynamicProxy implements InvocationHandler{

    private String apiName;
    private LogSubject subject = null;

    public JdkDynamicProxy(String apiName){
        this.apiName = apiName;
        this.subject = new RealLogSubject(apiName);
    }
    /**  
     * @author zmk
     * @param proxy 指被代理的对象
     *        method 被代理的方法,
     *        args 该方法的参数数组
     * @return java.lang.Object
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(this.subject, args);
        after();
        return result;
    }
    public void before(){
        System.out.println("获取接口["+this.apiName+"]参数！");
    }
    public void after(){
        System.out.println("将["+this.apiName+"]日志信息存入到es中！");
    }

    public static void main(String[] args){
        // 保存生成的代理类的字节码文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        JdkDynamicProxy dynamicProxy = new JdkDynamicProxy( "登录接口");
        //生成代理对象
        LogSubject loginLog = (LogSubject)Proxy.newProxyInstance(RealLogSubject.class.getClassLoader(), RealLogSubject.class.getInterfaces(), dynamicProxy);
        loginLog.printLog();
    }
}
