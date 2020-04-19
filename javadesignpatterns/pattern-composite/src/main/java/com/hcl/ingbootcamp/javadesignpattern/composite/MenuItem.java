package com.hcl.ingbootcamp.javadesignpattern.composite;

public class MenuItem extends MenuComponent {

    private String name;
    private double price;
    private boolean isVeg;

    public MenuItem(String name, double price, boolean isVeg) {
        this.name = name;
        this.price = price;
        this.isVeg = isVeg;
    }

    /**
     * @return the name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the price
     */
    @Override
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the isVeg
     */
    @Override
    public boolean isVeg() {
        return isVeg;
    }

    /**
     * @param isVeg the isVeg to set
     */
    public void setVeg(boolean isVeg) {
        this.isVeg = isVeg;
    }

    @Override
    public void print() {
        System.out.println(" " + this.name + " , " + ((this.isVeg) ? "V" : "NV") + " , " + this.price);
    }

}
