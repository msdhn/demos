package eu.msdhn.completatblefuturedemo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Demo3 {

    public static void main(String... args) throws ExecutionException, InterruptedException {

        CompletableFuture<Double> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("i am generating a random number in thread : " + Thread.currentThread());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            return Math.random();
        });
        Double randomNumber = completableFuture.get();
        System.out.println(randomNumber);
    }

}
