package com.obss.view.pdf.station;

import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.obss.model.route.Route;
import com.obss.model.station.Station;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Hasan on 10.10.2016.
 */
public class StationPdfRevenueReportView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter pdfWriter, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        Map<Integer,List<Station>> revenueData = (Map<Integer,List<Station>>) model.get("revenueData");
        List<Station> stations = new ArrayList<Station>();

        int number = 0;
        for (Map.Entry<Integer, List<Station>> entry : revenueData.entrySet()) {
            if (number == 0)
                stations = (List<Station>) entry.getValue();
        }

        Table table = new Table(10);
        table.addCell("Id");
        table.addCell("Durak İsmi");
        table.addCell("Durak No");
        table.addCell("Varış Saati");
        table.addCell("Kalkış Saati");
        table.addCell("Güzergah Id");
        table.addCell("Oluşturma Tarihi");
        table.addCell("UID");
        table.addCell("Güncellenme Tarihi");
        table.addCell("Güncellenmiş UID");

        for (Station station : stations) {
            table.addCell(String.valueOf(station.getId()));
            table.addCell(station.getStationName());
            table.addCell(String.valueOf(station.getStationNo()));
            table.addCell(station.getArrivalTime());
            table.addCell(station.getDepartureTime());
            table.addCell(String.valueOf(station.getRouteId()));
            table.addCell(station.getCreateDate().toString());
            table.addCell(station.getCreateUid());
            table.addCell(station.getLastUpdDate().toString());
            table.addCell(station.getLastUpdUid());
        }

        document.add(table);
    }
}
