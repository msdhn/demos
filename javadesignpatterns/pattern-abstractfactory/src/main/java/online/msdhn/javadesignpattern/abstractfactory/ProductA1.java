package online.msdhn.javadesignpattern.abstractfactory;

public class ProductA1 implements AbstractProductA {

    @Override
    public void showPrice() {
        System.out.println("I am product of type A 1 , price : " + 100d);
    }

}
