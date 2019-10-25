package com.bhg.platform.demo;

/**
 * Created by zmk on 2019/10/25.
 */
public class SecondBrocadeConcreteStrategy implements BrocadeStrategy {

    @Override
    public void execute() {
        System.out.println("用谎言（曹操打荆州）骗不思蜀的刘备回去！");
    }
}
