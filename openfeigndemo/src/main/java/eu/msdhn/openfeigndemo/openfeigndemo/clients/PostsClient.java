package eu.msdhn.openfeigndemo.openfeigndemo.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "postsClient", url = "${feign.url}", fallbackFactory = PostsClientFallbackFactory.class)
public interface PostsClient {

    @RequestMapping(method = RequestMethod.GET, value = "/posts")
    List<Post> getPosts();

    @RequestMapping(method = RequestMethod.POST, value = "/posts/{postId}", consumes = "application/json")
    Post updatePost(@PathVariable("postId") Long storeId, Post post);

}
