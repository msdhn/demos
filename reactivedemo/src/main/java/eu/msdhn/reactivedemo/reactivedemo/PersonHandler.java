package eu.msdhn.reactivedemo.reactivedemo;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Collections;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class PersonHandler {

    public Mono<ServerResponse> listPeople(ServerRequest request) {
        Person person = new Person();
        person.setName("Masud");
        person.setAge(30);
        return ok().bodyValue(Collections.singleton(person));
    }

    public Mono<ServerResponse> createPerson(ServerRequest request) {
        return ok().bodyValue("person is created");
    }

    public Mono<ServerResponse> getPerson(ServerRequest request) {
        Person person = new Person();
        person.setName("Masud");
        person.setAge(30);
        return ok().bodyValue(person);
    }

}