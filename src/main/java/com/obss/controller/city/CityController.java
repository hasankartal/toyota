package com.obss.controller.city;

import com.obss.model.city.City;
import com.obss.service.city.impl.CityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Hasan KARTAL
 * @since 26.08.2016.
 */
@Controller
public class CityController {

    @Autowired
    private CityServiceImpl cityServiceImpl;

    @RequestMapping(value = "/city.list", method = RequestMethod.GET)
    public String getCityList(Model model) {
        System.out.println("...City List...");
        List<City> cityList = cityServiceImpl.getAllCity();
        model.addAttribute("newCity",new City());
        model.addAttribute("allCities", cityList);

        return "jsp/city/city";
    }

    //For add and update person both
    @RequestMapping(value = "/city.get", method = RequestMethod.POST)
    public String getCity(@ModelAttribute("newCity") City city) {

        System.out.println("...addCity...");
        if(city.getId() == 0){
            //new city,add it
            city.setCreateUid("asd");
            city.setCreateDate(new Date());
            city.setLastUpdUid("asd");
            city.setLastUpdDate(new Date());
            this.cityServiceImpl.insertCity(city);
        }else{
            City oldCity = cityServiceImpl.getCityById(city.getId());
            city.setCreateDate(oldCity.getCreateDate());
            city.setCreateUid(oldCity.getLastUpdUid());
            city.setLastUpdDate(new Date());
            city.setLastUpdUid("asd " + new Date());
            //existing city,call update
            cityServiceImpl.updateCity(city);
        }
        return "redirect:/city.list";
    }

    @RequestMapping(value = "/city.delete{cityId}", method = RequestMethod.GET)
    public String deleteCity(@RequestParam("cityId") int id) {

        cityServiceImpl.deleteCity(id);

        return "redirect:/city.list";
    }
    
    @RequestMapping(value = "/city.edit{cityId}", method = RequestMethod.GET)
    public String editCity(@RequestParam("cityId") int id, Model model) {

        System.out.println("...editCity ...");

        model.addAttribute("newCity", cityServiceImpl.getCityById(id));
        model.addAttribute("allCities", cityServiceImpl.getAllCity());
        model.addAttribute("update", "update");

        return "jsp/city/city";
    }

    @RequestMapping(value = "/city.update", method = RequestMethod.POST)
    public String updateCity(@ModelAttribute("newCity") City city) {

        System.out.println("...update person...");
        city.setLastUpdDate(new Date());
        city.setLastUpdUid("asdf");
        city.setCreateDate(new Date());
        city.setCreateUid("asdf");
        cityServiceImpl.updateCity(city);

        return "redirect:/city.list";
    }

    @RequestMapping(value = "/city.searchPage", method = RequestMethod.GET)
    public String searchPageCity(@ModelAttribute("newCity") City city,Model model) {

        List<City> cityList = cityServiceImpl.getAllCity();
        model.addAttribute("newCity",new City());
        model.addAttribute("allCities", cityList);
        model.addAttribute("search", "search");

        return "jsp/city/city";
    }

    @RequestMapping(value = "/city.search", method = RequestMethod.POST)
    public String searchCityDene(@ModelAttribute("newCity") City city,Model model) {

        List<City> cityList = cityServiceImpl.getCityByName(city.getCityName());
        model.addAttribute("newCity",new City());
        model.addAttribute("allCities", cityList);

        return "jsp/city/city";
    }
}