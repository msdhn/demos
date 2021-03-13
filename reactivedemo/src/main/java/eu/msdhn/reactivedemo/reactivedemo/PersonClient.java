package eu.msdhn.reactivedemo.reactivedemo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "personClient", url = "http://localhost:8080", configuration = FeignClientConfig.class)
public interface PersonClient {

    @RequestMapping(method = RequestMethod.GET, value = "/person/1")
    Person getAPerson();

    @RequestMapping(method = RequestMethod.GET, value = "/person")
    Person getPersons();
}
