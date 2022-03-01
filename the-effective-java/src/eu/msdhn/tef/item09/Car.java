package eu.msdhn.tef.item09;

import java.util.stream.Stream;

public final class Car implements Cloneable {

    private int price;

    private MyInner myInner;

    public Car(int price) {
        this.price = price;
        this.myInner = new MyInner(this.price);
    }

    public static void main(String... args) {
        Car car = new Car(100);
        try {
            Car cloned = (Car) car.clone();
            System.out.println(cloned.price);
            System.out.println(cloned.myInner.number);


            Stream.iterate(1, n -> n + 1).limit(10).forEach(System.out::println);


        } catch (CloneNotSupportedException cloneNotSupportedException) {
            cloneNotSupportedException.printStackTrace();
        }
    }

    private static class MyInner {
        private int number;

        MyInner(int number) {
            this.number = number;
        }
    }

}
