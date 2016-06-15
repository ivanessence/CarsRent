package it.academy.ivan.dao;

import it.academy.ivan.hibernate.HibernateSessionManager;
import org.hibernate.HibernateException;
import org.hibernate.Session;


import static it.academy.ivan.hibernate.HibernateUtil.*;
import static it.academy.ivan.hibernate.HibernateUtil.closeSession;

/**
 * Created by Ivan on 15.06.2016.
 */
public class AbstractDao<T> {

    protected T saveOrUpdate(T obj) {
        try {
            Session sess = currentSession();
            beginTransaction();
            sess.saveOrUpdate(obj);
            commitTransaction();
        } catch (HibernateException e) {
            rollbackTransaction();

        } finally {
            closeSession();
        }
        return obj;

    }
}

