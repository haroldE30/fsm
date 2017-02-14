package org.harold.fsm.hibernate.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory(){
		try{
			return new Configuration().configure().buildSessionFactory();
		}catch(Throwable ex){
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static Session getSession() throws HibernateException {         
		Session sess = null;       
		try {         
			sess = sessionFactory.getCurrentSession();  
		} catch (org.hibernate.HibernateException he) {  
			sess = sessionFactory.openSession();     
		}             
		return sess;
	} 
}
