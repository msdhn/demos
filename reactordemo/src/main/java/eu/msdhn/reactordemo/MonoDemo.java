package eu.msdhn.reactordemo;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.atomic.AtomicLong;

public class MonoDemo {

    public static void main(String... args) {
        var s = Schedulers.newParallel("my-parrallel", 4);

        var flux = Flux.generate(AtomicLong::new, (state, sink) -> {
            long l = state.incrementAndGet();
            sink.next(l);
            if (l == 10) {
                sink.complete();
            }
            return state;
        }).map(x -> x).publishOn(s).map(o -> o + Thread.currentThread().getName());


        flux.subscribe(l -> processData(l), error -> processError(error), () -> processCompletion());
    }

    private static void processCompletion() {
        System.out.println("completed");
    }

    private static void processError(Throwable error) {
        System.out.println(error);
    }

    private static void processData(Object l) {
        System.out.println(l);
    }
}


