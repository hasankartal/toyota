package com.obss.service.route;

import com.obss.model.route.Route;

import java.util.List;

/**
 * @author Hasan KARTAL
 * @since 29.08.2016.
 */
public interface RouteService {
    List<Route> getAllRoutes();
    List<Route> getRouteByRoute(Route route);
    Route getRouteById(int id);
    void insertRoute(Route route);
    void deleteRoute(int id);
    void updateRoute(Route route);
}
