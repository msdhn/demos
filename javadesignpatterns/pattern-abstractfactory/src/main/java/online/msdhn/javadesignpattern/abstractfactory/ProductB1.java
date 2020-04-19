package online.msdhn.javadesignpattern.abstractfactory;

public class ProductB1 implements AbstractProductB {

    @Override
    public void showPrice() {
        System.out.println("I am product of type B 1 , price : " + 50d);

    }


}
