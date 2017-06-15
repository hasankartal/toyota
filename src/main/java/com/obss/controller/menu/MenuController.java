package com.obss.controller.menu;

import com.obss.model.city.City;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.awt.*;
import java.util.Date;
import java.util.List;

/**
 * @author Hasan KARTAL
 * @since 29.08.2016.
 */
@Controller
public class MenuController {

    @RequestMapping(value = "/menu.list", method = RequestMethod.GET)
    public String getCityList(Model model) {

        return "jsp/menu/menu";
    }

    @RequestMapping(value = "/menu.get", method = RequestMethod.POST)
    public String getCity(@ModelAttribute("newButton")Button button, Model model) {

        return "redirect:/city.list";
    }

}
