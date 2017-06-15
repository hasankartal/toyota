package com.obss.controller.pdf.route.type;

import com.obss.model.route.type.RouteType;
import com.obss.service.route.type.impl.RouteTypeServiceImpl;
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
public class RouteTypeReportController extends AbstractController{

    @Autowired
    RouteTypeServiceImpl routeTypeServiceImpl;

    @Override
    @RequestMapping(value = "/route.type.report", method = RequestMethod.GET)
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        String output = "PDF";

        List<RouteType> routeTypeList = routeTypeServiceImpl.getAllRouteTypes();
        Map<Integer,List<RouteType>> revenueData = new HashMap<Integer,List<RouteType>>();
        revenueData.put(0,routeTypeList);

        if(output ==null || "".equals(output)){
            //return normal view
            return new ModelAndView("RevenueSummary","revenueData",revenueData);

        }else if("PDF".equals(output.toUpperCase())){
            //return pdf view
            return new ModelAndView("RouteTypePdfRevenueSummary","revenueData",revenueData);
        }else{
            //return normal view
            return new ModelAndView("RevenueSummary","revenueData",revenueData);

        }
    }
}