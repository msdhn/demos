package com.hcl.ingbootcamp.javadesignpattern.facade;

public class FacadeDemo {

    public static void main(String... args) {
        HomeTheatorFacade homeTheatorFacade = new HomeTheatorFacade(new Amplifier(), new Lights(), new DvDPlayer(),
                new Projector(), new Screen());

        homeTheatorFacade.watchMovie("MATRIX");
        homeTheatorFacade.stopMovie();
    }

}
