package eu.msdhn.tef.item08;

import java.lang.ref.Cleaner;

public class MyCleanerExample2 {

    public static void main(String... args) {
        MyCleanerExample2 myObject = new MyCleanerExample2();
        Cleaner cleaner = Cleaner.create();
        cleaner.register(myObject, new Runnable() {
            @Override
            public void run() {
                System.out.println("cleaning up things here");
            }
        });

        /**
         * This for loop is to force JVM to garbage collect myObject initialization.
         **/
        for (int i = 0; i < 100000; i++) {
            try {
                String[] dummyString = new String[1000];
                Thread.sleep(1);
            } catch (InterruptedException interruptedException) {
            }
        }
    }
}
