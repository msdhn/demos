package online.msdhn.javadesignpattern.abstractfactory;

public class ProductClient {

    public static void main(String... args) {

        ProductFactory abstractFactory1 = new ProductFactory1();
        abstractFactory1.createProductA().showPrice();
        abstractFactory1.createProductB().showPrice();

        ProductFactory abstractFactory2 = new ProductFactory2();
        abstractFactory2.createProductA().showPrice();
        abstractFactory2.createProductB().showPrice();


    }

}
