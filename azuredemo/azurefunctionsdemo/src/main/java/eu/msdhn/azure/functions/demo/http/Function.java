package eu.msdhn.azure.functions.demo.http;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.BindingName;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import com.microsoft.azure.functions.annotation.TableInput;

import java.util.Optional;

/**
 * Azure Functions with HTTP Trigger.
 */
public class Function {

    @FunctionName("getPersonsByName")
    public Person[] getPersonsByName(@HttpTrigger(name = "getPersons", methods = {
            HttpMethod.GET }, authLevel = AuthorizationLevel.ANONYMOUS, route = "persons/{name}") HttpRequestMessage<Optional<String>> request,
            @BindingName("name") String name,
            @TableInput(name = "persons", filter = "Name eq '{name}'", take = "10", tableName = "persons", connection = "msdhn_STORAGE") Person[] persons,
            final ExecutionContext context) {

        context.getLogger().info("Got query for person related to persons with name: " + name);

        return persons;
    }

}
