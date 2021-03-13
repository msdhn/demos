package eu.msdhn.reactivedemo.reactivedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;


@SpringBootApplication
@EnableFeignClients
public class ReactivedemoApplication {

    public static void main(String[] args) throws IOException {
        var appContext = SpringApplication.run(ReactivedemoApplication.class, args);

        // consuming the api using WebClient
        WebClient client = WebClient.create("http://localhost:8080");
        client.get()
                .uri("/person")
                .exchange()
                .flatMapMany(res -> res.bodyToFlux(Person.class))
                .collectList()
                .subscribe(people -> people.forEach(p -> System.out.println(p)));

        // consuming the api using Feign client
        var personClient = appContext.getBean(PersonClient.class);
        System.out.println(
                personClient.getAPerson());
    }

}
