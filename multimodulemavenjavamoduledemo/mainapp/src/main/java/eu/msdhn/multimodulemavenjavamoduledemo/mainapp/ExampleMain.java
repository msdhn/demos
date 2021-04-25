package eu.msdhn.multimodulemavenjavamoduledemo.mainapp;

import eu.msdhn.multimodulemavenjavamoduledemo.dao.ExampleDao;

public class ExampleMain {

    public static void main(String... args) {
        ExampleDao exampleDao = new ExampleDao();
        System.out.println(exampleDao.getData().getName());
    }

}
