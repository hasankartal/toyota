package com.obss.dao.station;

import com.obss.model.route.Route;
import com.obss.model.station.Station;

import java.util.List;

/**
 * Created by Hasan on 27.09.2016.
 */
public interface StationDao {
    List<Station> getAllStation();
    Station getStationById(int id);
    List<Station> getStationByStation(Station station);
    void insertStation(Station station);
    void deleteStation(int id);
    void updateStation(Station station);
    Boolean hasRoute(int routeId);
}
