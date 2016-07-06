package it.academy.ivan.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import static it.academy.ivan.hibernate.HibernateUtil.*;

/**
 * Created by Ivan on 15.06.2016.
 */
@Repository
public class EventDao <T> implements AbstractDao<T> {
    public SessionFactory sessionFactory;

    @Autowired
    public EventDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session currentSession() {
        return  sessionFactory.openSession();
    }

    @Override
    public T saveOrUpdate(T obj) {
        try {
            Session session = currentSession();
            Transaction tr = session.beginTransaction();

            session.saveOrUpdate(obj);
            tr.commit();
        } catch (HibernateException e) {
            rollbackTransaction();
        }
        return obj;
    }

    @Override
    public void delete(T car) {
        try {
            Session session = currentSession();
            Transaction tr = session.beginTransaction();
            beginTransaction();
            session.delete(car);
            tr.commit();
        } catch (HibernateException e) {
            rollbackTransaction();
        }
    }
}
