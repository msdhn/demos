package eu.msdhn.completatblefuturedemo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Demo2 {

    public static void main(String... args) throws ExecutionException, InterruptedException {

        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            System.out.println("i am running in thread : " + Thread.currentThread());
        });

        completableFuture.get();// Block and wait for the future to complete
    }

}
