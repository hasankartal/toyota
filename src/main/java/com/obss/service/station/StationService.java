package com.obss.service.station;

import com.obss.model.station.Station;

import java.util.List;

/**
 * Created by Hasan on 27.09.2016.
 */
public interface StationService {
    List<Station> getAllStations();
    Station getStationById(int id);
    List<Station> getStationByStation(Station station);
    void insertStation(Station station);
    void deleteStation(int id);
    void updateStation(Station station);
    Boolean hasRoute(int routeId);
}
