package online.msdhn.javadesignpattern.singleton;

/**
 * @author masud
 */
public class MyInnerCalssSingleton {

    private MyInnerCalssSingleton() {
    }

    private static class MyInner {
        private static final MyInnerCalssSingleton INSTANCE = new MyInnerCalssSingleton();

        private MyInner() {
        }
    }

    public static MyInnerCalssSingleton getInstance() {
        return MyInner.INSTANCE;
    }
}
