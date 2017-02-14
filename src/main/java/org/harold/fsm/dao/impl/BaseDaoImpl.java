package org.harold.fsm.dao.impl;

import org.harold.fsm.dao.BaseDao;
import org.harold.fsm.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class BaseDaoImpl implements BaseDao {

	@Override
	public Object save(Object object) {
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		try{
			Object o = session.save(object);
			tx.commit();
			return o;
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
		return null;
	}

	@Override
	public void persist(Object object) {
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		try{
			session.persist(object);
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
	}

	@Override
	public void update(Object object) {
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		try{
			session.update(object);
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
	}

	@Override
	public void delete(Object object) {
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		try{
			session.delete(object);
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Object find(Class clazz, Long id) {
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		try{
			Object o = session.load(clazz, id);
			tx.commit();
			return o;
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
		return null;
	}
	
	public Session getSession(){
		return HibernateUtil.getSession();
	}
}
