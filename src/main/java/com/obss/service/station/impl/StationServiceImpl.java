package com.obss.service.station.impl;

import com.obss.dao.station.impl.StationDaoImpl;
import com.obss.model.station.Station;
import com.obss.service.station.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Hasan
 * @since 27.09.2016.
 */
@Service
public class StationServiceImpl implements StationService {

    @Autowired
    StationDaoImpl stationDaoImpl;

    @Override
    @Transactional
    public List<Station> getAllStations() {
        return stationDaoImpl.getAllStation();
    }

    @Override
    @Transactional
    public Station getStationById(int id) {
        return stationDaoImpl.getStationById(id);
    }

    @Override
    @Transactional
    public List<Station> getStationByStation(Station station) {
        return stationDaoImpl.getStationByStation(station);
    }

    @Override
    @Transactional
    public void insertStation(Station station) {
        stationDaoImpl.insertStation(station);
    }

    @Override
    @Transactional
    public void deleteStation(int id) {
        stationDaoImpl.deleteStation(id);
    }

    @Override
    @Transactional
    public void updateStation(Station station) {
        stationDaoImpl.updateStation(station);
    }

    @Override
    @Transactional
    public Boolean hasRoute(int routeId) {
        return stationDaoImpl.hasRoute(routeId);
    }
}
