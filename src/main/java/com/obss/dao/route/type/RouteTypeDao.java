package com.obss.dao.route.type;

import com.obss.model.route.type.RouteType;

import java.util.List;

/**
 * @author Hasan KARTAL
 * @since 29.08.2016.
 */
public interface RouteTypeDao {
    List<RouteType> getAllRouteTypes();
    List<RouteType> getRouteTypeByName(String routeTypeName);
    RouteType getRouteTypeById(int id);
    void insertRouteType(RouteType routeType);
    void deleteRouteType(int id);
    void updateRouteType(RouteType routeType);
}
