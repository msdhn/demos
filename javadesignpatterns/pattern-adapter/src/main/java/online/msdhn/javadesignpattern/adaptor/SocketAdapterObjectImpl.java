package online.msdhn.javadesignpattern.adaptor;

public class SocketAdapterObjectImpl implements SocketAdapter {

    private Socket socket = new Socket();

    @Override
    public Volt get3Volt() {
        return new Volt(socket.getStandardVolts().getVolts() / 40);
    }

    @Override
    public Volt get4Volt() {
        return new Volt(socket.getStandardVolts().getVolts() / 30);
    }

    @Override
    public Volt get2Volt() {
        return new Volt(socket.getStandardVolts().getVolts() / 60);
    }

}
