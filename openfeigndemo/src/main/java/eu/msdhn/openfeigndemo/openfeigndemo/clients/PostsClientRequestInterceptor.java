package eu.msdhn.openfeigndemo.openfeigndemo.clients;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class PostsClientRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("Content-Type", "application/json");
        requestTemplate.header("Accept", "application/json");
    }
}
