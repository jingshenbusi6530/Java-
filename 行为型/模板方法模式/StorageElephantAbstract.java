package com.bhg.platform.demo;

/**
 * Created by zmk on 2019/10/25.
 */
public abstract class StorageElephantAbstract {
    /**  
     * @describe 模板方法
     * @author zmk
     * @date 2019/10/25 14:52
     * @param []
     * @return void
     */
    
    protected final void open(){
        System.out.println("把冰箱门打开！");
    }
    /**  
     * @describe 具体解决办法
     * @author zmk
     * @date 2019/10/25 14:36
     * @param []
     * @return void
     */
    protected abstract void storageSolution();

    /**
     * @describe 模板方法
     * @author zmk
     * @date 2019/10/25 14:52
     * @param []
     * @return void
     */
    protected final void close(){
        System.out.println("把冰箱门关上！");
    }
    /**
     * @describe 模板方法
     * @author zmk
     * @date 2019/10/25 14:52
     * @param []
     * @return void
     */
    protected final void execute(){
        this.open();
        this.storageSolution();
        this.close();
    }
}
