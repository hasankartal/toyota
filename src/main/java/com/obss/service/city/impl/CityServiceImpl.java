package com.obss.service.city.impl;

import com.obss.dao.city.impl.CityDaoImpl;
import com.obss.model.city.City;
import com.obss.service.city.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Hasan KARTAL
 * @since 26.08.2016.
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDaoImpl cityDaoImpl;

    @Override
    @Transactional
    public List<City> getAllCity() {
        return cityDaoImpl.getAllCity();
    }


    @Override
    @Transactional
    public City getCityById(int id) {
        return cityDaoImpl.getCityById(id);
    }

    @Override
    @Transactional
    public List<City> getCityByName(String name) {
        String dene = "dene";
        return cityDaoImpl.getCityByName(name);
    }

    @Override
    @Transactional
    public void insertCity(City city) {
        cityDaoImpl.insertCity(city);
    }

    @Override
    @Transactional
    public void deleteCity(int id) {
        cityDaoImpl.deleteCity(id);
    }

    @Override
    @Transactional
    public void updateCity(City city) {
        cityDaoImpl.updateCity(city);
    }
}
