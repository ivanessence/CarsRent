package it.academy.ivan.dao;


import it.academy.ivan.entity.Client;

import it.academy.ivan.hibernate.HibernateSessionManager;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

import static it.academy.ivan.hibernate.HibernateUtil.*;

public class ClientDAOImpl implements InterfaceDAO<Client> {

    public ClientDAOImpl() {

    }

    public boolean isAuthorized(String login, String password) {
        boolean isLogIn = false;

        Session sess = currentSession();
        System.out.println(sess.hashCode());
        beginTransaction();
        String hql = "Select login From Client WHERE login = :login";
        String sql = " from Client u where u.login=:lg and u.password=:pass";
        Query query = sess.createQuery(sql);
        query.setParameter("lg", login);
        query.setParameter("pass", password);
        List<Client> list = query.list();
        if (list.size() > 0) {
            isLogIn = true;
        }

        return isLogIn;
    }

    public ClientType checkAccessLevel(String login) {
        ClientType userType = null;
        Session sess = currentSession();
        System.out.println(sess.hashCode());
        beginTransaction();
        String hql = "Select role From Client WHERE login = :login";
        Query qu = sess.createQuery(hql);
        qu.setParameter("login", login);

        Integer res = (Integer) qu.uniqueResult();

        if (0 == res) {
            userType = ClientType.USER;
        } else {
            userType = ClientType.ADMINISTRATOR;
        }

        return userType;
    }

    public List<Client> getFromDb() {
        List<Client> list = null;
        try {
            Session sess = currentSession();
            beginTransaction();
            String hql = "From Client";
            Query qu = sess.createQuery(hql);
            list = qu.list();
        } catch (HibernateException e) {
            rollbackTransaction();
        }
        return list;

    }



}
