package eu.msdhn.completatblefuturedemo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Demo1 {

    public static void main(String... args) throws ExecutionException, InterruptedException {

        CompletableFuture<Integer> completableFuture = new CompletableFuture<>();
        completableFuture.get();// will block for ever because there is nothing to complete

        System.out.println("done");//will never get printed
    }


}
