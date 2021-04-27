module eu.msdhn.consoleprint{
    requires eu.msdhn.printservice;

    provides eu.msdhn.printservice.PrintService with eu.msdhn.printservice.console.ConsolePrintService;
}