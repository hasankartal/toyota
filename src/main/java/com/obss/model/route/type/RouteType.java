package com.obss.model.route.type;

import com.obss.model.route.Route;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

/**
 * @author Hasan Kartal
 * @since 29.08.2016.
 */
@Entity
@Table(name = "route_type", catalog = "toyotaservice")
public class RouteType implements java.io.Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ROUTE_TYPE_ID")
    private int id;

    @NotNull
    @Column(name = "ROUTE_TYPE_NAME")
    private String routeTypeName;

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

    @OneToMany(mappedBy = "routeType")
    private Set<Route> routeRecords;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRouteTypeName() {
        return routeTypeName;
    }

    public void setRouteTypeName(String routeTypeName) {
        this.routeTypeName = routeTypeName;
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

    public Set<Route> getRouteRecords() {
        return routeRecords;
    }

    public void setRouteRecords(Set<Route> routeRecords) {
        this.routeRecords = routeRecords;
    }
}
