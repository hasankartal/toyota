package com.obss.service.route.impl;

import com.obss.dao.route.impl.RouteDaoImpl;
import com.obss.dao.route.type.impl.RouteTypeDaoImpl;
import com.obss.model.route.Route;
import com.obss.service.route.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Hasan KARTAL
 * @since 29.08.2016.
 */
@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteDaoImpl routeDaoImpl;

    @Override
    @Transactional
    public List<Route> getAllRoutes() {
        return routeDaoImpl.getAllRoutes();
    }

    @Override
    @Transactional
    public List<Route> getRouteByRoute(Route route) {
        return routeDaoImpl.getRouteByRoute(route);
    }

    @Override
    @Transactional
    public Route getRouteById(int id) {
        return routeDaoImpl.getRouteById(id) ;
    }

    @Override
    @Transactional
    public void insertRoute(Route route) {
        routeDaoImpl.insertRoute(route);
    }

    @Override
    @Transactional
    public void deleteRoute(int id) {
        routeDaoImpl.deleteRoute(id);
    }

    @Override
    @Transactional
    public void updateRoute(Route route) {
        routeDaoImpl.updateRoute(route);
    }
}