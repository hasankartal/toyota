package com.obss.service.login.impl;

import com.obss.dao.login.impl.LoginDaoImpl;
import com.obss.model.systemadminuser.SystemAdminUser;
import com.obss.service.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Hasan KARTAL
 * @since 25.08.2016.
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDaoImpl loginDaoImpl;

    @Override
    @Transactional
    public SystemAdminUser getSystemAdminUserById(int id) {
        return loginDaoImpl.getSystemAdminUserById(id);
    }

    @Override
    @Transactional
    public List<SystemAdminUser> getAllSystemAdminUser() {
        return loginDaoImpl.getAllSystemAdminUser();
    }

    @Override
    @Transactional
    public void insertSystemAdminUser(SystemAdminUser systemAdminUser) {
        loginDaoImpl.insertSystemAdminUser(systemAdminUser);
    }

}