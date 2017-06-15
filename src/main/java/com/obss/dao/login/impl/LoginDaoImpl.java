package com.obss.dao.login.impl;

import java.util.*;
import javax.persistence.TypedQuery;

import com.obss.dao.login.LoginDao;
import com.obss.model.systemadminuser.SystemAdminUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Hasan KARTAL
 * @since 25.08.2016.
 */
@Repository
public class LoginDaoImpl implements LoginDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public SystemAdminUser getSystemAdminUserById(int id) {
        Session session = getCurrentSession();
        SystemAdminUser systemAdminUser = (SystemAdminUser) session.get(SystemAdminUser.class, id);
        return systemAdminUser;
    }

    @Override
    public List<SystemAdminUser> getAllSystemAdminUser() {
        Session session = getCurrentSession();
        TypedQuery<SystemAdminUser> query = session.createQuery("from SystemAdminUser", SystemAdminUser.class);
        return query.getResultList();
    }

    @Override
    public void insertSystemAdminUser(SystemAdminUser systemAdminUser) {
        Session session = getCurrentSession();
        session.persist(systemAdminUser);
    }

}