package com.obss.controller.route.type;

import com.obss.model.route.type.RouteType;
import com.obss.service.route.type.impl.RouteTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

/**
 * @author Hasan KARTAL
 * @since 29.08.2016.
 */
@Controller
public class RouteTypeController {

    @Autowired
    private RouteTypeServiceImpl routeTypeServiceImpl;

    @RequestMapping(value = "/route.type.list", method = RequestMethod.GET)
    public String getRouteTypeList(Model model) {
        List<RouteType> routeTypeList = routeTypeServiceImpl.getAllRouteTypes();
        model.addAttribute("newRouteType", new RouteType());
        model.addAttribute("allRouteTypes", routeTypeList);
        
        return "jsp/route/type/routetype";
    }

    @RequestMapping(value = "/route.type.get", method = RequestMethod.POST)
    public String getRouteType(@ModelAttribute("newRouteType") RouteType routeType) {

        if(routeType.getId() == 0){
            //new routeType,add it
            routeType.setCreateUid("asd");
            routeType.setCreateDate(new Date());
            routeType.setLastUpdUid("asd");
            routeType.setLastUpdDate(new Date());
            routeTypeServiceImpl.insertRouteType(routeType);
        } else {
            RouteType oldRouteType = routeTypeServiceImpl.getRouteTypeById(routeType.getId());
            routeType.setCreateDate(oldRouteType.getCreateDate());
            routeType.setCreateUid(oldRouteType.getCreateUid());
            routeType.setLastUpdUid("asd " + new Date());
            routeType.setLastUpdDate(new Date());
            routeTypeServiceImpl.updateRouteType(routeType);
        }
        return "redirect:/route.type.list";
    }

    @RequestMapping(value = "/route.type.delete{routeTypeId}", method = RequestMethod.GET)
    public String deleteRouteType(@RequestParam("routeTypeId") int id) {

        routeTypeServiceImpl.deleteRouteType(id);

        return "redirect:/route.type.list";
    }

    @RequestMapping(value = "/route.type.edit{routeTypeId}", method = RequestMethod.GET)
    public String editRouteType(@RequestParam("routeTypeId") int id, Model model) {

        model.addAttribute("newRouteType", routeTypeServiceImpl.getRouteTypeById(id));
        model.addAttribute("allRouteTypes", routeTypeServiceImpl.getAllRouteTypes());
        model.addAttribute("update", "update");

        return "jsp/route/type/routetype";
    }

    @RequestMapping(value = "/route.type.searchPage", method = RequestMethod.GET)
    public String searchPageRouteType(@ModelAttribute("newRouteType") RouteType routeType,Model model) {

        List<RouteType> routeTypeList = routeTypeServiceImpl.getAllRouteTypes();
        model.addAttribute("newRouteType", new RouteType());
        model.addAttribute("allRouteTypes", routeTypeList);
        model.addAttribute("search", "search");

        return "jsp/route/type/routetype";
    }

    @RequestMapping(value = "/route.type.search", method = RequestMethod.POST)
    public String searchRouteType(@ModelAttribute("newRouteType") RouteType routeType,Model model) {

        List<RouteType> routeTypeList = routeTypeServiceImpl.getRouteTypeByName(routeType.getRouteTypeName());
        model.addAttribute("newRouteType",new RouteType());
        model.addAttribute("allRouteTypes", routeTypeList);

        return "jsp/route/type/routetype";
    }

//    @RequestMapping(value = "/route.type.update", method = RequestMethod.POST)
//    public String updateCity(@ModelAttribute("newRouteType") RouteType routeType, Model model) {
//
//        routeType.setLastUpdDate(new Date());
//        routeType.setLastUpdUid("asdf");
//        routeType.setCreateDate(new Date());
//        routeType.setCreateUid("asdf");
//        routeTypeServiceImpl.updateRouteType(routeType);
//
//        return "redirect:/route.type.list";
//    }
}
