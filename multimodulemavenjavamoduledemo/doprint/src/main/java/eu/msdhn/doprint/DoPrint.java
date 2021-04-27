package eu.msdhn.doprint;

import eu.msdhn.printservice.PrintService;

import java.util.Objects;

public class DoPrint {

    public static void main(String... args) {

        PrintService printServiceDefault = PrintService.getDefaultInstance();
        if (Objects.nonNull(printServiceDefault)) {
            printServiceDefault.print();
        }

        PrintService printServiceConsole = PrintService.getConsolePrintService();
        if (Objects.nonNull(printServiceConsole)) {
            printServiceConsole.print();
        }

    }

}
