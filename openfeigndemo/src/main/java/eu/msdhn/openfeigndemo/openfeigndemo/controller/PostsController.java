package eu.msdhn.openfeigndemo.openfeigndemo.controller;

import eu.msdhn.openfeigndemo.openfeigndemo.clients.PostsClient;
import eu.msdhn.openfeigndemo.openfeigndemo.clients.Post;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostsController {

    private PostsClient fooClient;

    public PostsController(PostsClient fooClient) {
        this.fooClient = fooClient;
    }

    @RequestMapping("/posts")
    public List<Post> posts() {
        var posts = fooClient.getPosts();
        return posts;
    }

}
