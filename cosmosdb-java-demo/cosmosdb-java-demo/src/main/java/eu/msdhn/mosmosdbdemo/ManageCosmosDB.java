package eu.msdhn.mosmosdbdemo;

import com.azure.core.http.ProxyOptions;
import com.azure.core.util.Configuration;
import com.azure.cosmos.*;

import java.util.Arrays;

public class ManageCosmosDB {

    private static final ManageCosmosDB INSTANCE = new ManageCosmosDB();
    private CosmosClient cosmosClient;

    private ManageCosmosDB() {
        ProxyOptions proxyOptions = ProxyOptions.fromConfiguration(Configuration.getGlobalConfiguration());
        this.cosmosClient = new CosmosClientBuilder()
                .gatewayMode(new GatewayConnectionConfig().setProxy(proxyOptions))
                .endpoint(System.getenv("COSMOS_ENDPOINT"))
                .key(System.getenv("COSMOS_KEY"))
                .consistencyLevel(ConsistencyLevel.SESSION)
                .connectionSharingAcrossClientsEnabled(true)
                .contentResponseOnWriteEnabled(true)
                .userAgentSuffix("my-application1-client")
                .preferredRegions(Arrays.asList("West Europe", "North Europe"))
                .buildClient();
    }

    public static ManageCosmosDB getInstance() {
        return INSTANCE;
    }

    private String db(String dbName) {
        var db = this.cosmosClient.createDatabaseIfNotExists("test_db");
        return db.getProperties().getId();
    }

    public ManageCosmosDB container(String dbName, String containerName, String partitionKey) {
        this.cosmosClient.getDatabase(this.db(dbName)).createContainerIfNotExists(containerName, partitionKey);
        return this;
    }

    public void closeClient() {
        this.cosmosClient.close();
    }

}
