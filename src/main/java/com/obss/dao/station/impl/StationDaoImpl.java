package com.obss.dao.station.impl;

import com.obss.dao.station.StationDao;
import com.obss.model.city.City;
import com.obss.model.route.Route;
import com.obss.model.station.Station;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Hasan on 27.09.2016.
 */
@Repository
public class StationDaoImpl implements StationDao{

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Station> getAllStation() {
        Session session = getCurrentSession();
        TypedQuery<Station> query = session.createQuery("from Station ", Station.class);
        return query.getResultList();
    }

    @Override
    public List<Station> getStationByStation(Station station) {
        Session session = getCurrentSession();
        Query query = session.createQuery("SELECT station FROM Station station WHERE  station.route.id = ? " +
                "and station.stationName LIKE CONCAT('%', ? , '%') " +
                "and station.stationNo = ? " +
                "and station.arrivalTime LIKE CONCAT('%', ? , '%') " +
                "and station.departureTime LIKE CONCAT('%', ? , '%') ");
        query.setParameter(0, station.getRouteId());
        query.setParameter(1, station.getStationName());
        query.setParameter(2, station.getStationNo());
        query.setParameter(3, station.getArrivalTime());
        query.setParameter(4, station.getDepartureTime());
        return query.getResultList();
    }

    @Override
    public Station getStationById(int id) {
        Session session = getCurrentSession();
        Station station = session.get(Station.class, id);
        return station;
    }

    @Override
    public void insertStation(Station station) {
        Session session = getCurrentSession();
        session.persist(station);
    }

    @Override
    public void deleteStation(int id) {
        Session session = getCurrentSession();
        Station station = (Station) session.get(Station.class, new Integer(id));
        System.out.println(station);
        if (station != null) {
            session.delete(station);
        }
    }

    @Override
    public void updateStation(Station station) {
        Session session = getCurrentSession();
        session.update(station);
    }

    @Override
    public Boolean hasRoute(int routeId) {
        Session session = getCurrentSession();
        TypedQuery<Station> query = session.createQuery("from Station ", Station.class);
        List<Station> stationList = query.getResultList();
        for(Station station : stationList) {
            if (station.getRoute().getId() == routeId) return true;
        }
        return false;
    }
}
