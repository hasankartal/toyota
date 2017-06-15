package com.obss.model.station;

import com.obss.model.route.Route;
import com.obss.model.route.type.RouteType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author Hasan KARTAL
 * @since 27.09.2016.
 */
@Entity
@Table(name = "station", catalog = "toyotaservice")
public class Station implements java.io.Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "STATION_ID")
    private int id;

    @NotNull
    @Column(name = "STATION_NAME")
    private String stationName;

    @Transient
    private int routeId;

    @ManyToOne
    @JoinColumn(name = "ROUTE__ID", foreignKey = @ForeignKey(name = "FK_STATION_ROUTE_ID"))
    @NotNull
    private Route route;

    @NotNull
    @Column(name = "STATION_NO")
    private int stationNo;

    @NotNull
    @Column(name = "ARRIVAL_TIME")
    private String arrivalTime;

    @NotNull
    @Column(name = "DEPARTURE_TIME")
    private String departureTime;

    @NotNull
    @Column(name = "CREATE_UID")
    private String createUid;

    @NotNull
    @Column(name = "CREATE_DATE")
    private Date createDate;

    @NotNull
    @Column(name = "LASTUPD_UID")
    private String lastUpdUid;

    @NotNull
    @Column(name = "LASTUPD_DATE")
    private Date lastUpdDate;

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

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
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
