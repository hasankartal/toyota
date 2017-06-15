package com.obss.model.route;

import com.obss.model.city.City;
import com.obss.model.route.type.RouteType;
import org.hibernate.annotations.ColumnDefault;

import javax.enterprise.inject.Default;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;

/**
 * @author Hasan Kartal
 * @since 29.08.2016.
 */
@Entity
@Table(name = "route", catalog = "toyotaservice")
public class Route implements java.io.Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ROUTE_ID")
    private int id;

    @NotNull
    @Column(name = "ROUTE_NAME")
    private String routeName;

    @Transient
    private int cityId;

    //One tarafı
    @ManyToOne
    @JoinColumn(name = "CITY_ID", foreignKey = @ForeignKey(name = "FK_ROUTE_CITY_ID"))
    @NotNull
    private City city;

    @Transient
    private int routeTypeId;

    @ManyToOne
    @JoinColumn(name = "ROUTE_TYPE_ID", foreignKey = @ForeignKey(name = "FK_ROUTE_ROUTE_TYPE_ID"))
    @NotNull
    private RouteType routeType;

    @NotNull
    @Column(name = "TOT_DURATION")
    private Double totalDuration;

    @NotNull
    @Column(name = "PERON_NO")
    private Double peronNo;

    @NotNull
    @Column(name = "VEHICLE_TYPE")
    private Double vehicleType;

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

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public int getRouteTypeId() {
        return routeTypeId;
    }

    public void setRouteTypeId(int routeTypeId) {
        this.routeTypeId = routeTypeId;
    }

    public RouteType getRouteType() {
        return routeType;
    }

    public void setRouteType(RouteType routeType) {
        this.routeType = routeType;
    }

    public Double getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(Double totalDuration) {
        this.totalDuration = totalDuration;
    }

    public Double getPeronNo() {
        return peronNo;
    }

    public void setPeronNo(Double peronNo) {
        this.peronNo = peronNo;
    }

    public Double getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(Double vehicleType) {
        this.vehicleType = vehicleType;
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