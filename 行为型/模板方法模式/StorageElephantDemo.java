package com.bhg.platform.demo;

/**
 * Created by zmk on 2019/10/25.
 */
public class StorageElephantDemo {
    public static void main(String[] args){
        System.out.println("第一种放大象方式：");
        BigFridgeStorageElephant bigFridgeStorageElephant = new BigFridgeStorageElephant();
        bigFridgeStorageElephant.execute();

        System.out.println("第二种放大象方式：");
        IngeniousStorageElephant ingeniousStorageElephant = new IngeniousStorageElephant();
        ingeniousStorageElephant.execute();
    }
}
