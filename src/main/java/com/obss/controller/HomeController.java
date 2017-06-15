package com.obss.controller;

import com.obss.model.systemadminuser.SystemAdminUser;
import com.obss.service.login.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Hasan KARTAL
 * @since 25.08.2016.
 */
@Controller
public class HomeController {

    @Autowired
    private LoginServiceImpl loginServiceImpl;

    @RequestMapping(value = "/")
    public String home(ModelMap model) {
        model.addAttribute("message", "Hello Spring  Framework!");
        return "test";
    }

    @RequestMapping(value = "/deneme")
    public String deneme(ModelMap model) {
        model.addAttribute("message", "Hello Deneme  Framework!");
        return "jsp/deneme";
    }

    @RequestMapping(value = "/tests")
    public String message(ModelMap model) {
        SystemAdminUser systemAdminUser = loginServiceImpl.getSystemAdminUserById(1);
        String message = systemAdminUser.getLastName();
        model.addAttribute("message", message);
        return "jsp/tests";
    }

}
