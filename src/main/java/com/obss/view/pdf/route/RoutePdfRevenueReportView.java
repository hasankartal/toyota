package com.obss.view.pdf.route;

import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.obss.model.city.City;
import com.obss.model.route.Route;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Hasan on 7.10.2016.
 */
public class RoutePdfRevenueReportView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map model, Document document,
                                    PdfWriter writer, HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {

        Map<Integer,List<Route>> revenueData = (Map<Integer,List<Route>>) model.get("revenueData");
        List<Route> routes = new ArrayList<Route>();

        int number = 0;
        for (Map.Entry<Integer, List<Route>> entry : revenueData.entrySet()) {
            if (number == 0)
                routes = (List<Route>) entry.getValue();
        }

        Table table = new Table(9);
        table.addCell("Id");
        table.addCell("Ad");
        table.addCell("Güzergah Toplam Süresi");
        table.addCell("Peron Numarası");
        table.addCell("Araç Tipi");
        table.addCell("Oluşturma Tarihi");
        table.addCell("UID");
        table.addCell("Güncellenme Tarihi");
        table.addCell("Güncellenmiş UID");

        for (Route route : routes) {
            table.addCell( String.valueOf(route.getId()));
            table.addCell(route.getRouteName());
            table.addCell( String.valueOf(route.getTotalDuration()));
            table.addCell( String.valueOf(route.getPeronNo()));
            table.addCell( String.valueOf(route.getVehicleType()));
            table.addCell(route.getCreateDate().toString());
            table.addCell(route.getCreateUid());
            table.addCell(route.getLastUpdDate().toString());
            table.addCell(route.getLastUpdUid());
        }

        document.add(table);
    }
}
