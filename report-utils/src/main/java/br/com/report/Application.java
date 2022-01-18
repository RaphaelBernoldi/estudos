package br.com.report;

import br.com.report.service.JasperSoftService;
import net.sf.jasperreports.engine.JRException;

public class Application {

    public static void main(String[] args) {
        Application.test1();
        //Application.test2();
    }

    private static void test1(){
        JasperSoftService jasperSoftService = new JasperSoftService();
        jasperSoftService.generatePdf();
    }

    private static void test2(){
        JasperSoftService jasperSoftService = new JasperSoftService();
        try {
            jasperSoftService.generatePdf2();
        } catch (JRException e) {
            e.printStackTrace();
        }
    }
}
