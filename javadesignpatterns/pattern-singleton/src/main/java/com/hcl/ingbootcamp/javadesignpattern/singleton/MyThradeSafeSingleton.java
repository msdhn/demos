package com.hcl.ingbootcamp.javadesignpattern.singleton;

/**
 * @author masud
 */
public class MyThradeSafeSingleton {

    private static MyThradeSafeSingleton instance;
    ;

    private MyThradeSafeSingleton() {
    }

    /**
     * @return
     */
    public static synchronized MyThradeSafeSingleton getInstance() {
        if (instance == null) {
            instance = new MyThradeSafeSingleton();
        }
        return instance;
    }

    public static MyThradeSafeSingleton getInstanceUsingDoubleLocking() {
        if (instance == null) {
            synchronized (MyThradeSafeSingleton.class) {
                if (instance == null) {
                    instance = new MyThradeSafeSingleton();
                }
            }
        }
        return instance;
    }

}
