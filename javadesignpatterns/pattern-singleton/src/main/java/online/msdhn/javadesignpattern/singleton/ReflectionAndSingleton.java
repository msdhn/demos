package online.msdhn.javadesignpattern.singleton;

import java.lang.reflect.Constructor;

public class ReflectionAndSingleton {

    public static void main(String... args) {
        MyEagerSingleton instanceOne = MyEagerSingleton.getSignlton();
        MyEagerSingleton instanceTwo = null;
        try {
            Constructor<?>[] constructors = MyEagerSingleton.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                // Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                instanceTwo = (MyEagerSingleton) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(instanceOne == instanceTwo);
        System.out.println(instanceOne.hashCode());
        System.out.println(instanceTwo.hashCode());
    }
}
