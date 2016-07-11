package it.academy.ivan.dao;

import it.academy.ivan.entity.Client;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import java.util.List;



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

        }
        return obj;
    }

    @Override
    public void delete(T car) {
        try {
            Session session = currentSession();
            Transaction tr = session.beginTransaction();
            session.delete(car);
            tr.commit();
        } catch (HibernateException e) {

        }
    }

    @Override
    public List<T> getFromDb() {

        List<T> list = null;
        try {
            Session session = currentSession();
            Transaction tr = session.beginTransaction();
            String hql = "From Client";
            Query qu = session.createQuery(hql);
            list = qu.list();
        } catch (HibernateException e) {

        }
        return list;

    }

    @Override
    public List<T> show(Integer pg) {
        List<T> list = null;
        try {
            Session session = currentSession();
            Transaction tr = session.beginTransaction();
            String hql = "From Cars";
            Query qu = session.createQuery(hql);
            qu.setFirstResult(pg);
            qu.setMaxResults(4);
            list = qu.list();
        } catch (HibernateException e) {

        }
        return list;
    }
}
