package com.obss.controller.station;

import com.obss.dao.station.StationDao;
import com.obss.model.city.City;
import com.obss.model.route.Route;
import com.obss.model.route.type.RouteType;
import com.obss.model.station.Station;
import com.obss.model.station.StationDeneme;
import com.obss.service.route.impl.RouteServiceImpl;
import com.obss.service.station.StationService;
import com.obss.service.station.impl.StationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Hasan KARTAL
 * @since 28.09.2016.
 */
@Controller
public class StationController {

    @Autowired
    private StationServiceImpl stationServiceImpl;

    @Autowired
    private RouteServiceImpl routeServiceImpl;

    @RequestMapping(value = "station.list", method = RequestMethod.GET)
    public String getRouteList(Model model) {
        List<Station> stationList = stationServiceImpl.getAllStations();

        List<Route> routeList = routeServiceImpl.getAllRoutes();
        Map<Integer,String> routesMap = new HashMap<Integer,String>();

        for (Route route : routeList)
            routesMap.put(route.getId(),route.getRouteName().toUpperCase());

        model.addAttribute("newStation", new StationDeneme());
        model.addAttribute("allStations", stationList);
        model.addAttribute("routesMap",routesMap);
        return "jsp/station/station";
    }

    @RequestMapping(value = "/station.get", method = RequestMethod.POST)
    public String getRoute(@ModelAttribute("newStation") Station station) {

        Route route = routeServiceImpl.getRouteById(station.getRouteId());
        if (station.getId() == 0) {
            station.setCreateUid("asd");
            station.setCreateDate(new Date());
            station.setLastUpdUid("asd");
            station.setLastUpdDate(new Date());
            station.setRoute(route);
            stationServiceImpl.insertStation(station);
        } else {
            Station oldStation = stationServiceImpl.getStationById(station.getId());
            station.setCreateUid(oldStation.getCreateUid());
            station.setCreateDate(oldStation.getCreateDate());
            station.setLastUpdUid("asd :" + new Date());
            station.setLastUpdDate(new Date());
            station.setRoute(route);
            stationServiceImpl.updateStation(station);
        }
        return "redirect:/station.list";
    }

    @RequestMapping(value = "/station.edit{stationId}", method = RequestMethod.GET)
    public String editStation(@ModelAttribute("stationId") int id,Model model) {

        List<Station> stationList = stationServiceImpl.getAllStations();
        List<Route> routeList = routeServiceImpl.getAllRoutes();
        Map<Integer,String> routesMap = new HashMap<Integer,String>();

        for (Route route : routeList)
            routesMap.put(route.getId(),route.getRouteName().toUpperCase());

        model.addAttribute("newStation", stationServiceImpl.getStationById(id));
        model.addAttribute("allStations", stationList);
        model.addAttribute("routesMap",routesMap);
        model.addAttribute("update","update");

        return "jsp/station/station";
    }

    @RequestMapping(value = "/station.delete{stationId}", method = RequestMethod.GET)
    public String deleteStation(@ModelAttribute("stationId") int id,Model model) {

        stationServiceImpl.deleteStation(id);
        return "redirect:/station.list";
    }

}
