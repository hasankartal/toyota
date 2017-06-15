package com.obss.controller;

import com.obss.model.Personel;
import com.obss.model.city.City;
import com.obss.model.route.Route;
import com.obss.model.route.type.RouteType;
import com.obss.service.city.CityService;
import com.obss.service.route.RouteService;
import com.obss.service.route.type.RouteTypeService;
import org.hibernate.annotations.SortComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Hasan on 27.09.2016.
 */

@Controller
public class DenemController {

    @Autowired
    CityService cityService;

    @Autowired
    RouteService routeService;

    @Autowired
    RouteTypeService routeTypeService;

    @RequestMapping(value = {"/denemee.list"}, method = RequestMethod.GET)
    public String homePage(Model model) {

        Map<Integer, String > cities = new HashMap<Integer, String>();
        List<City> allCity = cityService.getAllCity();

        for (City city : allCity ) {
            cities.put(city.getId(),city.getCityName());
        }
        Map<Integer, String > routeTypesMap = new HashMap<Integer, String>();

        model.addAttribute("newPersonel", new Personel());
        model.addAttribute("title","Personel Ana Ekranı");
        model.addAttribute("citiesMap", cities);
        model.addAttribute("routeTypesMap",routeTypesMap);

        return "jsp/personel/main/denem";
    }

    @RequestMapping(value = "/denemee.get", method = RequestMethod.POST)
    public String processAddNewProductForm(@ModelAttribute("newPersonel")Personel personel, Model model) {
//         productService.addProduct(productToBeAdded);
        City city = cityService.getCityById(personel.getCityId());
        System.out.println("City: " + city.getCityName() + " ");

        Map<Integer, String > routeTypesMap = new HashMap<Integer, String>();
        List<RouteType> allRouteTypes = routeTypeService.getAllRouteTypes();

        for (RouteType routeType : allRouteTypes ) {
            routeTypesMap.put(routeType.getId(),routeType.getRouteTypeName());
        }
        model.addAttribute("newPersonel",new Personel());
        model.addAttribute("routeTypesMap",routeTypesMap);
        //       System.out.println("City : " + route.getCity().getId()+ " ");
//        return "redirect:/denemee.list";


        Map<Integer, String > cities = new HashMap<Integer, String>();
        List<City> allCity = cityService.getAllCity();
        model.addAttribute("citiesMap", cities);

        for (City cityq : allCity ) {
            cities.put(cityq.getId(),cityq.getCityName());
        }

        return "jsp/personel/main/denem";
    }

}
