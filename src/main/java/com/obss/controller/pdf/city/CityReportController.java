package com.obss.controller.pdf.city;

import com.obss.model.city.City;
import com.obss.service.city.impl.CityServiceImpl;
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
 * Created by Hasan on 7.10.2016.
 */
@Controller
public class CityReportController extends AbstractController {

    @Autowired
    CityServiceImpl cityServiceImpl;

    @Override
    @RequestMapping(value = "/city.report", method = RequestMethod.GET)
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        String output = "PDF";

        List<City> cityList = cityServiceImpl.getAllCity();
        Map<Integer,List<City>> revenueData = new HashMap<Integer,List<City>>();
        revenueData.put(0,cityList);

        if(output ==null || "".equals(output)){
            //return normal view
            return new ModelAndView("jsp/RevenueSummary","revenueData",revenueData);

        }else if("PDF".equals(output.toUpperCase())){
            //return excel view
            return new ModelAndView("CityPdfRevenueSummary","revenueData",revenueData);

        }else{
            //return normal view
            return new ModelAndView("jsp/RevenueSummary","revenueData",revenueData);

        }
    }
}