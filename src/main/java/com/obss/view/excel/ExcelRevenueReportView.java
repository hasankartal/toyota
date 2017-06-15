package com.obss.view.excel;

import com.obss.model.city.City;
import com.obss.model.route.Route;
import com.obss.model.route.type.RouteType;
import com.obss.model.station.Station;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.view.document.AbstractJExcelView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Hasan
 * @since 6.10.2016.
 */
public class ExcelRevenueReportView extends AbstractJExcelView {

    @Override
    protected void buildExcelDocument(Map model, WritableWorkbook workbook,
                                      HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        Map<Integer,Object> revenueData = (Map<Integer,Object>) model.get("revenueData");

        WritableSheet sheet = workbook.createSheet("City Report", 0);
        WritableSheet sheetRouteType = workbook.createSheet("Route Type Report", 0);
        WritableSheet sheetRoute = workbook.createSheet("Route Report", 0);
        WritableSheet sheetStation = workbook.createSheet("Station Report", 0);

        List<City> cities = new ArrayList<City>();
        List<RouteType> routeTypes = new ArrayList<RouteType>();
        List<Route> routes = new ArrayList<Route>();
        List<Station> stations = new ArrayList<Station>();

        int number = 0;
        for (Map.Entry<Integer, Object> entry : revenueData.entrySet()) {
            if (number == 0)
                cities = (List<City>) entry.getValue();
            else if(number == 1)
                routeTypes = (List<RouteType>) entry.getValue();
            else if (number == 2)
                routes = (List<Route>) entry.getValue();
            else if (number == 3)
                stations = (List<Station>) entry.getValue();
            number++;
        }

        /*
         * City
         */
        sheet.addCell(new Label(0, 0, "Id"));
        sheet.addCell(new Label(1, 0, "Ad"));
        sheet.addCell(new Label(2, 0, "Oluşturma Tarihi"));
        sheet.addCell(new Label(3, 0, "UID"));
        sheet.addCell(new Label(4, 0, "Güncellenme Tarihi"));
        sheet.addCell(new Label(5, 0, "Güncellenmiş UID"));

        int rowNum = 1;
        for (City city : cities) {
            //create the row data
            sheet.addCell(new Label(0, rowNum, (String.valueOf(city.getId()))));
            sheet.addCell(new Label(1, rowNum, city.getCityName()));
            sheet.addCell(new Label(2, rowNum, city.getCreateDate().toString()));
            sheet.addCell(new Label(3, rowNum, city.getCreateUid()));
            sheet.addCell(new Label(4, rowNum, city.getLastUpdDate().toString()));
            sheet.addCell(new Label(5, rowNum, city.getLastUpdUid()));
            rowNum++;
        }

        /*
         * RouteType
         */
        sheetRouteType.addCell(new Label(0, 0, "Id"));
        sheetRouteType.addCell(new Label(1, 0, "Ad"));
        sheetRouteType.addCell(new Label(2, 0, "Oluşturma Tarihi"));
        sheetRouteType.addCell(new Label(3, 0, "UID"));
        sheetRouteType.addCell(new Label(4, 0, "Güncellenme Tarihi"));
        sheetRouteType.addCell(new Label(5, 0, "Güncellenmiş UID"));

        rowNum = 1;
        for (RouteType routeType : routeTypes) {
            //create the row data
            sheetRouteType.addCell(new Label(0, rowNum, String.valueOf(routeType.getId()) ));
            sheetRouteType.addCell(new Label(1, rowNum, routeType.getRouteTypeName()));
            sheetRouteType.addCell(new Label(2, rowNum, routeType.getCreateDate().toString()));
            sheetRouteType.addCell(new Label(3, rowNum, routeType.getCreateUid()));
            sheetRouteType.addCell(new Label(4, rowNum, routeType.getLastUpdDate().toString()));
            sheetRouteType.addCell(new Label(5, rowNum, routeType.getLastUpdUid().toString()));
            rowNum++;
        }

        /*
         * Route
         */
        sheetRoute.addCell(new Label(0, 0, "Id"));
        sheetRoute.addCell(new Label(1, 0, "Güzergah"));
        sheetRoute.addCell(new Label(2, 0, "Güzergah Toplam Süresi"));
        sheetRoute.addCell(new Label(3, 0, "Kuzey Otoparkı Peron No"));
        sheetRoute.addCell(new Label(4, 0, "Servis Aracı"));
        sheetRoute.addCell(new Label(5, 0, "Oluşturma Tarihi"));
        sheetRoute.addCell(new Label(6, 0, "UID"));
        sheetRoute.addCell(new Label(7, 0, "Güncellenme Tarihi"));
        sheetRoute.addCell(new Label(8, 0, "Güncellenmiş UID"));

        rowNum = 1;
        for (Route route : routes) {
            //create the row data
            sheetRoute.addCell(new Label(0, rowNum, String.valueOf(route.getId()) ));
            sheetRoute.addCell(new Label(1, rowNum, route.getRouteName()));
            sheetRoute.addCell(new Label(2, rowNum, String.valueOf(route.getTotalDuration())));
            sheetRoute.addCell(new Label(3, rowNum, String.valueOf(route.getPeronNo())));
            sheetRoute.addCell(new Label(4, rowNum, String.valueOf(route.getVehicleType())));
            sheetRoute.addCell(new Label(5, rowNum, route.getCreateDate().toString()));
            sheetRoute.addCell(new Label(6, rowNum, route.getCreateUid()));
            sheetRoute.addCell(new Label(7, rowNum, route.getLastUpdDate().toString()));
            sheetRoute.addCell(new Label(8, rowNum, route.getLastUpdUid().toString()));
            rowNum++;
        }

        /*
         * Station
        */
        sheetStation.addCell(new Label(0, 0, "Id"));
        sheetStation.addCell(new Label(1, 0, "Durak İsmi"));
        sheetStation.addCell(new Label(2, 0, "Durak No"));
        sheetStation.addCell(new Label(3, 0, "Varış Saati(TMMT'den)"));
        sheetStation.addCell(new Label(4, 0, "Kalkış Saati(TMMT'ye)"));
        sheetStation.addCell(new Label(5, 0, "Oluşturma Tarihi"));
        sheetStation.addCell(new Label(6, 0, "UID"));
        sheetStation.addCell(new Label(7, 0, "Güncellenme Tarihi"));
        sheetStation.addCell(new Label(8, 0, "Güncellenmiş UID"));

        rowNum = 1;
        for (Station station : stations) {
            //create the row data
            sheetStation.addCell(new Label(0, rowNum, (String.valueOf(station.getId()))));
            sheetStation.addCell(new Label(1, rowNum, station.getStationName()));
            sheetStation.addCell(new Label(2, rowNum, (String.valueOf(station.getStationNo()))));
            sheetStation.addCell(new Label(3, rowNum, station.getArrivalTime()));
            sheetStation.addCell(new Label(4, rowNum, station.getDepartureTime()));
            sheetStation.addCell(new Label(5, rowNum, station.getCreateDate().toString()));
            sheetStation.addCell(new Label(6, rowNum, station.getCreateUid()));
            sheetStation.addCell(new Label(7, rowNum, station.getLastUpdDate().toString()));
            sheetStation.addCell(new Label(8, rowNum, station.getLastUpdUid().toString()));
            rowNum++;
        }


    }
}
