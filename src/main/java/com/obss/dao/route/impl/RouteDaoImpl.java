package com.obss.dao.route.impl;

import com.obss.dao.route.RouteDao;
import com.obss.model.route.Route;
import com.obss.model.route.type.RouteType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author Hasan KARTAL
 * @since 29.08.2016.
 */
@Repository
public class RouteDaoImpl implements RouteDao{

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Route> getAllRoutes() {
        Session session = getCurrentSession();
        TypedQuery<Route> query = session.createQuery("from Route", Route.class);
        return query.getResultList();
    }

    @Override
    public List<Route> getRouteByRoute(Route route) {
        Session session = getCurrentSession();
        Query query = session.createQuery("SELECT route FROM Route route WHERE  route.city.id = ? " +
                "and route.routeType.id = ? " +
                "and route.routeName LIKE CONCAT('%', ? , '%') " +
//                "and (route.totalDuration = ? || route.totalDuration is null) " +
//                "and (route.peronNo = ? || route.peronNo is null) " +
                "and (route.vehicleType = ? or route.vehicleType IS NULL)" );
        query.setParameter(0, route.getCityId());
        query.setParameter(1, route.getRouteTypeId());
        query.setParameter(2, route.getRouteName());
//        query.setParameter(3, route.getTotalDuration());
//        query.setParameter(4, route.getPeronNo());
        query.setParameter(3, route.getVehicleType());
        return query.getResultList();
    }

    @Override
    public Route getRouteById(int id) {
        Session session = getCurrentSession();
        Route route = session.get(Route.class,id);
        return route;
    }

    @Override
    public void insertRoute(Route route) {
        Session session = getCurrentSession();
        session.persist(route);
    }

    @Override
    public void deleteRoute(int id) {
        Session session = getCurrentSession();
        Route route = session.get(Route.class,new Integer(id));
        if (route != null) {
            session.delete(route);
        }
    }

    @Override
    public void updateRoute(Route route) {
        Session session = getCurrentSession();
        session.update(route);
    }
}
