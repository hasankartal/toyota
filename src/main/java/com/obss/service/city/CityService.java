package com.obss.service.city;


import com.obss.model.city.City;

import java.util.List;

/**
 * @author Hasan KARTAL
 * @since 26.08.2016.
 */
public interface CityService {
    List<City> getAllCity();
    City getCityById(int id);
    List<City> getCityByName(String name);
    void insertCity(City city);
    void deleteCity(int id);
    void updateCity(City city);
}
