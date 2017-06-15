package com.obss.view.pdf.route.type;

import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.obss.model.city.City;
import com.obss.model.route.type.RouteType;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Hasan on 10.10.2016.
 */
public class RouteTypePdfRevenueReportView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter pdfWriter, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        Map<Integer,List<RouteType>> revenueData = (Map<Integer,List<RouteType>>) model.get("revenueData");
        List<RouteType> routeTypes = new ArrayList<RouteType>();

        int number = 0;
        for (Map.Entry<Integer, List<RouteType>> entry : revenueData.entrySet()) {
            if (number == 0)
                routeTypes = (List<RouteType>) entry.getValue();
        }

        Table table = new Table(6);
        table.addCell("Id");
        table.addCell("Güzergah Tipi");
        table.addCell("Oluşturma Tarihi");
        table.addCell("UID");
        table.addCell("Güncellenme Tarihi");
        table.addCell("Güncellenmiş UID");

        for (RouteType routeType : routeTypes) {
            table.addCell( String.valueOf(routeType.getId()));
            table.addCell(routeType.getRouteTypeName());
            table.addCell(routeType.getCreateDate().toString());
            table.addCell(routeType.getCreateUid());
            table.addCell(routeType.getLastUpdDate().toString());
            table.addCell(routeType.getLastUpdUid());
        }

        document.add(table);
    }
}