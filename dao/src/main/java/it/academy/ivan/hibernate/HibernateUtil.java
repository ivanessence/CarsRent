package it.academy.ivan.hibernate;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static Logger logger = Logger.getLogger(HibernateUtil.class);
    private static final SessionFactory sessionFactory = buildSessionFactory();
    private static final ThreadLocal sessionThreadLocal = new ThreadLocal();
    private static final ThreadLocal transactionThreadLocal = new ThreadLocal();

    // Session factory initialization
    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();
//            configuration.setNamingStrategy(new CustomNamingStrategy());
            configuration.configure();
            StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
            serviceRegistryBuilder.applySettings(configuration.getProperties());
            ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
            return configuration.buildSessionFactory(serviceRegistry);
        }
        catch (HibernateException e) {
            logger.error("Configuration problem: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    /**
     * Get current Hibernate session or initialize it if it's null
     * @return Hibernate session instance
     */
    public static Session currentSession() {
        Session session = (Session) sessionThreadLocal.get();
        // Open a new Session, if this Thread has none yet
        try {
            if (session == null) {
                session = sessionFactory.openSession();
                sessionThreadLocal.set(session);
            }
        } catch (HibernateException e) {
            logger.error("Get current session error: " + e.getMessage());
        }
        return session;
    }

    /**
     * Close current Hibernate session
     */
    public static void closeSession() {
        Session session = (Session) sessionThreadLocal.get();
        sessionThreadLocal.set(null);
        try {
            if (session != null)
                session.close();
        } catch (HibernateException e) {
            logger.error("Close current session error: " + e.getMessage());
        }
    }

    /**
     * Begin Hibernate transaction
     */
    public static void beginTransaction() {
        Transaction tx = (Transaction) transactionThreadLocal.get();
        try {
            if (tx == null) {
                tx = currentSession().beginTransaction();
                transactionThreadLocal.set(tx);
            }
        } catch (HibernateException e) {
            logger.error("Begin transaction error: " + e.getMessage());
        }
    }

    /**
     * Commit Hibernate transaction
     */
    public static void commitTransaction() {
        Transaction tx = (Transaction) transactionThreadLocal.get();
        try {
            if (tx != null && !tx.wasCommitted() && !tx.wasRolledBack()) {
                tx.commit();
            }
            transactionThreadLocal.set(null);
        } catch (HibernateException e) {
            rollbackTransaction();
            logger.error("Commit transaction error: " + e.getMessage());
        }
    }

    /**
     * Rollback Hibernate transaction
     */
    public static void rollbackTransaction() {
        Transaction tx = (Transaction) transactionThreadLocal.get();
        try {
            transactionThreadLocal.set(null);
            if (tx != null && !tx.wasCommitted() && !tx.wasRolledBack()) {
                tx.rollback();
            }
        } catch (HibernateException e) {
            logger.error("Rollback transaction error: " + e.getMessage());
        } finally {
            closeSession();
        }
    }
}