package com.obss.validator.route;

import com.obss.model.route.Route;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Hasan on 5.10.2016.
 */
@Component
public class RouteValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Route route = (Route) target;

//        if (route.getRouteName() == null || route.getRouteName().equals(" ")) {
//            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "routeName", "Route Name zorunludur.");
//            errors.rejectValue("routeName", "Route Name zorunludur.");
//        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "routeName", "Route name zorunludur.");

    }

}
