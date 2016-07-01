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
			System.out.println(sess.hashCode());
		beginTransaction();
		String hql = "From Cars";
		Query qu = sess.createQuery(hql);
		qu.setFirstResult(pg);
		qu.setMaxResults(4);
		list = qu.list();
	} catch (HibernateException e) {
		rollbackTransaction();
	}
		return list;

	}





}
