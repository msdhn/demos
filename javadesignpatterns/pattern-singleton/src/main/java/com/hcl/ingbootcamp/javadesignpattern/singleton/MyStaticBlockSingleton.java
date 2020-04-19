package com.hcl.ingbootcamp.javadesignpattern.singleton;

/**
 * Static block initialization implementation is similar to eager
 * initialization, except that instance of class is created in the static block
 *
 * @author masud
 */
public class MyStaticBlockSingleton {

    private static MyStaticBlockSingleton singlton;

    static {
        try {
            singlton = new MyStaticBlockSingleton();
        } catch (Exception e) {
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
    }

    private MyStaticBlockSingleton() {
    }

    /**
     * @return
     */
    public static MyStaticBlockSingleton getInstance() {
        return singlton;
    }

}
