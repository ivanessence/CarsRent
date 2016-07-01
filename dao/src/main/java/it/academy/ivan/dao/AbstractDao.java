package it.academy.ivan.dao;

import it.academy.ivan.entity.Cars;
import it.academy.ivan.hibernate.HibernateSessionManager;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;


import static it.academy.ivan.hibernate.HibernateUtil.*;
import static it.academy.ivan.hibernate.HibernateUtil.closeSession;

/**
 * Created by Ivan on 15.06.2016.
 */
public class AbstractDao<T> {

    protected T saveOrUpdate(T obj) {
        try {
            beginTransaction();
            currentSession().saveOrUpdate(obj);
            commitTransaction();
        } catch (HibernateException e) {
            rollbackTransaction();
        }
        return obj;

    }
    public void delete(T car) {
        try {
            Session sess = currentSession();
            System.out.println(sess.hashCode());
            beginTransaction();
            sess.delete(car);
            commitTransaction();
        } catch (HibernateException e) {
            rollbackTransaction();
        }
    }
}

