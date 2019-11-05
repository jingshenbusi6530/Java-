package com.bhg.platform.demo.proxy;

/**
 * 真实主题
 * Created by zmk on 2019/11/4.
 * jdk1.8
 */
public class RealLogSubject implements LogSubject{
    //接口名称
    private String apiName;
    public RealLogSubject(LogSubject subject,String _apiName) throws Exception{
        if(subject == null ){
            throw new RuntimeException("不能没有代理！");
        }else{
            this.apiName = _apiName;
        }
    }

    public RealLogSubject(String apiName) {
        this.apiName = apiName;
    }

    @Override
    public void printLog() {
        System.out.println("输出当前["+this.apiName+"]日志信息 time="+System.currentTimeMillis());
    }
}
