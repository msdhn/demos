package eu.msdhn.reactivedemo.reactivedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestClientException;

import java.io.IOException;

@Controller
public class PersonControllerClient {

    @Autowired
    private PersonClient personClient;

    public void getPerson() throws RestClientException, IOException {
        try {
            Person person = personClient.getAPerson();
            System.out.println(person);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
