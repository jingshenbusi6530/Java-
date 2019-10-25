package com.bhg.platform.demo;

/**
 * Created by zmk on 2019/10/25.
 */
public class ZiLongContext {
    //锦囊妙计接口
    private BrocadeStrategy brocadeStrategy;

    public ZiLongContext(BrocadeStrategy brocadeStrategy) {
        this.brocadeStrategy = brocadeStrategy;
    }
    public void execute() {
        brocadeStrategy.execute();
    }

    public static  void main(String[] args){

        System.out.println("子龙携带三个妙计到了南徐，打开第一个锦囊！");
        ZiLongContext context;
        context = new ZiLongContext(new FirstBrocadeConcreteStrategy());
        context.execute();

        System.out.println("皇叔和孙夫人婚后，皇叔沉醉于新婚甜蜜生活，乐不思蜀，子龙打开第二个锦囊！");
        context = new ZiLongContext(new SecondBrocadeConcreteStrategy());
        context.execute();

        System.out.println("公瑾知道皇叔逃跑之后，立马围追堵截，子龙打开第三个锦囊！");
        context = new ZiLongContext(new ThirdBrocadeConcreteStrategy());
        context.execute();

        System.out.println("赔了夫人又折兵。既生瑜，何生亮？");
    }
}
