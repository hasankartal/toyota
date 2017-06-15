package com.obss.controller.personel.mainScreen;

import com.obss.model.city.City;
import com.obss.model.route.Route;
import com.obss.model.route.type.RouteType;
import com.obss.service.city.CityService;
import com.obss.service.route.RouteService;
import com.obss.service.route.type.RouteTypeService;
import javafx.scene.transform.Rotate;
import org.hibernate.annotations.AnyMetaDef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.Id;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Hasan
 * @since  26.09.2016.
 */
@Controller
public class MainScreenController {

    @Autowired
    CityService cityService;

    @Autowired
    RouteService routeService;

    @Autowired
    RouteTypeService routeTypeService;

    @RequestMapping(value = {"/personel.list"}, method = RequestMethod.GET)
    public String homePage(Model model) {


        Map<Integer, String > cities = new HashMap<Integer, String>();
        List<City> allCity = cityService.getAllCity();

        for (City city : allCity ) {
            cities.put(city.getId(),city.getCityName());
        }
        model.addAttribute("newRoute", new Route());
        model.addAttribute("title","Personel Ana Ekranı");
        model.addAttribute("citiesMap", cities);

        return "jsp/personel/main/personel";
    }

    @RequestMapping(value = "/personel.get", method = RequestMethod.POST)
    public String processAddNewProductForm(@ModelAttribute("newRoute") Route route,Model model) {
//         productService.addProduct(productToBeAdded);

        System.out.println("Route : " + route.getId()+ " ");
 //       System.out.println("City : " + route.getCity().getId()+ " ");
        return "redirect:/personel.list";
    }

    @RequestMapping(value = "/personel.deneme", method = RequestMethod.GET)
    public String getCityList(Model model) {
        model.addAttribute("title","Personel Ana Ekranı");

        return "jsp/personel/main/mainScreen";
    }
}