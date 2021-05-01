package eu.msdhn.printservice.fine;

import eu.msdhn.printservice.PrintService;

public class FinePrintService implements PrintService {

    @Override
    public void print() {
        System.out.println("fineprint is done ...");
    }

    @Override
    public String getName() {
        return "fineprint" ;
    }
}
