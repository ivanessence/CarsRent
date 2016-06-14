package it.academy.ivan.dao;


import java.sql.PreparedStatement;

import java.util.List;

import it.academy.ivan.entity.Cars;
import it.academy.ivan.hibernate.HibernateSessionManager;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class DAOCars implements InterfaceDAO<Cars> {

	static PreparedStatement preparedStatement = null;
	protected Transaction trans;


	public DAOCars() {

	}

	@Override
	public void add(Cars car) {

		Session sess = HibernateSessionManager.getSessionFactory().openSession();
		trans = sess.beginTransaction();
		sess.saveOrUpdate(car);
		sess.update(car);
		trans.commit();
	}

	@Override
	public List<Cars> getFromDb() {
		Session sess = HibernateSessionManager.getSessionFactory().openSession();
		trans = sess.beginTransaction();
		String hql = "From Cars";
		Query qu = sess.createQuery(hql);
		qu.setFirstResult(0);
		qu.setMaxResults(4);
		List<Cars> list = qu.list();

		return list;

	}

	@Override
	public void delete(Cars car) {
		Session sess = HibernateSessionManager.getSessionFactory().openSession();
		trans = sess.beginTransaction();
		String hql = "delete Cars where car_id = :car_id";
		Query qu = sess.createQuery(hql);
		qu.setParameter("car_id", car.getCar_id());
		qu.executeUpdate();
		trans.commit();
	}


}
