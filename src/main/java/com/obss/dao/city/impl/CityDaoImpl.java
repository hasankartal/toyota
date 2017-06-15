package com.obss.dao.city.impl;

import com.obss.dao.city.CityDao;
import com.obss.model.city.City;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author Hasan KARTAL
 * @since 26.08.2016.
 */
@Repository
public class CityDaoImpl implements CityDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<City> getAllCity() {
        Session session = getCurrentSession();
        TypedQuery<City> query = session.createQuery("from City", City.class);
        return query.getResultList();
    }

    @Override
    public City getCityById(int id) {
        Session session = getCurrentSession();
        City city = session.get(City.class, id);
        return city;
    }

    @Override
    public List<City> getCityByName(String cityName) {
        Session session = getCurrentSession();
//        Query query = session.createQuery("SELECT city FROM City city WHERE  city.cityName = ?");
        Query query = session.createQuery("SELECT city FROM City city WHERE  city.cityName LIKE CONCAT('%', ? , '%')");
        query.setParameter(0, cityName);
        return query.getResultList();
    }

    @Override
    public void insertCity(City city) {
        Session session = getCurrentSession();
        session.persist(city);
    }

    public void deleteCity(int id) {
        Session session = getCurrentSession();
        City city = (City) session.get(City.class, new Integer(id));
        System.out.println(city);
        if (city != null) {
            session.delete(city);
        }
    }
    @Override
    public void updateCity(City city) {
        Session session = getCurrentSession();
        session.update(city);
    }
}
