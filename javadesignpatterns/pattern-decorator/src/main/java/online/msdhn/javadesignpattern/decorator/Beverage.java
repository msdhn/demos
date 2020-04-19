package online.msdhn.javadesignpattern.decorator;

/**
 * @author masud
 */
public abstract class Beverage {

    protected String description = "not known";

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    public abstract double cost();

}
