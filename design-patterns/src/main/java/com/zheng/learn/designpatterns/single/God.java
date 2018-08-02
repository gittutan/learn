package com.zheng.learn.designpatterns.single;

/**
 * Created by zheng on 2018/8/2.
 * 单例模式 - 懒汉式
 */
public class God {
    private static volatile God INSTANCE;

    private God() {
    }

    /**
     * 直接加锁 1.0
     */
    public static synchronized God getInstance() {
        if (null == INSTANCE) {
            INSTANCE = new God();
        }
        return INSTANCE;
    }

    /**
     * 内部加锁优化 1.1
     */
    public static God newInstance() {
        if (null == INSTANCE) {
            synchronized (God.class) {
                if (null == INSTANCE) {
                    INSTANCE = new God();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * 使用局部变量优化 2.0
     */
    public static God instance() {
        God instance = INSTANCE;
        if (null == instance) {
            synchronized (God.class) {
                instance = INSTANCE;
                if (null == instance) {
                    instance = INSTANCE = new God();
                }
            }
        }
        return instance;
    }


}
