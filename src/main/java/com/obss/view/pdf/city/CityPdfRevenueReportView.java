package com.obss.view.pdf.city;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.obss.model.city.City;
import com.obss.service.city.impl.CityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.document.AbstractPdfView;
import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

/**
 * Created by Hasan on 7.10.2016.
 */
public class CityPdfRevenueReportView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map model, Document document,
                                    PdfWriter writer, HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {

        Map<Integer,List<City>> revenueData = (Map<Integer,List<City>>) model.get("revenueData");
        List<City> cities = new ArrayList<City>();

        int number = 0;
        for (Map.Entry<Integer, List<City>> entry : revenueData.entrySet()) {
            if (number == 0)
                cities = (List<City>) entry.getValue();
        }

        Table table = new Table(6);
        table.addCell("Id");
        table.addCell("Ad");
        table.addCell("Oluşturma Tarihi");
        table.addCell("UID");
        table.addCell("Güncellenme Tarihi");
        table.addCell("Güncellenmiş UID");

        for (City city : cities) {
            table.addCell( String.valueOf(city.getId()));
            table.addCell(city.getCityName());
            table.addCell(city.getCreateDate().toString());
            table.addCell(city.getCreateUid());
            table.addCell(city.getLastUpdDate().toString());
            table.addCell(city.getLastUpdUid());
        }

        document.add(table);
    }
}
