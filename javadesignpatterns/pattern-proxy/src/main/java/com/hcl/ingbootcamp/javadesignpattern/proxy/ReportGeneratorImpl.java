package com.hcl.ingbootcamp.javadesignpattern.proxy;

/**
 * @author masud
 */
public class ReportGeneratorImpl implements ReportGenerator {

    public ReportGeneratorImpl() {
        System.out.println("ReportGeneratorImpl instance created");
    }

    /*
     * (non-Javadoc)
     *
     * @see com.hcl.ingbootcamp.javadesignpattern.proxy.ReportGenerator#
     * displayReportTemplate(java.lang.String, int)
     */
    @Override
    public void displayReportTemplate(String reportFormat, int reportEntries) {
        System.out.println("ReportGeneratorImpl: diplaying template");
    }

    /*
     * (non-Javadoc)
     *
     * @see com.hcl.ingbootcamp.javadesignpattern.proxy.ReportGenerator#
     * generateComplexReport(java.lang.String, int)
     */
    @Override
    public void generateComplexReport(String reportFormat, int reportEntries) {
        System.out.println("ReportGeneratorImpl: Generating complex report in " + reportFormat + " format with "
                + reportEntries + " entries");
    }

    /*
     * (non-Javadoc)
     *
     * @see com.hcl.ingbootcamp.javadesignpattern.proxy.ReportGenerator#
     * generateSensitiveReport()
     */
    @Override
    public void generateSensitiveReport() {
        System.out.println("ReportGeneratorImpl: Generating sensitive report");
    }

}