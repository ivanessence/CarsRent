package it.academy.ivan.dao;


import it.academy.ivan.entity.Client;
import it.academy.ivan.hibernate.HibernateSessionManager;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class ClientDAOImpl implements InterfaceDAO<Client> {

    protected Transaction trans;

    public ClientDAOImpl() {

    }

    public void add(Client client) { //регистрация

        Session sess = HibernateSessionManager.getSessionFactory().openSession();
        trans = sess.beginTransaction();
        sess.saveOrUpdate(client);
        sess.update(client);
        trans.commit();
    }

    public boolean isAuthorized(String login, String password) {
        boolean isLogIn = false;

        Session sess = HibernateSessionManager.getSessionFactory().openSession();
        trans = sess.beginTransaction();
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
        Session sess = HibernateSessionManager.getSessionFactory().openSession();
        trans = sess.beginTransaction();
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
        Session sess = HibernateSessionManager.getSessionFactory().openSession();
        trans = sess.beginTransaction();
        String hql = "From Client";
        Query qu = sess.createQuery(hql);
        qu.setFirstResult(0);
        qu.setMaxResults(2);
        List<Client> list = qu.list();

        return list;

    }

    @Override
    public void delete(Client object) {

    }


}
