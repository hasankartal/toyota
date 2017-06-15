package com.obss.model.city;

import com.obss.model.route.Route;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

/**
 * @author Hasan KARTAL
 * @since 26.08.2016.
 */
@Entity
@Table(name = "city", catalog = "toyotaservice")
public class City implements java.io.Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CITY_ID")
    private int id;

    @NotNull
    @Column(name = "CITY_NAME")
    private String cityName;

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

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
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