package eu.msdhn.printservice;

import java.util.Iterator;
import java.util.ServiceLoader;

public interface PrintService {

    static PrintService getDefaultInstance(){
        ServiceLoader<PrintService> services = ServiceLoader.load(PrintService.class);
        for (Iterator<PrintService> it = services.iterator(); it.hasNext(); ) {
            PrintService service = it.next();
            if(service.getName().equals("fineprint")){
                return service;
            }
        }
        return null;
    }

    static PrintService getFinePrintService(){
        return getDefaultInstance();
    }

    static PrintService getConsolePrintService(){
        ServiceLoader<PrintService> services = ServiceLoader.load(PrintService.class);
        for (Iterator<PrintService> it = services.iterator(); it.hasNext(); ) {
            PrintService service = it.next();
            if(service.getName().equals("consoleprint")){
                return service;
            }
        }
        return null;
    }


    void print();
    String getName();
}
