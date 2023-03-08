package eu.msdhn.java19features.eu.msdhn.java19features.virtualthread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

public class VirtualThreadDemo {

    public static void main(String... args) throws InterruptedException {
        List<DemoTask> taskList = new ArrayList<>();
        for (int i = 0; i < 1_000; i++) {
            taskList.add(new DemoTask());
        }
        long start = System.currentTimeMillis();
        var executorService = Executors.newVirtualThreadPerTaskExecutor();
        //var executorService = Executors.newFixedThreadPool(100);
        executorService.invokeAll(taskList);
        long end = System.currentTimeMillis();
        executorService.shutdown();
        System.out.println("time taken " + (end - start) + " millis");
    }

    static class DemoTask implements Callable<String> {
        @Override
        public String call() {
            try {
                //lets say doing some io here
                Thread.sleep(1000);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            return "something...";
        }
    }

}
