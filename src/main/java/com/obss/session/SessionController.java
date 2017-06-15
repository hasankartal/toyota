package com.obss.session;

import com.obss.model.systemadminuser.SystemAdminUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.enterprise.context.SessionScoped;

/**
 * Created by Hasan on 10.10.2016.
 */
@Controller
@SessionAttributes("personObj")
public class SessionController {

    @RequestMapping(value = "person-form", method = RequestMethod.GET)
    public ModelAndView personPage() {
        return new ModelAndView("person-page","person-entity",new SystemAdminUser());
    }

    @RequestMapping(value="/process-person")
    public ModelAndView processPerson(@ModelAttribute SystemAdminUser systemAdminUser) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("person-result-page");

        modelAndView.addObject("pers",systemAdminUser);
        modelAndView.addObject("personObj", systemAdminUser);
        return modelAndView;
    }
}
