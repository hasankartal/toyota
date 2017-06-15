package com.obss.controller.pdf.station;

import com.obss.model.station.Station;
import com.obss.service.station.impl.StationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Hasan on 10.10.2016.
 */
@Controller
public class StationReportController extends AbstractController {

    @Autowired
    StationServiceImpl stationServiceImpl;

    @Override
    @RequestMapping(value = "/station.report",method = RequestMethod.GET)
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        String output = "PDF";

        List<Station> stationList = stationServiceImpl.getAllStations();
        Map<Integer,List<Station>> revenueData = new HashMap<Integer,List<Station>>();
        revenueData.put(0,stationList);

        if(output ==null || "".equals(output)){
            //return normal view
            return new ModelAndView("RevenueSummary","revenueData",revenueData);

        }else if("PDF".equals(output.toUpperCase())){
            //return pdf view
            return new ModelAndView("StationPdfRevenueSummary","revenueData",revenueData);
        }else{
            //return normal view
            return new ModelAndView("RevenueSummary","revenueData",revenueData);
        }
    }
}