package br.com.report.service;

import br.com.report.Application;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.view.JasperViewer;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JasperSoftService {

    public void generatePdf2() throws JRException {
        System.out.println("Inicio carregamento jrxml" + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
        HashMap<String, Object> params = new HashMap<String, Object>();

        // 2.  Retrieve template
        InputStream reportStream = this.getClass().getResourceAsStream("/report1.jrxml");

        // 3. Convert template to JasperDesign
        JasperDesign jd = JRXmlLoader.load(reportStream);

        // 4. Compile design to JasperReport
        JasperReport jr = JasperCompileManager.compileReport(jd);

        // 5. Create the JasperPrint object
        // Make sure to pass the JasperReport, report parameters, and data source
        JasperPrint jp = JasperFillManager.fillReport(jr, params);

        // 6. Create an output byte stream where data will be written
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        // 7. Export report
        //exporter.export(type, jp, response, baos);

        // 8. Write to reponse stream
        //write(token, response, baos);
    }
    public void generatePdf(){
        try {
            System.out.println("Inicio carregamento jrxml" + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
           // JasperDesign load = JRXmlLoader.load("/report1.jrxml");
           // JasperReport jasperReportJrxml = JasperCompileManager.compileReport("/src/main/resources/report1.jrxml");
           // File xml = new File(this.getClass()
           //         .getResource("/report1.jrxml").getFile());
            JasperDesign jasperDesign =JRXmlLoader.load(this.getClass().getResourceAsStream("/report1.jrxml"));

            //JasperDesign jasperDesign = JRXmlLoader.load(xml);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            Map<String, Object> params = new HashMap();



            //JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params);
            JasperRunManager.runReportToPdf(jasperReport, params);




            System.out.println("Inicio carregamento jasper" + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
            //JasperReport jasperReportJasper = JasperCompileManager.compileReport("/report1.jasper");

            System.out.println("Fim " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
        } catch (JRException e) {
            e.printStackTrace();
        }
    }

    public void exportPdf(JasperPrint jp, ByteArrayOutputStream baos) {
        // Create a JRXlsExporter instance
        JRPdfExporter exporter = new JRPdfExporter();

        // Here we assign the parameters jp and baos to the exporter
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);

        try {
            exporter.exportReport();

        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }


}
