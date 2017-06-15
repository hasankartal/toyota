package com.obss.controller.excel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.obss.model.route.Route;
import com.obss.model.route.type.RouteType;
import com.obss.model.station.Station;
import com.obss.service.route.type.impl.RouteTypeServiceImpl;
import com.obss.service.station.impl.StationServiceImpl;
import jxl.write.WritableWorkbook;

import com.obss.model.city.City;
import com.obss.service.city.impl.CityServiceImpl;
import com.obss.service.route.impl.RouteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Hasan on 6.10.2016.
 */
@Controller
public class RevenueReportController extends AbstractController {

    @Autowired
    CityServiceImpl cityServiceImpl;

    @Autowired
    RouteTypeServiceImpl routeTypeServiceImpl;

    @Autowired
    RouteServiceImpl routeServiceImpl;

    @Autowired
    StationServiceImpl stationServiceImpl;

    @Override
    @RequestMapping(value = "/report", method = RequestMethod.GET)
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        String output = "EXCEL";
//                ServletRequestUtils.getStringParameter(request, "output");
        Map<Integer,Object> revenueData = new HashMap<Integer,Object>();

        List<RouteType> routeTypeList = routeTypeServiceImpl.getAllRouteTypes();
        List<City> cityList = cityServiceImpl.getAllCity();
        List<Route> routeList = routeServiceImpl.getAllRoutes();
        List<Station> stationList = stationServiceImpl.getAllStations();

//      for (City city : cityList) {
        revenueData.put(0,(Object)cityList);
        revenueData.put(1,(Object)routeTypeList);
        revenueData.put(2,(Object)routeList);
        revenueData.put(3,(Object)stationList);
//      }

        //dummy data
//        revenueData.put("Jan-2010", "$100,000,000");
//        revenueData.put("Feb-2010", "$110,000,000");
//        revenueData.put("Mar-2010", "$130,000,000");
//        revenueData.put("Apr-2010", "$140,000,000");
//        revenueData.put("May-2010", "$200,000,000");


        if(output ==null || "".equals(output)){
            //return normal view
            return new ModelAndView("RevenueSummary","revenueData",revenueData);

        }else if("EXCEL".equals(output.toUpperCase())){
            //return excel view
            return new ModelAndView("ExcelRevenueSummary","revenueData",revenueData);

        }else{
            //return normal view
            return new ModelAndView("RevenueSummary","revenueData",revenueData);
        }
    }

}