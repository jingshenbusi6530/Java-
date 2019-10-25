package com.bhg.platform.demo;

/**
 * Created by zmk on 2019/10/25.
 */
public class FirstBrocadeConcreteStrategy implements BrocadeStrategy{

    @Override
    public void execute() {
        System.out.println("见乔国老，把刘备娶亲的事情搞得东吴人尽皆知！");
    }
}
