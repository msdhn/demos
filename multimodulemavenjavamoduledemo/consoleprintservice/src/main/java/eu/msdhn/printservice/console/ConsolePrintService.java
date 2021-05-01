package eu.msdhn.printservice.console;

import eu.msdhn.printservice.PrintService;

public class ConsolePrintService implements PrintService {


    @Override
    public void print() {
        System.out.println("consoleprint is done ...");
    }

    @Override
    public String getName() {
        return "consoleprint";
    }
}
