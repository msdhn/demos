package eu.msdhn.completatblefuturedemo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Demo4 {

    public static void main(String... args) throws ExecutionException, InterruptedException {

        System.out.println(
                CompletableFuture.supplyAsync(() -> Thread.currentThread().toString()).thenApply(x -> x + Thread.currentThread().toString()).get()
        );


        System.out.println(
                CompletableFuture.supplyAsync(() -> Thread.currentThread().toString()).thenApplyAsync(x -> x + Thread.currentThread().toString()).get()
        );




    }
}
