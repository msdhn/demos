package com.hcl.ingbootcamp.javadesignpattern.adaptor;

public class Socket {

    public Volt getStandardVolts() {
        return new Volt(120);
    }

}
