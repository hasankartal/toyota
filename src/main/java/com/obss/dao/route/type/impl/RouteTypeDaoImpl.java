package com.obss.dao.route.type.impl;

import com.obss.dao.route.type.RouteTypeDao;
import com.obss.model.route.type.RouteType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

/**
 * @author Hasan KARTAL
 * @since 29.08.2016.
 */
@Repository
public class RouteTypeDaoImpl implements RouteTypeDao{

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<RouteType> getAllRouteTypes() {
        Session session = getCurrentSession();
        TypedQuery<RouteType> query = session.createQuery("from RouteType", RouteType.class);
        return query.getResultList();
    }

    @Override
    public List<RouteType> getRouteTypeByName(String routeTypeName) {
        Session session = getCurrentSession();
        Query query = session.createQuery("SELECT routeType FROM RouteType routeType WHERE  routeType.routeTypeName LIKE CONCAT('%', ? , '%')");
        query.setParameter(0, routeTypeName);
        return query.getResultList();
    }

    @Override
    public RouteType getRouteTypeById(int id) {
        Session session = getCurrentSession();
        RouteType routeType = session.get(RouteType.class, id);
        return routeType;
    }

    @Override
    public void insertRouteType(RouteType routeType) {
        Session session = getCurrentSession();
        session.persist(routeType);
    }

    @Override
    public void deleteRouteType(int id) {
        Session session = getCurrentSession();
        RouteType routeType = (RouteType) session.get(RouteType.class, new Integer(id));
        if (routeType != null) {
            session.delete(routeType);
        }
    }

    @Override
    public void updateRouteType(RouteType routeType) {
        Session session = getCurrentSession();

       /* RouteType foundRouteType = getRouteTypeById(routeType.getId());
        if (foundRouteType != null) {
            session.getTransaction().begin();
            foundRouteType.setId(routeType.getId());
            foundRouteType.setCreateUid(routeType.getCreateUid());
            foundRouteType.setCreateDate(routeType.getCreateDate());
            foundRouteType.setLastUpdDate(new Date());
            foundRouteType.setLastUpdUid("sas");
            foundRouteType.setRouteTypeName(routeType.getRouteTypeName());
            session.getTransaction().commit();
        }
        */
        session.update(routeType);
    }
}