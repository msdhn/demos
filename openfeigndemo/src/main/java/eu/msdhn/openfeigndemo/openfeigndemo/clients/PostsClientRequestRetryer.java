package eu.msdhn.openfeigndemo.openfeigndemo.clients;

import feign.Retryer;

import java.util.concurrent.TimeUnit;

//just using the default retryer
public class PostsClientRequestRetryer extends Retryer.Default {

    public PostsClientRequestRetryer() {
        super(100L, TimeUnit.SECONDS.toMillis(1L), 1);
    }
}
