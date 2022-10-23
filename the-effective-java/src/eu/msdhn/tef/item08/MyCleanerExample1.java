package eu.msdhn.tef.item08;

import java.lang.ref.Cleaner;

public class MyCleanerExample1 implements AutoCloseable {

    private final Cleaner cleaner = Cleaner.create();
    private final Cleaner.Cleanable cleanable;
    private final State state;


    public MyCleanerExample1() {
        this.state = new State();
        this.cleanable = cleaner.register(this, this.state);
    }

    public static void main(String... args) throws Exception {
        try (MyCleanerExample1 myCleanerExample = new MyCleanerExample1();) {
            System.out.println();
        }
    }

    @Override
    public void close() throws Exception {
        // trigger the cleaning from here
        this.cleanable.clean();
    }

    private static class State implements Runnable {
        @Override
        public void run() {
            System.out.println("doing the clean up here");
        }
    }

}
