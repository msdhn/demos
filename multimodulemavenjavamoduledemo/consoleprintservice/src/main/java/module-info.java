import eu.msdhn.printservice.PrintService;
import eu.msdhn.printservice.console.ConsolePrintService;

module eu.msdhn.consoleprint{
    requires eu.msdhn.printservice;

    provides PrintService with ConsolePrintService;
}
