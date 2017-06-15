package com.obss.controller.route;

import com.obss.model.city.City;
import com.obss.model.route.Route;
import com.obss.model.route.type.RouteType;
import com.obss.service.city.impl.CityServiceImpl;
import com.obss.service.route.impl.RouteServiceImpl;
import com.obss.service.route.type.impl.RouteTypeServiceImpl;
import com.obss.service.station.impl.StationServiceImpl;
import com.obss.validator.route.RouteValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sun.security.pkcs11.wrapper.CK_DESTROYMUTEX;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Hasan KARTAL
 * @since 29.08.2016.
 */
@Controller
public class RouteController {

    @Autowired
    private RouteServiceImpl routeServiceImpl;

    @Autowired
    private CityServiceImpl cityServiceImpl;

    @Autowired
    private RouteTypeServiceImpl routeTypeServiceImpl;

    @Autowired
    private StationServiceImpl stationServiceImpl;

    @Autowired
    private RouteValidator routeValidator;

    @RequestMapping(value = "route.list", method = RequestMethod.GET)
    public String getRouteList(Model model) {
        List<Route> routeList = routeServiceImpl.getAllRoutes();
        List<City> cities = cityServiceImpl.getAllCity();
        List<RouteType> routeTypes = routeTypeServiceImpl.getAllRouteTypes();
        Map<Integer,String> allCities = new HashMap<Integer, String>();
        Map<Integer,String> allRouteTypes = new HashMap<Integer,String>();

        for (City city : cities)
            allCities.put(city.getId(), city.getCityName().toUpperCase());
        for (RouteType routeType : routeTypes)
            allRouteTypes.put(routeType.getId(),routeType.getRouteTypeName().toUpperCase());
        model.addAttribute("newRoute", new Route());
        model.addAttribute("allRoutes", routeList);
        model.addAttribute("allCities", allCities);
        model.addAttribute("allRouteTypes", allRouteTypes);
        return "jsp/route/route";
    }

    @RequestMapping(value = "/route.get", method = RequestMethod.POST)
    public String getRoute(@ModelAttribute("newRoute") Route route, BindingResult bindingResult,Model model) {
        City city = cityServiceImpl.getCityById(route.getCityId());
        RouteType routeType = routeTypeServiceImpl.getRouteTypeById(route.getRouteTypeId());

        routeValidator.validate(route,bindingResult);
        if(route.getId() == 0) {
            route.setCreateUid("asd");
            route.setCreateDate(new Date());
            route.setLastUpdUid("asd");
            route.setLastUpdDate(new Date());
            route.setCity(city);
            route.setRouteType(routeType);
            routeServiceImpl.insertRoute(route);
        } else {
            Route oldRoute = routeServiceImpl.getRouteById(route.getId());
            route.setCreateUid(oldRoute.getCreateUid());
            route.setCreateDate(oldRoute.getCreateDate());
            route.setLastUpdUid("asd " + new Date());
            route.setLastUpdDate(new Date());
            route.setCity(city);
            route.setRouteType(routeType);
            routeServiceImpl.updateRoute(route);
        }

        return "redirect:/route.list";
    }

    @RequestMapping(value = "/route.delete{routeId}", method = RequestMethod.GET)
    public String deleteRoute(@RequestParam("routeId") int id,Model model) {
        Boolean isRoute = stationServiceImpl.hasRoute(id);
        if(isRoute) {
            model.addAttribute("msg", "Welcome to the Netherlands!");
            model.addAttribute("error", true);
            model.addAttribute("sanane","Sanane.");
        } else {
            routeServiceImpl.deleteRoute(id);
        }
        return "redirect:/route.list";
    }

    @RequestMapping(value = "/route.edit{routeId}", method = RequestMethod.GET)
    public String editRoute(@RequestParam("routeId") int id, Model model) {
        List<Route> routeList = routeServiceImpl.getAllRoutes();
        List<City> cities = cityServiceImpl.getAllCity();
        List<RouteType> routeTypes = routeTypeServiceImpl.getAllRouteTypes();
        Map<Integer,String> allCities = new HashMap<Integer, String>();
        Map<Integer,String> allRouteTypes = new HashMap<Integer,String>();

        for (City city : cities)
            allCities.put(city.getId(), city.getCityName().toUpperCase());
        for (RouteType routeType : routeTypes)
            allRouteTypes.put(routeType.getId(),routeType.getRouteTypeName().toUpperCase());

        model.addAttribute("newRoute", routeServiceImpl.getRouteById(id));
        model.addAttribute("allCities", allCities);
        model.addAttribute("allRoutes", routeList);
        model.addAttribute("allRouteTypes", allRouteTypes);
        model.addAttribute("update", "update");

        return "jsp/route/route";
    }

    @RequestMapping(value = "/route.searchPage", method = RequestMethod.GET)
    public String searchPageRouteType(@ModelAttribute("newRouteType") Route route,Model model) {

        List<Route> routeList = routeServiceImpl.getAllRoutes();
        List<City> cities = cityServiceImpl.getAllCity();
        List<RouteType> routeTypes = routeTypeServiceImpl.getAllRouteTypes();
        Map<Integer,String> allCities = new HashMap<Integer, String>();
        Map<Integer,String> allRouteTypes = new HashMap<Integer,String>();

        for (City city : cities)
            allCities.put(city.getId(), city.getCityName().toUpperCase());
        for (RouteType routeType : routeTypes)
            allRouteTypes.put(routeType.getId(),routeType.getRouteTypeName().toUpperCase());

        model.addAttribute("newRoute", new Route());
        model.addAttribute("allCities", allCities);
        model.addAttribute("allRoutes", routeList);
        model.addAttribute("allRouteTypes", allRouteTypes);
        model.addAttribute("search", "search");

        return "jsp/route/route";
    }

    @RequestMapping(value = "/route.search", method = RequestMethod.POST)
    public String searchRouteType(@ModelAttribute("newRoute") Route route, Model model) {

        List<Route> routeList = routeServiceImpl.getRouteByRoute(route);
        List<City> cities = cityServiceImpl.getAllCity();
        List<RouteType> routeTypes = routeTypeServiceImpl.getAllRouteTypes();
        Map<Integer,String> allCities = new HashMap<Integer, String>();
        Map<Integer,String> allRouteTypes = new HashMap<Integer,String>();

        for (City city : cities)
            allCities.put(city.getId(), city.getCityName().toUpperCase());
        for (RouteType routeType : routeTypes)
            allRouteTypes.put(routeType.getId(),routeType.getRouteTypeName().toUpperCase());

        model.addAttribute("newRoute",new Route());
        model.addAttribute("allCities", allCities);
        model.addAttribute("allRoutes", routeList);
        model.addAttribute("allRouteTypes", allRouteTypes);

        return "jsp/route/route";
    }

    @RequestMapping(value = "/route.update", method = RequestMethod.POST)
    public String updateCity(@ModelAttribute("newRouteType") RouteType routeType, Model model) {

        return "redirect:/route.list";
    }
}