package eu.msdhn.azure.functions.demo.queue;

import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;

/**
 * Azure Functions with Azure Storage Queue trigger.
 */
public class QueueTriggerJava1 {
    /**
     * This function will be invoked when a new message is received at the specified path. The message contents are provided as input to this function.
     */
    @FunctionName("QueueTriggerJava1")
    public void run(
        @QueueTrigger(name = "message", queueName = "testqueue", connection = "msdhn_STORAGE") String message,
        final ExecutionContext context
    ) {
        context.getLogger().info("Java Queue trigger function processed a message: " + message);
        Data data = new Data(message,30);
    
        System.out.println(data.toString());
        context.getLogger().info("Java Queue trigger function processed a message: " + data.toString());
    }
}
