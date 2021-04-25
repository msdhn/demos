package eu.msdhn.multimodulemavenjavamoduledemo.dao;

import eu.msdhn.multimodulemavenjavamoduledemo.entity.ExampleEntity;

public class ExampleDao {

    public ExampleEntity getData() {
        ExampleEntity entity = new ExampleEntity();
        entity.setName("Masud Hasan");
        return entity;
    }

}
