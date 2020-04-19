package com.hcl.ingbootcamp.javadesignpattern.singleton;

/**
 * @author masud
 */
public class MyLazySingleton {

    private static MyLazySingleton singlton;

    private MyLazySingleton() {

    }

    public static MyLazySingleton getInstance() {
        if (singlton == null) {
            singlton = new MyLazySingleton();
        }
        return singlton;
    }
}
