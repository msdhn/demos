package com.hcl.ingbootcamp.javadesignpattern.adaptor;

public class WorkingSocketAdapter extends Socket implements SocketAdapter {

    @Override
    public Volt get3Volt() {
        return new Volt(getStandardVolts().getVolts() / 40);
    }

    @Override
    public Volt get4Volt() {
        return new Volt(getStandardVolts().getVolts() / 30);
    }

    @Override
    public Volt get2Volt() {
        return new Volt(getStandardVolts().getVolts() / 60);
    }

}
