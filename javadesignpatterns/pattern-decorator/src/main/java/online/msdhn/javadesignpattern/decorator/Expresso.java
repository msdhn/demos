package online.msdhn.javadesignpattern.decorator;

/**
 * @author masud
 */
public class Expresso extends Beverage {

    /**
     * Expresso
     */
    public Expresso() {
        this.description = "Expresso";
    }

    @Override
    public double cost() {
        return 1.50d;
    }

}
