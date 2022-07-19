package eu.msdhn.openfeigndemo.openfeigndemo.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "jplaceholder", url = "https://jsonplaceholder.typicode.com/")
public interface FooClient {

    @RequestMapping(method = RequestMethod.GET, value = "/posts")
    List<Post> getPosts();

}
