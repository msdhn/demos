package online.msdhn.javadesignpattern.facade;

/**
 * @author masud
 */
public class HomeTheatorFacade {

    private Amplifier amplifier;
    private Lights lights;
    private DvDPlayer dvDPlayer;
    private Projector projector;
    private Screen screen;

    public HomeTheatorFacade(Amplifier amplifier, Lights lights, DvDPlayer dvDPlayer, Projector projector,
                             Screen screen) {
        this.amplifier = amplifier;
        this.lights = lights;
        this.dvDPlayer = dvDPlayer;
        this.projector = projector;
        this.screen = screen;
    }

    public void watchMovie(String movieaName) {
        System.out.println(movieaName + " is starting.............");
        this.lights.off();
        this.screen.down();
        this.projector.on();
        this.amplifier.on();
        this.dvDPlayer.on();
    }

    public void stopMovie() {
        System.out.println("stop movie .............");
        this.dvDPlayer.off();
        this.lights.on();
        this.projector.off();
        this.amplifier.off();
        this.screen.up();
    }
}
