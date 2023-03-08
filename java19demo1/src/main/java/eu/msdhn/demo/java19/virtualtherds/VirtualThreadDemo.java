package eu.msdhn.demo.java19.virtualtherds;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class VirtualThreadDemo {

    public static void main(String... args) throws InterruptedException {

        List<DemoTask> demoTaskList = new ArrayList<>();
        for (int i = 0; i < 1_000; i++) {
            demoTaskList.add(new DemoTask());
        }

        //var executorService = Executors.newFixedThreadPool(100);

        var executorService = Executors.newVirtualThreadPerTaskExecutor();


        long start = System.currentTimeMillis();
        executorService.invokeAll(demoTaskList);
        long end = System.currentTimeMillis();
        System.out.println("time taken " + (end - start) + " millis");
        executorService.shutdown();
    }


    static class DemoTask implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            System.out.println(String.format("task is started in thread %s", Thread.currentThread().getName()));
            return ThreadLocalRandom.current().nextInt() + ThreadLocalRandom.current().nextInt() + ThreadLocalRandom.current().nextInt();
        }
    }


}
