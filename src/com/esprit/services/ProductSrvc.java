/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.services;

import com.esprit.utils.DBConnection;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 *
 * @author Foura
 */
public class ProductSrvc {

    private Connection con;
    private Statement ste;

    public ProductSrvc() {
    }

    public void exportTable() throws SQLException, FileNotFoundException {
        try {
            Connection con = DBConnection.getInstance().getConnection();
            Statement stmt = con.createStatement();

            ResultSet query_set = stmt.executeQuery("SELECT * from products");
            Document my_pdf_report = new Document();
            int min = 10000;
            int max = 99999;
            int random_id = (int) Math.floor(Math.random() * (max - min + 1) + min);
            PdfWriter.getInstance(my_pdf_report, new FileOutputStream("C:/Users/Foura/Documents/NetBeansProjects/arena-desktop/src/com/esprit/uploads/reports/products/report" + random_id + ".pdf"));

            my_pdf_report.open();
            my_pdf_report.add(new Paragraph("                                      Products report", FontFactory.getFont("Arial", 20)));
            my_pdf_report.add(new Paragraph("  "));
            my_pdf_report.add(new Paragraph("  "));

            //we have four columns in our table
            PdfPTable my_report_table = new PdfPTable(3);

            //create a cell object
            PdfPCell table_cell;
            table_cell = new PdfPCell(new Phrase("name"));
            my_report_table.addCell(table_cell);
            table_cell = new PdfPCell(new Phrase("quantity"));
            my_report_table.addCell(table_cell);
            table_cell = new PdfPCell(new Phrase("description"));
            my_report_table.addCell(table_cell);

            while (query_set.next()) {
                String titre = query_set.getString("name");
                table_cell = new PdfPCell(new Phrase(titre));
                my_report_table.addCell(table_cell);
                String auteur = query_set.getString("qty");
                table_cell = new PdfPCell(new Phrase(auteur));
                my_report_table.addCell(table_cell);
                String img_post = query_set.getString("description");
                table_cell = new PdfPCell(new Phrase(img_post));
                my_report_table.addCell(table_cell);
            }
            Notifications notifications = Notifications.create();
            notifications.text("Report generated");
            notifications.title("Notification");
            notifications.hideAfter(Duration.seconds(4));
            notifications.darkStyle();
            notifications.show();
            my_pdf_report.addTitle("Products report");
            my_pdf_report.add(my_report_table);

            my_pdf_report.close();

        } catch (DocumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

}