package com.obss.dao.login;

import com.obss.model.systemadminuser.SystemAdminUser;

import java.util.List;

/**
 * @author Hasan KARTAL
 * @since 25.08.2016.
 */
public interface LoginDao {
    SystemAdminUser getSystemAdminUserById(int id);
    List<SystemAdminUser> getAllSystemAdminUser();
    void insertSystemAdminUser(SystemAdminUser systemAdminUser);
}
