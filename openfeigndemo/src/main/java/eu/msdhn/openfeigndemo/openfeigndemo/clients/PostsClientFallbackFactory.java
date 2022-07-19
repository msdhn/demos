package eu.msdhn.openfeigndemo.openfeigndemo.clients;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PostsClientFallback implements PostsClient {

    @Override
    public List<Post> getPosts() {
        return new ArrayList<>();
    }

    @Override
    public Post updatePost(Long storeId, Post post) {
        return null;
    }
}
