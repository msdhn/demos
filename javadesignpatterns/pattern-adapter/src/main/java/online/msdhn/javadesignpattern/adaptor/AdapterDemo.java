package online.msdhn.javadesignpattern.adaptor;

public class AdapterDemo {

    public static void main(String... args) {

        SocketAdapter socketAdapter = new WorkingSocketAdapter();
        SocketAdapter socketAdapterObj = new WorkingSocketAdapter();

        System.out.println(socketAdapter.get2Volt().getVolts());
        System.out.println(socketAdapterObj.get2Volt().getVolts());

    }

}
