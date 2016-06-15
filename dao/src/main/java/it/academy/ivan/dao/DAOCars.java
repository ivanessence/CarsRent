package it.academy.ivan.dao;



import java.util.List;

import it.academy.ivan.entity.Cars;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;


import static it.academy.ivan.hibernate.HibernateUtil.*;
import static it.academy.ivan.hibernate.HibernateUtil.closeSession;


public class DAOCars implements InterfaceDAO<Cars> {


	public DAOCars() {

	}


	@Override
	public List<Cars> getFromDb() {
		return null;
	}


	public List<Cars> getFromDbs(Integer pg) {
		List<Cars> list = null;
		try{
		Session sess = currentSession();
		beginTransaction();
		String hql = "From Cars";
		Query qu = sess.createQuery(hql);
		qu.setFirstResult(pg);
		qu.setMaxResults(4);
		list = qu.list();
	} catch (HibernateException e) {
		rollbackTransaction();

	} finally {
		closeSession();
	}
		return list;

	}

	@Override
	public void delete(Cars car) {
		try {
		Session sess = currentSession();
		beginTransaction();
		String hql = "delete Cars where car_id = :car_id";
		Query qu = sess.createQuery(hql);
		qu.setParameter("car_id", car.getCar_id());
		qu.executeUpdate();
		commitTransaction();
	} catch (HibernateException e) {
		rollbackTransaction();

	} finally {
		closeSession();
	}
	}


}
