package com.zheng.learn.designpatterns.single;

/**
 * Created by zheng on 2018/8/2.
 */
public class Main {
    public static void main(String[] args) {
        // 单例模式 - 懒汉式
        // 懒汉式：当需要时实例化；
        // 直接锁
        God godOne = God.getInstance();
        God godTow = God.getInstance();
        System.out.println(godOne == godTow);

        // 内部锁
        God godFirst = God.newInstance();
        God godLast = God.newInstance();
        System.out.println(godFirst == godLast);

        // 局部变量优化内部锁
        God godBefore = God.instance();
        God godAfter = God.instance();
        System.out.println(godBefore == godAfter);

        /**
         * run print
         * true
         * true
         * true
         */
    }
}
