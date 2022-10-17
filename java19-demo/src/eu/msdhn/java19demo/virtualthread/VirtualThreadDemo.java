package eu.msdhn.java19demo.virtualthread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class VirtualThreadDemo {
    public static void main(String... args) throws InterruptedException {
        List<DemoTask> taskList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            taskList.add(new DemoTask());
        }
        long start = System.currentTimeMillis();
        var exe = Executors.newVirtualThreadPerTaskExecutor();
        //var exe = Executors.newFixedThreadPool(1000);
        exe.invokeAll(taskList);
        long end = System.currentTimeMillis();
        System.out.println("time taken = " + (end - start) + " millis");
        exe.shutdown();
    }

    static class DemoTask implements Callable<String> {

        /**
         * Computes a result, or throws an exception if unable to do so.
         *
         * @return computed result
         * @throws Exception if unable to compute a result
         */
        @Override
        public String call() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            return "";
        }
    }
}
