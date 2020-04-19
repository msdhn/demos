package online.msdhn.javadesignpattern.decorator;

public class Mocha extends CondimentAdder {

    private Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDesctiption() {
        return this.beverage.getDescription() + " , Mocha";
    }

    @Override
    public double cost() {
        return this.beverage.cost() + .20d;
    }

}
