module eu.msdhn.fineprint{
    requires eu.msdhn.printservice;

    provides eu.msdhn.printservice.PrintService with eu.msdhn.printservice.fine.FinePrintService;
}