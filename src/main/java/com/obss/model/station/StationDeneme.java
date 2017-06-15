package com.obss.model.station;

import com.obss.model.route.Route;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Hasan on 28.09.2016.
 */


    /**
     * @author Hasan KARTAL
     * @since 27.09.2016.
     */
    public class StationDeneme implements java.io.Serializable {

        private int id;

        private String stationName;

        private Route route;

        private int routeId;

        private int stationNo;

        private String arrivalTime;

        private String departureTime;

        private String createUid;

        private Date createDate;

        private String lastUpdUid;

        private Date lastUpdDate;

        public int getRouteId() {
            return routeId;
        }

        public void setRouteId(int routeId) {
            this.routeId = routeId;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getStationName() {
            return stationName;
        }

        public void setStationName(String stationName) {
            this.stationName = stationName;
        }

        public Route getRoute() {
            return route;
        }

        public void setRoute(Route route) {
            this.route = route;
        }

        public int getStationNo() {
            return stationNo;
        }

        public void setStationNo(int stationNo) {
            this.stationNo = stationNo;
        }

        public String getArrivalTime() {
            return arrivalTime;
        }

        public void setArrivalTime(String arrivalTime) {
            this.arrivalTime = arrivalTime;
        }

        public String getDepartureTime() {
            return departureTime;
        }

        public void setDepartureTime(String departureTime) {
            this.departureTime = departureTime;
        }

        public String getCreateUid() {
            return createUid;
        }

        public void setCreateUid(String createUid) {
            this.createUid = createUid;
        }

        public Date getCreateDate() {
            return createDate;
        }

        public void setCreateDate(Date createDate) {
            this.createDate = createDate;
        }

        public String getLastUpdUid() {
            return lastUpdUid;
        }

        public void setLastUpdUid(String lastUpdUid) {
            this.lastUpdUid = lastUpdUid;
        }

        public Date getLastUpdDate() {
            return lastUpdDate;
        }

        public void setLastUpdDate(Date lastUpdDate) {
            this.lastUpdDate = lastUpdDate;
        }
    }

