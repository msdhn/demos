package com.hcl.ingbootcamp.javadesignpattern.singleton;

/**
 * the instance of Singleton Class is created at the time of class loading, this
 * is the easiest method to create a singleton class but it has a drawback that
 * instance is created even though client application might not be using it.
 *
 * @author masud
 */
public class MyEagerSingleton {

    private static final MyEagerSingleton SIGNLTON = new MyEagerSingleton();

    /**
     * @return the singleton
     */
    public static MyEagerSingleton getSignlton() {
        return SIGNLTON;
    }

    private MyEagerSingleton() {
    }
}
