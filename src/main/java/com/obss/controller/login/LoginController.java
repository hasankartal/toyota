package com.obss.controller.login;

import com.obss.model.systemadminuser.SystemAdminUser;
import com.obss.service.login.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Hasan KARTAL
 * @since 26.08.2016.
 */
@Controller
public class LoginController {

    @Autowired
    private LoginServiceImpl loginServiceImpl;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getPersonList(Model model) {
        List<SystemAdminUser> personList = loginServiceImpl.getAllSystemAdminUser();
        model.addAttribute("newEnter", new SystemAdminUser());
        model.addAttribute("allPersons", personList);
        return "jsp/login/login";
    }

    @RequestMapping(value = "/person.add", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("newPerson") SystemAdminUser systemAdminUser, Model model) {
        loginServiceImpl.insertSystemAdminUser(systemAdminUser);
        return "redirect:/admin.list";
    }

    @RequestMapping(value = "/login.get", method = RequestMethod.POST)
    public String getLogin(@ModelAttribute("newEnter") SystemAdminUser systemAdminUser, Model model) {
        List<SystemAdminUser> systemAdminUsers = loginServiceImpl.getAllSystemAdminUser();
        for (SystemAdminUser systemAdmin : systemAdminUsers) {
            if(systemAdminUser.getUserName().equals(systemAdmin.getUserName()) && systemAdminUser.getPassword().equals(systemAdmin.getPassword()) ) {

                return "redirect:/menu.list";
            }
        }
        return "redirect:/login";
    }
}
