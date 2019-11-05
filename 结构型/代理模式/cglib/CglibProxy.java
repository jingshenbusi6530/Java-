package com.bhg.platform.demo.proxy.cglib;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by zmk on 2019/11/4.
 * jdk1.8
 */
public class CglibProxy implements MethodInterceptor {
    //CGLIB 的字节码增强器
    private Enhancer enhancer = new Enhancer();
    /**
     * @describe 使用动态代理创建一个代理对象
     * @author zmk
     * @param clazz  class to extend or interface to implement
     * @return java.lang.Object
     */
    public Object getProxy(Class clazz){
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }
    /**  
     * @author zmk
     * @param obj  指被代理的对象,
     *         method  被代理的方法,
     *         args 方法的参数,
     *         methodProxy CGLIB方法代理对象
     * @return java.lang.Object
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        before(args[0].toString());
        //通过代理类调用父类中的方法
        Object result = methodProxy.invokeSuper(obj, args);
        after(args[0].toString());
        return result;
    }
    public void before(String apiName){
        System.out.println("获取接口["+apiName+"]参数！");
    }
    public void after(String apiName){
        System.out.println("将["+apiName+"]日志信息存入到es中！");
    }

    public static void main(String[] args){
        //生成Cglib代理类的输出路径
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "target/cglib");
        CglibProxy cglibProxy = new CglibProxy();
        RealLogSubject loginLog = (RealLogSubject)cglibProxy.getProxy(RealLogSubject.class);
        loginLog.printLog("登录接口");
    }
}
