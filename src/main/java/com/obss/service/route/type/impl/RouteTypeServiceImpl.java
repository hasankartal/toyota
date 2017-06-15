package com.obss.service.route.type.impl;

import com.obss.dao.route.type.impl.RouteTypeDaoImpl;
import com.obss.model.route.type.RouteType;
import com.obss.service.route.type.RouteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Hasan KARTAL
 * @since 29.08.2016.
 */
@Service
public class RouteTypeServiceImpl implements RouteTypeService {

    @Autowired
    private RouteTypeDaoImpl routeTypeDaoImpl;

    @Override
    @Transactional
    public List<RouteType> getAllRouteTypes() {
        return routeTypeDaoImpl.getAllRouteTypes();
    }

    @Override
    @Transactional
    public List<RouteType> getRouteTypeByName(String routeTypeName) {
        return routeTypeDaoImpl.getRouteTypeByName(routeTypeName);
    }

    @Override
    @Transactional
    public RouteType getRouteTypeById(int id) {
        return routeTypeDaoImpl.getRouteTypeById(id);
    }

    @Override
    @Transactional
    public void insertRouteType(RouteType routeType) {
        routeTypeDaoImpl.insertRouteType(routeType);
    }

    @Override
    @Transactional
    public void deleteRouteType(int id) {
        routeTypeDaoImpl.deleteRouteType(id);
    }

    @Override
    @Transactional
    public void updateRouteType(RouteType routeType) {
        routeTypeDaoImpl.updateRouteType(routeType);
    }
}
