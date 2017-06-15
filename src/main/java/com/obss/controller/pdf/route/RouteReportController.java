package com.obss.controller.pdf.route;

import com.obss.model.route.Route;
import com.obss.service.route.impl.RouteServiceImpl;
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
public class RouteReportController extends AbstractController {

    @Autowired
    RouteServiceImpl routeServiceImpl;

    @Override
    @RequestMapping(value = "/route.report", method = RequestMethod.GET)
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        String output = "PDF";

        List<Route> routeList = routeServiceImpl.getAllRoutes();
        Map<Integer,List<Route>> revenueData = new HashMap<Integer,List<Route>>();
        revenueData.put(0, routeList);

        if(output ==null || "".equals(output)){
            //return normal view
            return new ModelAndView("RevenueSummaryy","revenueData",revenueData);

        }else if("PDF".equals(output.toUpperCase())){
            //return excel view
            return new ModelAndView("RoutePdfRevenueSummary","revenueData",revenueData);

        }else{
            //return normal view
            return new ModelAndView("RevenueSummaryy","revenueData",revenueData);

        }
    }
}