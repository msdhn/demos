package eu.msdhn.mosmosdbdemo;

import lombok.extern.slf4j.Slf4j;

/**
 * Hello world!
 */

@Slf4j
public class App {
    public static void main(String[] args) {
        var cosMosManager = ManageCosmosDB.getInstance();
        cosMosManager.container("test_db", "products", "/id");
        cosMosManager.container("test_db", "customer", "/city");
        cosMosManager.container("test_db", "address", "/city");
        cosMosManager.closeClient();
    }
}
