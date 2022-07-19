package eu.msdhn.openfeigndemo.openfeigndemo.clients;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class PostsClientFallbackFactory implements FallbackFactory<PostsClient> {

    @Override
    public PostsClient create(Throwable cause) {
        log.error("" + cause);
        //provide a fallback implementation
        return new PostsClient() {
            @Override
            public List<Post> getPosts() {
                return new ArrayList<>();
            }

            @Override
            public Post updatePost(Long storeId, Post post) {
                return null;
            }
        };
    }

}
