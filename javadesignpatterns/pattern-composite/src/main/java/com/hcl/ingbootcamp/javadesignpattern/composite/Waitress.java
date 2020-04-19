package com.hcl.ingbootcamp.javadesignpattern.composite;

public class Waitress {

    public static void main(String... args) {

        MenuComponent burger = new MenuItem("big mac", 4.0f, false);
        burger.print();

        MenuComponent menu = new Menu("super meal");
        MenuComponent sauce = new MenuItem("ketch up", 1.0f, true);

        menu.add(burger);
        menu.add(sauce);

        menu.print();
    }

}
