package online.msdhn.javadesignpattern.adaptor;

public class Socket {

    public Volt getStandardVolts() {
        return new Volt(120);
    }

}
