package com.hcl.ingbootcamp.javadesignpattern.adaptor;

public final class Volt {

    private int volts;

    public Volt(int volts) {
        this.volts = volts;
    }

    /**
     * @return the volts
     */
    public int getVolts() {
        return volts;
    }

    /**
     * @param volts the volts to set
     */
    public void setVolts(int volts) {
        this.volts = volts;
    }
}
